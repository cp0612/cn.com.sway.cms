package cn.com.sway.cms.web.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import cn.com.sway.cms.archive.service.ArchiveService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("default")
//@Results({@Result(name="success", type="freemarker", location="index.ftl")})
public class IndexAction extends ActionSupport {
	
	public Map<String, String> getConfigMap() {
		return (Map<String, String>) ServletActionContext.getContext().getApplication().get("configMap");
	}
	
	private ArchiveService archiveService;

	public ArchiveService getArchiveService() {
		return archiveService;
	}

	public void setArchiveService(ArchiveService archiveService) {
		this.archiveService = archiveService;
	}

	//@Action(value="/index",results=@Result(name="success", type="freemarker", location="${configMap.templatePath}index.ftl"))
	//@Action(value="/index",results=@Result(name="success", location="templates/default/index.jsp"))
	@Action(value="/index",results=@Result(name="success", type="dispatcher", location="${configMap.templatePath}index.jsp"))
	public String index(){
		
		ServletActionContext.getRequest().setAttribute("jiamengNewsList", this.archiveService.list("FROM Archive archive WHERE page.id='1265ab00-9d4f-43d0-be1e-4caacbc8a5a1' ORDER BY archive.datetime DESC", 1, 5, new Object[]{}));
		
		ServletActionContext.getContext().getSession().put("user" , "cp锋");
		
		return SUCCESS;
	}
	
}
