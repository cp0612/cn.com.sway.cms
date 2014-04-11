package cn.com.sway.cms.archiveType.model;

import java.util.Date;

import cn.com.sway.cms.page.model.Page;

public class ArchiveType {

	private String id;
	
	private String title;
	
	private Date datetime;
	
	private String html;
	
	private Page page;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
