package cn.com.sway.generic.i18n;

public class XmlValueFromHtmlString {
	
	public String escape(String str){
		str.replaceAll("<", "&lt;");
		str.replaceAll(">", "&gt;");
		str.replaceAll("&", "&amp;");
		str.replaceAll("\"", "&quot;");
		str.replaceAll("'", "&apos;");
		return str;
	}
	
}
