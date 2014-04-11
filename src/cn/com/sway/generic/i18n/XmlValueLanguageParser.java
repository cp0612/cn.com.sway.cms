package cn.com.sway.generic.i18n;

import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author 王鸿
 * 解析多语言XML格式的字段
 */
public class XmlValueLanguageParser {
	
	private Document xmlDocument;
	
	/**
	 * 要解析的XML文档内容
	 * @param xmlContent
	 */
	public XmlValueLanguageParser(String xmlContent){
		createDocument(xmlContent);	//创建内容为xmlContent的文档
	}
	
	/**
	 * 当没有任何构造参数时,建立空白的XML文档
	 */
	public XmlValueLanguageParser(){
		createDocument("");	//创建空白的XML文档
	}
	
	/**
	 * 根据语言编号获得对应的文本信息，若无该语言对应的文本，返回NULL
	 * @param languageCode
	 * @return
	 */
	public String getString(String languageCode){
		if(this.xmlDocument==null){
			return null;
		}
		//获得所有的文本结点
		List list = xmlDocument.selectNodes("//items/item");
		if(list==null)
			return null;
		//获得迭代器
		Iterator iterator=list.iterator();
		//查找语言编号对应的XML元素
		while(iterator.hasNext()){
			Element element=(Element)iterator.next();
			//如果存在，则返回XML元素的文本值
			if(element.attributeValue("lang").equals(languageCode)){
				return element.getText();
			}
		}
		
		//*****sway.pro的自我补充****
		//如果找不到含有lang=当前语言的元素,则返回第一个找到的//items/item元素
		iterator=list.iterator();
		if(iterator.hasNext()){
			Element element=(Element)iterator.next();
			return element.getText();
		}
		
		return null;
	}
	
	/**
	 * 设置语言编号对应的文本内容，若该语言不存在，则添加
	 * @param languageCode
	 * @param content
	 */
	public void setString(String languageCode,String content){
		
//		int randomInt = (new Random()).nextInt();
//		System.out.println(randomInt+":set前:"+xmlDocument.asXML());
		List list = xmlDocument.selectNodes("//items/item");
		Iterator iterator=list.iterator();
		boolean isExist=false;
		while(iterator.hasNext()){	//只有还有下一个//items/item元素,仍执行以下代码
			Element element=(Element)iterator.next();	//设置临时元素对象element为该找到的//items/item元素
			String lang = element.attributeValue("lang");	//设置临时语言变量lang为临时元素对象element的lang属性
			if(lang.equals(languageCode)){	//假如该临时语言变量与传入的languageCode变量相同,则执行以下代码
				element.setText(content);	//设置临时元素对象element的内容为传入的content内容
				isExist=true;
				break;
			}
		}
		if(!isExist){	//假如找不到
			Element items=xmlDocument.getRootElement();	//元素对象items为xml文档的根元素	
			Element item=items.addElement("item");	//在items元素对象下添加名为"item"的子元素并返回该子元素对象到item元素对象	
			item.addAttribute("lang", languageCode);	//为刚刚添加的item元素对象添加lang属性	
			item.setText(content);	//设置item元素对象中的内容为content中的内容
		}
//		System.out.println(randomInt+":set后:"+xmlDocument.asXML());
	}
	
	/**
	 * 返回文本的XML格式的内容
	 * @return
	 */
	public String getXmlContent(){
		String removeString="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		return this.xmlDocument.asXML().substring(removeString.length()+1);
	}
	
	/**
	 * 创建XML文档
	 * @throws DocumentException 
	 */
	private void createDocument(String xmlContent){
		if(xmlContent==null) xmlContent="";	//没有创建XML文档才创建
		
		if(this.xmlDocument==null){
			if(xmlContent.trim()!="")
			{
				SAXReader reader = new SAXReader();
				try {
					StringReader sr=new StringReader(xmlContent);
					this.xmlDocument = reader.read(sr);
				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}
			else{
				this.xmlDocument = DocumentHelper.createDocument();
				xmlDocument.addElement("items");
			}
		}
	}
	
}