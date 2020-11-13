package com.fei.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * * �ȶ�� Created on 2018/1/22.
 * ��ָһ�ִ���Ļ��ʽ�����ڻ������ڰѴ������ܶ�ȷ֣�ÿ�³���ͬ������ı����ʣ������ڸ�������������Ϣ����������ÿ�µĻ�����̶���
 * ����ϢԽ��Խ�٣�������������ѹ���ϴ󣬵�����ʱ�������ÿ�»�����ҲԽ��Խ�١�
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
	
	//��ϴ�
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
	//��ϴ�
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
	 * �ȶ������ȡ���ʽΪ�ȶ���ÿ�³����������Ϣ ��ʽ��ÿ�³�������=(�����»�������)+(�����-�ѹ黹�����ۼƶ�)��������
	 *
	 * @param invest
	 *            �ܽ�������
	 * @param yearRate
	 *            ������
	 * @param totalMonth
	 *            ����������
	 * @return ÿ�³����������Ϣ,���������룬ֱ�ӽ�ȡС���������λ
	 */
	public static Map<Integer, Double> getPerMonthPrincipalInterest(double invest, double yearRate, int totalMonth) {
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		// ÿ�±���
		double monthPri = getPerMonthPrincipal(invest, totalMonth);
		// ��ȡ������
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
	 * �ȶ������ȡ���ʽΪ�ȶ���ÿ�³�����Ϣ
	 *
	 * ��ʽ��ÿ��Ӧ����Ϣ=ʣ�౾���������=(�����-�ѹ黹�����ۼƶ�)��������
	 *
	 * @param invest
	 *            �ܽ�������
	 * @param yearRate
	 *            ������
	 * @param totalMonth
	 *            ����������
	 * @return ÿ�³�����Ϣ
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
	 * �ȶ������ȡ���ʽΪ�ȶ���ÿ�³�������
	 *
	 * ��ʽ��ÿ��Ӧ������=�����»�������
	 * 
	 * @param invest
	 *            �ܽ�������
	 * @param totalMonth
	 *            ����������
	 * @return ÿ�³�������
	 */
	public static double getPerMonthPrincipal(double invest, int totalMonth) {
		BigDecimal monthIncome = new BigDecimal(invest).divide(new BigDecimal(totalMonth), 2, BigDecimal.ROUND_DOWN);
		return monthIncome.doubleValue();
	}

	/**
	 * �ȶ������ȡ���ʽΪ�ȶ�������Ϣ
	 *
	 * @param invest
	 *            �ܽ�������
	 * @param yearRate
	 *            ������
	 * @param totalMonth
	 *            ����������
	 * @return ����Ϣ
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
