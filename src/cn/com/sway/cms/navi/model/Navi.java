package cn.com.sway.cms.navi.model;

import java.util.List;

public class Navi {

	private String id;
	
	private String name;
	
	private String url;
	
	private String target;
	
	private Integer orderNum;
	
	private Navi parent;
	
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Navi getParent() {
		return parent;
	}

	public void setParent(Navi parent) {
		this.parent = parent;
	}

	public List getChildren() {
		return children;
	}

	public void setChildren(List children) {
		this.children = children;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
}
