package com.ichecc.bean;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ng.bayue.util.DateUtils;
import ng.bayue.util.StringUtils;

/**
 *
 * vip会员卡卡号生成器
 * 规则： 8 & 年月日(yyMMddHH格式) & 四位流水号 & 三位随机数 共计16位
 * 
 */
public class VipCardNoGenerator {

	private static Logger logger = LoggerFactory.getLogger(VipCardNoGenerator.class);

	/**
	 * 锁对象，可以为任意对象
	 */
	private static Object lockObj = "vipCardNoLock";
	/**
	 * 支付订单编号计数器
	 */
	private static long vipCardNoCount = 1l;

	private static String perStr = "8";

	/**
	 * 每秒生成支付订单编号数量最大值
	 */
	private int maxPerMSECSize = 10000;

//	static {
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		String yearLastNum = String.valueOf(cal.get(Calendar.YEAR)).substring(2);
//
//		perStr += yearLastNum;
//	}

	/**
	 * 生成支付订单编号
	 * 
	 */
	public String generateVipCardNo() {
		try {
			// 最终生成的会员卡编号
			String finalOrderNo = "";
			String yyMMddHH = "";
			synchronized (lockObj) {
				yyMMddHH = DateUtils.formatDate(new Date(), "yyMMddHH");
				// 计数器到最大值归1，目前1秒处理峰值9999个
				if (vipCardNoCount >= maxPerMSECSize) {
					vipCardNoCount = 1L;
				}
				// 组装支付订单编号
				String countStr = maxPerMSECSize + vipCardNoCount + "";
				finalOrderNo = perStr + yyMMddHH + countStr.substring(1)
						+ StringUtils.getRandomNum(3);
				vipCardNoCount++;
				logger.info("会员卡编号生成成功：" + finalOrderNo);
				return finalOrderNo;
			}
		} catch (Exception e) {
			logger.error("支付订单编号生成失败", e);
			return null;
		}
	}

	// 测试订单编号生成器
//	private static void generatorTest() {
//		try {
//			for (int i = 0; i < 200; i++) {
//				Thread t1 = new Thread(new Runnable() {
//					public void run() {
//						VipCardNoGenerator bean = new VipCardNoGenerator();
//						bean.generateVipCardNo();
//					}
//				}, "at" + i);
//				t1.start();
//
//				Thread t2 = new Thread(new Runnable() {
//					public void run() {
//						VipCardNoGenerator bean = new VipCardNoGenerator();
//						bean.generateVipCardNo();
//					}
//				}, "bt" + i);
//				t2.start();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	public static void main(String[] args) {
//		 generatorTest();
//	}
	
}
