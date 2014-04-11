package cn.com.sway.cms.page.model;

import java.util.List;

public class Page {

	private String id;
	
	private String name;
	
	private Integer orderNum;
	
	private String html;
	
	private String htmlForMobile;
	
	private String templateFile;
	
	private String templateFileForMobile;
	
	private List archives;
	
	private Page parent;
	
	private List children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getTemplateFile() {
		return templateFile;
	}

	public void setTemplateFile(String templateFile) {
		this.templateFile = templateFile;
	}

	public String getHtmlForMobile() {
		return htmlForMobile;
	}

	public void setHtmlForMobile(String htmlForMobile) {
		this.htmlForMobile = htmlForMobile;
	}

	public String getTemplateFileForMobile() {
		return templateFileForMobile;
	}

	public void setTemplateFileForMobile(String templateFileForMobile) {
		this.templateFileForMobile = templateFileForMobile;
	}

	public List getArchives() {
		return archives;
	}

	public void setArchives(List archives) {
		this.archives = archives;
	}

	public Page getParent() {
		return parent;
	}

	public void setParent(Page parent) {
		this.parent = parent;
	}

	public List getChildren() {
		return children;
	}

	public void setChildren(List children) {
		this.children = children;
	}

}
