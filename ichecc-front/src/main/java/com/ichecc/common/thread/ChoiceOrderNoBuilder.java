package com.ichecc.common.thread;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ng.bayue.util.DateUtils;
import ng.bayue.util.StringUtils;

public class ChoiceOrderNoBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChoiceOrderNoBuilder.class);

	/**
	 * 锁对象，可以为任意对象
	 */
	private static Object lockObj = "choiceOrderNoLock";
	/**
	 * 编号计数器
	 */
	private static long orderNoCount = 1L;

	// private static String perStr = "";

	/**
	 * 每秒生成编号数量最大值
	 */
	private int maxPerMSECSize = 10000;

	/**
	 * 生成编号
	 * 
	 */
	public String generateOrderNo() {
		try {
			// 最终生成的编号
			String finalOrderNo = "";
			synchronized (lockObj) {
				long nowLong = Long.parseLong(DateUtils.formatDate(new Date(), "yyyyMMddHHmmss"));
				// 计数器到最大值归1，目前1秒处理峰值9999个
				if (orderNoCount >= maxPerMSECSize) {
					orderNoCount = 1L;
				}
				// 组装编号
				String countStr = maxPerMSECSize + orderNoCount + "";
				finalOrderNo = nowLong + countStr.substring(1) + StringUtils.getRandomNum(3);
				orderNoCount++;
				LOGGER.info("编号生成成功：" + finalOrderNo);
				return finalOrderNo;
			}
		} catch (Exception e) {
			LOGGER.error("编号生成失败: {}", e);
			return null;
		}
	}

}
