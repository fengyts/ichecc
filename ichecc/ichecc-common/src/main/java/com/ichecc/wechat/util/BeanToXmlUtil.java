package com.ichecc.wechat.util;

import java.lang.reflect.Field;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.dom.DOMElement;

public class BeanToXmlUtil {

	public static void toXml(Class<?> c) {
		Document doc = DocumentHelper.createDocument(new DOMElement("xml"));
		Field[] beanFiles = c.getDeclaredFields();
	}

	public static void main(String[] args) {

	}

}
