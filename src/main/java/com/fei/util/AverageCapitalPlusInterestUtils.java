package com.fei.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.converter.json.GsonBuilderUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * �ȶϢ���� Created by fei on 2018/1/22.
 * Ҳ�ƶ��ڸ�Ϣ���������ÿ�°���ȵĽ������Ϣ������ÿ�´�����Ϣ���³�ʣ��������㲢���½��塣�Ѱ��Ҵ���ı����ܶ�����Ϣ�ܶ���ӣ�
 * Ȼ��ƽ����̯���������޵�ÿ�����С���Ϊ�����ˣ�ÿ���»������й̶�����ÿ�»�����еı���������µ�������Ϣ�������µݼ���
 */

public class AverageCapitalPlusInterestUtils {

	/**
	 * �ȶϢ�����ȡ���ʽΪ�ȶϢ��ÿ�³����������Ϣ
	 *
	 * ��ʽ��ÿ�³�����Ϣ=�������������ʡ�(1��������)�޻����������¡�(1��������)�޻�������-1��
	 *
	 * @param invest
	 *            �ܽ�������
	 * @param yearRate
	 *            ������
	 * @param totalmonth
	 *            ����������
	 * @return ÿ�³����������Ϣ,���������룬ֱ�ӽ�ȡС���������λ
	 */
	public static BigDecimal getPerMonthPrincipalInterest(double invest, double yearRate, int totalmonth) {
		double monthRate = yearRate / 12;
		BigDecimal monthIncome = new BigDecimal(invest)
				.multiply(new BigDecimal(monthRate * Math.pow(1 + monthRate, totalmonth)))
				.divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 10, BigDecimal.ROUND_UP);
		// return monthIncome.doubleValue();
		return monthIncome;
	}

	/**
	 * �ȶϢ�����ȡ���ʽΪ�ȶϢ��ÿ�³�����Ϣ
	 *
	 * ��ʽ��ÿ�³�����Ϣ=�����������ʡ���(1+������)^��������-(1+������)^(���������-1)���¡�(1+������)^��������-1��
	 *
	 * @param invest
	 *            �ܽ�������
	 * @param yearRate
	 *            ������
	 * @param totalmonth
	 *            ����������
	 * @return ÿ�³�����Ϣ
	 */
	public static Map<Integer, BigDecimal> getPerMonthInterest(double invest, double yearRate, int totalmonth) {
		Map<Integer, BigDecimal> map = new HashMap<Integer, BigDecimal>();
		double monthRate = yearRate / 12;
		BigDecimal monthInterest;
		for (int i = 1; i < totalmonth + 1; i++) {
			BigDecimal multiply = new BigDecimal(invest).multiply(new BigDecimal(monthRate));
			BigDecimal sub = new BigDecimal(Math.pow(1 + monthRate, totalmonth))
					.subtract(new BigDecimal(Math.pow(1 + monthRate, i - 1)));
			monthInterest = multiply.multiply(sub).divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2,
					BigDecimal.ROUND_DOWN);
			monthInterest = monthInterest.setScale(2, BigDecimal.ROUND_DOWN);
			map.put(i, monthInterest);
		}
		return map;
	}

	/**
	 * �ȶϢ�����ȡ���ʽΪ�ȶϢ��ÿ�³�����Ϣ
	 *
	 * ��ʽ��ÿ�³�����Ϣ=�����������ʡ���(1+������)^��������-(1+������)^(���������-1)���¡�(1+������)^��������-1��
	 *
	 * @param invest
	 *            ������
	 * @param yearRate
	 *            ������
	 * @param totalmonth
	 *            ����������
	 * @return ÿ�³�����Ϣ
	 */
	public static Map<Integer, BigDecimal> getPerMonthAlready(double invest, double yearRate, int totalmonth) {
		Map<Integer, BigDecimal> map = new HashMap<Integer, BigDecimal>();
		double monthRate = yearRate / 12;
		BigDecimal monthInterest;
		BigDecimal already;
		for (int i = 1; i < totalmonth + 1; i++) {
			BigDecimal multiply = new BigDecimal(invest).multiply(new BigDecimal(monthRate));
			BigDecimal sub = new BigDecimal(Math.pow(1 + monthRate, totalmonth))
					.subtract(new BigDecimal(Math.pow(1 + monthRate, i - 1)));
			monthInterest = multiply.multiply(sub).divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2,
					BigDecimal.ROUND_DOWN);
			monthInterest = monthInterest.setScale(2, BigDecimal.ROUND_DOWN);
			map.put(i, monthInterest);
		}
		return map;
	}

	/**
	 * �ȶϢ�����ȡ���ʽΪ�ȶϢ��ÿ�³�������
	 *
	 * @param invest
	 *            �ܽ�������
	 * @param yearRate
	 *            ������
	 * @param totalmonth
	 *            ����������
	 * @return ÿ�³�������
	 */
	public static Map<Integer, BigDecimal> getPerMonthPrincipal(double invest, double yearRate, int totalmonth) {
		double monthRate = yearRate / 12;
		BigDecimal monthIncome = new BigDecimal(invest)
				.multiply(new BigDecimal(monthRate * Math.pow(1 + monthRate, totalmonth)))
				.divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2, BigDecimal.ROUND_DOWN);
		Map<Integer, BigDecimal> mapInterest = getPerMonthInterest(invest, yearRate, totalmonth);
		Map<Integer, BigDecimal> mapPrincipal = new HashMap<Integer, BigDecimal>();

		for (Map.Entry<Integer, BigDecimal> entry : mapInterest.entrySet()) {
			mapPrincipal.put(entry.getKey(), monthIncome.subtract(entry.getValue()));
		}
		return mapPrincipal;
	}

	public static void main(String[] args) {
		double mapPrincipal = getCombinationPrincipalInterestCount(100000, 0.0325, 300, 100000, 0.049, 312);
		ObjectMapper mapper = new ObjectMapper();
		Map<Integer, BigDecimal> combinationPerMonthPrincipalInterest = getCombinationPerMonthPrincipalInterest(100000,
				0.0325, 300, 100000, 0.049, 312);
		Map<Integer, Double> remaining = new HashMap<>();
		for (int i = 1; i <= 312; i++) {
			mapPrincipal = BigDecimal.valueOf(mapPrincipal).subtract(combinationPerMonthPrincipalInterest.get(i)).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
			remaining.put(i, mapPrincipal);
		}
		try {
			System.out.println(mapper.writeValueAsString(combinationPerMonthPrincipalInterest));
			System.out.println(mapper.writeValueAsString(remaining));

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public static double getCombinationPrincipalInterestCount(double accInvest, double accYearRate,
			int accTotalmonth, double busInvest, double busYearRate, int busTotalmonth) {
		double monthIncome = getPrincipalInterestCount(accInvest, accYearRate, accTotalmonth);
		double monthIncome1 = getPrincipalInterestCount(busInvest, busYearRate, busTotalmonth);
		return monthIncome+monthIncome1;
	}

	public static Map<Integer, BigDecimal> getCombinationPerMonthPrincipalInterest(double accInvest, double accYearRate,
			int accTotalmonth, double busInvest, double busYearRate, int busTotalmonth) {
		Map<Integer, BigDecimal> mapPrincipal = new HashMap<Integer, BigDecimal>();
		BigDecimal monthIncome = getPerMonthPrincipalInterest(accInvest, accYearRate, accTotalmonth);
		BigDecimal monthIncome1 = getPerMonthPrincipalInterest(busInvest, busYearRate, busTotalmonth);
		int maxMonth = Math.max(accTotalmonth, busTotalmonth);
		for (int i = 1; i <= maxMonth; i++) {
			if (i > accTotalmonth) {
				mapPrincipal.put(i, monthIncome1);
			} else if (i > busTotalmonth) {
				mapPrincipal.put(i, monthIncome);
			} else {
				mapPrincipal.put(i, monthIncome1.add(monthIncome));
			}
		}
		return mapPrincipal;
	}
	
	public static Map<Integer, BigDecimal> getCombinationPerMonthInterest(double accInvest, double accYearRate,
			int accTotalmonth, double busInvest, double busYearRate, int busTotalmonth) {
		Map<Integer, BigDecimal> mapPrincipal = new HashMap<Integer, BigDecimal>();
		Map<Integer, BigDecimal> perMonthPrincipal = getPerMonthInterest(accInvest, accYearRate, accTotalmonth);
		Map<Integer, BigDecimal> perMonthPrincipal2 = getPerMonthInterest(busInvest, busYearRate, busTotalmonth);
		int maxMonth = Math.max(accTotalmonth, busTotalmonth);
		for (int i = 1; i <= maxMonth; i++) {
			if (perMonthPrincipal.get(i) == null) {
				mapPrincipal.put(i, perMonthPrincipal2.get(i));
			} else if (perMonthPrincipal2.get(i) == null) {
				mapPrincipal.put(i, perMonthPrincipal.get(i));
			} else {
				mapPrincipal.put(i, perMonthPrincipal2.get(i).add(perMonthPrincipal.get(i)));
			}
		}
		return mapPrincipal;
	}

	public static Map<Integer, BigDecimal> getCombinationPerMonthAlready(double accInvest, double accYearRate,
			int accTotalmonth, double busInvest, double busYearRate, int busTotalmonth) {
		Map<Integer, BigDecimal> mapPrincipal = new HashMap<Integer, BigDecimal>();
		Map<Integer, BigDecimal> perMonthPrincipal = getPerMonthAlready(accInvest, accYearRate, accTotalmonth);
		Map<Integer, BigDecimal> perMonthPrincipal2 = getPerMonthAlready(busInvest, busYearRate, busTotalmonth);
		int maxMonth = Math.max(accTotalmonth, busTotalmonth);
		for (int i = 1; i <= maxMonth; i++) {
			if (perMonthPrincipal.get(i) == null) {
				mapPrincipal.put(i, perMonthPrincipal2.get(i));
			} else if (perMonthPrincipal2.get(i) == null) {
				mapPrincipal.put(i, perMonthPrincipal.get(i));
			} else {
				mapPrincipal.put(i, perMonthPrincipal2.get(i).add(perMonthPrincipal.get(i)));
			}
		}
		return mapPrincipal;
	}

	public static Map<Integer, BigDecimal> getCombinationPerMonthPrincipal(double accInvest, double accYearRate,
			int accTotalmonth, double busInvest, double busYearRate, int busTotalmonth) {
		Map<Integer, BigDecimal> mapPrincipal = new HashMap<Integer, BigDecimal>();
		Map<Integer, BigDecimal> perMonthPrincipal = getPerMonthPrincipal(accInvest, accYearRate, accTotalmonth);
		Map<Integer, BigDecimal> perMonthPrincipal2 = getPerMonthPrincipal(busInvest, busYearRate, busTotalmonth);
		int maxMonth = Math.max(accTotalmonth, busTotalmonth);
		for (int i = 1; i <= maxMonth; i++) {
			if (perMonthPrincipal.get(i) == null) {
				mapPrincipal.put(i, perMonthPrincipal2.get(i));
			} else if (perMonthPrincipal2.get(i) == null) {
				mapPrincipal.put(i, perMonthPrincipal.get(i));
			} else {
				mapPrincipal.put(i, perMonthPrincipal2.get(i).add(perMonthPrincipal.get(i)));
			}
		}
		return mapPrincipal;
	}

	/**
	 * �ȶϢ�����ȡ���ʽΪ�ȶϢ������Ϣ
	 *
	 * @param invest
	 *            �ܽ�������
	 * @param yearRate
	 *            ������
	 * @param totalmonth
	 *            ����������
	 * @return ����Ϣ
	 */
	public static double getInterestCount(double invest, double yearRate, int totalmonth) {
		BigDecimal count = new BigDecimal(0);
		Map<Integer, BigDecimal> mapInterest = getPerMonthInterest(invest, yearRate, totalmonth);

		for (Map.Entry<Integer, BigDecimal> entry : mapInterest.entrySet()) {
			count = count.add(entry.getValue());
		}
		return count.doubleValue();
	}

	/**
	 * Ӧ�������ܺ�
	 *
	 * @param invest
	 *            �ܽ�������
	 * @param yearRate
	 *            ������
	 * @param totalmonth
	 *            ����������
	 * @return Ӧ�������ܺ�
	 */
	public static double getPrincipalInterestCount(double invest, double yearRate, int totalmonth) {
		double monthRate = yearRate / 12;
		BigDecimal perMonthInterest = new BigDecimal(invest)
				.multiply(new BigDecimal(monthRate * Math.pow(1 + monthRate, totalmonth)))
				.divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2, BigDecimal.ROUND_DOWN);
		BigDecimal count = perMonthInterest.multiply(new BigDecimal(totalmonth));
		count = count.setScale(2, BigDecimal.ROUND_DOWN);
		return count.doubleValue();
	}

	public static BigDecimal getPrincipalInterestCount1(double invest, double yearRate, int totalmonth) {
		double monthRate = yearRate / 12;
		BigDecimal perMonthInterest = new BigDecimal(invest)
				.multiply(new BigDecimal(monthRate * Math.pow(1 + monthRate, totalmonth)))
				.divide(new BigDecimal(Math.pow(1 + monthRate, totalmonth) - 1), 2, BigDecimal.ROUND_HALF_UP);
		BigDecimal count = perMonthInterest.multiply(new BigDecimal(totalmonth));
		return count;
	}

}