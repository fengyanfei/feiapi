package com.fei.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * * 等额本金 Created on 2018/1/22.
 * 是指一种贷款的还款方式，是在还款期内把贷款数总额等分，每月偿还同等数额的本金和剩余贷款在该月所产生的利息，这样由于每月的还款本金额固定，
 * 而利息越来越少，借款人起初还款压力较大，但是随时间的推移每月还款数也越来越少。
 */
public class AverageCapitalUtils {
	
	public static double getCombinationInterestCount(double accInvest, double accYearRate,
			int accTotalmonth, double busInvest, double busYearRate, int busTotalmonth) {
		double monthIncome = getInterestCount(accInvest,accYearRate,accTotalmonth);
		double monthIncome1 = getInterestCount(busInvest,busYearRate,busTotalmonth);
		return monthIncome+monthIncome1;
	}
	
	public static Map<Integer, Double> getCombinationPerMonthPrincipal(double accInvest, int accTotalmonth,double busInvest, int busTotalmonth) {
		Map<Integer, Double> mapPrincipal = new HashMap<Integer, Double>();
		double monthIncome = getPerMonthPrincipal(accInvest, accTotalmonth);
		double monthIncome1 = getPerMonthPrincipal(busInvest, busTotalmonth);
		int maxMonth = Math.max(accTotalmonth, busTotalmonth);
		for (int i = 1; i <= maxMonth; i++) {
			if (i > accTotalmonth) {
				mapPrincipal.put(i, monthIncome1);
			} else if (i > busTotalmonth) {
				mapPrincipal.put(i, monthIncome);
			} else {
				mapPrincipal.put(i, monthIncome1+(monthIncome));
			}
		}
		return mapPrincipal;
	}
	
	//组合贷
	public static Map<Integer, Double> getCombinationPerMonthPrincipalInterest(double accInvest, double accYearRate,
			int accTotalmonth, double busInvest, double busYearRate, int busTotalmonth) {
		Map<Integer, Double> mapPrincipal = new HashMap<Integer, Double>();
		Map<Integer, Double> perMonthPrincipal = getPerMonthPrincipalInterest(accInvest, accYearRate, accTotalmonth);
		Map<Integer, Double> perMonthPrincipal2 = getPerMonthPrincipalInterest(busInvest, busYearRate, busTotalmonth);
		int maxMonth = Math.max(accTotalmonth, busTotalmonth);
		for (int i = 1; i <= maxMonth; i++) {
			if (perMonthPrincipal.get(i) == null) {
				mapPrincipal.put(i, perMonthPrincipal2.get(i));
			} else if (perMonthPrincipal2.get(i) == null) {
				mapPrincipal.put(i, perMonthPrincipal.get(i));
			} else {
				mapPrincipal.put(i, perMonthPrincipal2.get(i) + (perMonthPrincipal.get(i)));
			}
		}
		return mapPrincipal;
	}
	//组合贷
	public static Map<Integer, Double> getCombinationPerMonthInterest(double accInvest, double accYearRate,
			int accTotalmonth, double busInvest, double busYearRate, int busTotalmonth) {
		Map<Integer, Double> mapPrincipal = new HashMap<Integer, Double>();
		Map<Integer, Double> perMonthPrincipal = getPerMonthInterest(accInvest, accYearRate, accTotalmonth);
		Map<Integer, Double> perMonthPrincipal2 = getPerMonthInterest(busInvest, busYearRate, busTotalmonth);
		int maxMonth = Math.max(accTotalmonth, busTotalmonth);
		for (int i = 1; i <= maxMonth; i++) {
			if (perMonthPrincipal.get(i) == null) {
				mapPrincipal.put(i, perMonthPrincipal2.get(i));
			} else if (perMonthPrincipal2.get(i) == null) {
				mapPrincipal.put(i, perMonthPrincipal.get(i));
			} else {
				mapPrincipal.put(i, perMonthPrincipal2.get(i)+(perMonthPrincipal.get(i)));
			}
		}
		return mapPrincipal;
	}

	/**
	 * 等额本金计算获取还款方式为等额本金的每月偿还本金和利息 公式：每月偿还本金=(贷款本金÷还款月数)+(贷款本金-已归还本金累计额)×月利率
	 *
	 * @param invest
	 *            总借款额（贷款本金）
	 * @param yearRate
	 *            年利率
	 * @param totalMonth
	 *            还款总月数
	 * @return 每月偿还本金和利息,不四舍五入，直接截取小数点最后两位
	 */
	public static Map<Integer, Double> getPerMonthPrincipalInterest(double invest, double yearRate, int totalMonth) {
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		// 每月本金
		double monthPri = getPerMonthPrincipal(invest, totalMonth);
		// 获取月利率
		double monthRate = yearRate / 12;
		monthRate = new BigDecimal(monthRate).setScale(6, BigDecimal.ROUND_DOWN).doubleValue();
		for (int i = 1; i <= totalMonth; i++) {
			double monthRes = monthPri + (invest - monthPri * (i - 1)) * monthRate;
			monthRes = new BigDecimal(monthRes).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
			map.put(i, monthRes);
		}
		return map;
	}

	/**
	 * 等额本金计算获取还款方式为等额本金的每月偿还利息
	 *
	 * 公式：每月应还利息=剩余本金×月利率=(贷款本金-已归还本金累计额)×月利率
	 *
	 * @param invest
	 *            总借款额（贷款本金）
	 * @param yearRate
	 *            年利率
	 * @param totalMonth
	 *            还款总月数
	 * @return 每月偿还利息
	 */
	public static Map<Integer, Double> getPerMonthInterest(double invest, double yearRate, int totalMonth) {
		Map<Integer, Double> inMap = new HashMap<Integer, Double>();
		double principal = getPerMonthPrincipal(invest, totalMonth);
		Map<Integer, Double> map = getPerMonthPrincipalInterest(invest, yearRate, totalMonth);
		for (Map.Entry<Integer, Double> entry : map.entrySet()) {
			BigDecimal principalBigDecimal = new BigDecimal(principal);
			BigDecimal principalInterestBigDecimal = new BigDecimal(entry.getValue());
			BigDecimal interestBigDecimal = principalInterestBigDecimal.subtract(principalBigDecimal);
			interestBigDecimal = interestBigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
			inMap.put(entry.getKey(), interestBigDecimal.doubleValue());
		}
		return inMap;
	}

	/**
	 * 等额本金计算获取还款方式为等额本金的每月偿还本金
	 *
	 * 公式：每月应还本金=贷款本金÷还款月数
	 * 
	 * @param invest
	 *            总借款额（贷款本金）
	 * @param totalMonth
	 *            还款总月数
	 * @return 每月偿还本金
	 */
	public static double getPerMonthPrincipal(double invest, int totalMonth) {
		BigDecimal monthIncome = new BigDecimal(invest).divide(new BigDecimal(totalMonth), 2, BigDecimal.ROUND_DOWN);
		return monthIncome.doubleValue();
	}

	/**
	 * 等额本金计算获取还款方式为等额本金的总利息
	 *
	 * @param invest
	 *            总借款额（贷款本金）
	 * @param yearRate
	 *            年利率
	 * @param totalMonth
	 *            还款总月数
	 * @return 总利息
	 */
	public static double getInterestCount(double invest, double yearRate, int totalMonth) {
		BigDecimal count = new BigDecimal(0);
		Map<Integer, Double> mapInterest = getPerMonthInterest(invest, yearRate, totalMonth);

		for (Map.Entry<Integer, Double> entry : mapInterest.entrySet()) {
			count = count.add(new BigDecimal(entry.getValue()));
		}
		return count.doubleValue();
	}

}
