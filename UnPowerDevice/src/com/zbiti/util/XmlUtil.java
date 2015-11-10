package com.zbiti.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * XML和java对象之间的转换
 * @author zhaoqi
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class XmlUtil <T>  {

	/**
	 * 实体转换成xml
	 * @param o 需要转换的实体对象
	 * @param c 转换用的Bean类
	 * @return
	 */
	public String getXML(T o,Class c){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(c);

			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			ByteArrayOutputStream ba = new ByteArrayOutputStream();
			marshaller.marshal(o, ba);
			String res_str = ba.toString();
			return res_str;
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * xml转换成实体类
	 * @param str 需转换的XML
	 * @param c 转换用的Bean类
	 * @return
	 */
	public T getBean(String str,Class c){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(c);

			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

			Unmarshaller um = context.createUnmarshaller();
			return (T)(um.unmarshal(new ByteArrayInputStream(str.getBytes())));
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}
