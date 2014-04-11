package cn.com.sway.cms.admin.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("admin")
@Namespace("/admin")
public class BasicAction extends ActionSupport {
	
	@Action(value="index",results={
			@Result(name ="success", location = "/admin/index.jsp")
	}) 
	public String index(){
		return SUCCESS;
	}
	
	@Action(value="top",results={
			@Result(name ="success", location = "/admin/top.jsp")
	}) 
	public String top(){
		return SUCCESS;
	}
	
	@Action(value="sidebar",results={
			@Result(name ="success", location = "/admin/sidebar.jsp")
	}) 
	public String sidebar(){
		return SUCCESS;
	}
	
	@Action(value="information",results={
			@Result(name ="success", location = "/admin/information.jsp")
	}) 
	public String information(){
		return SUCCESS;
	}
	
}
