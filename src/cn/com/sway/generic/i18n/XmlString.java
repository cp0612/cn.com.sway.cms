package cn.com.sway.generic.i18n;

import java.util.Random;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.Servlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/**
 * 国际化字段管理类
 * 
 * @author 王鸿
 * 
 */
public class XmlString {

	// 当前语言编码
	public String currentLanguageCode;
	// 默认语言编码
	public String defaultLanguageCode = "zh";
	// 保存XML数据库字段内容
	private String xmlContent;
	// 缓存当前编码下的字段值
	private String value;

	public String getXmlContent() {
		return xmlContent;
	}

	public void setXmlContent(String xmlContent) {
		// XML解析
		XmlValueLanguageParser parser = parser = new XmlValueLanguageParser(xmlContent);
		// 根据当前编码，解析出字段内容
		value = parser.getString(currentLanguageCode);
		this.xmlContent = xmlContent;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		
//		int randomInt = (new Random()).nextInt();
//		System.out.println(randomInt+":set前:"+xmlContent);
		
		XmlValueLanguageParser parser = new XmlValueLanguageParser(xmlContent);
		parser.setString(currentLanguageCode, (new XmlValueFromHtmlString()).escape(value));//传递值之前使Html转义至Xml码
//		parser.setString(currentLanguageCode, value);
		this.xmlContent = parser.getXmlContent();
		this.value = value;
		
//		System.out.println(randomInt+":set后:"+xmlContent);
	}

	public XmlString() {
		// 当前语言编码保存在session,从session中获取当前语言编码
//		FacesContext context = FacesContext.getCurrentInstance();
//		ExternalContext ec = context.getExternalContext();
//		HttpSession session = (HttpSession) ec.getSession(true);
//		Object lang = session.getAttribute("currentLocaleCode");
//		if (lang != null) {
//			this.currentLanguageCode = (String) lang;
//		} else
//			this.currentLanguageCode = this.defaultLanguageCode;

		String currentLanguageCode = (String)ServletActionContext.getRequest().getSession().getAttribute("currentLanguageCode");

		if(currentLanguageCode!=null){
			this.currentLanguageCode = currentLanguageCode;
		}else{
			this.currentLanguageCode = this.defaultLanguageCode;
		}
		
	}

	// public String toString()
	// {
	// return "Please use the value property.";
	// }
}
