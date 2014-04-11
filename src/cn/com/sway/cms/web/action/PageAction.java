package cn.com.sway.cms.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import cn.com.sway.cms.archive.model.Archive;
import cn.com.sway.cms.archive.service.ArchiveService;
import cn.com.sway.cms.page.model.Page;
import cn.com.sway.cms.page.service.PageService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("default")
public class PageAction extends ActionSupport {
	
	public Map<String, String> getConfigMap() {
		return (Map<String, String>) ServletActionContext.getContext().getApplication().get("configMap");
	}
	
	private int pageNum = 1;
	private int pageSize = 12;
	private int pageCount;
	
	private Page page;
	private PageService pageService;
	
	private ArchiveService archiveService;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public PageService getPageService() {
		return pageService;
	}

	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	public ArchiveService getArchiveService() {
		return archiveService;
	}

	public void setArchiveService(ArchiveService archiveService) {
		this.archiveService = archiveService;
	}

	@Action(value="/page",results=@Result(name="success", type="dispatcher", location="${configMap.templatePath}${page.templateFile}"))
	public String page(){
		
		this.page = this.pageService.get(this.page.getId());
		
		//System.out.println("*************:"+this.page.getChildren().size());
		
		//判断当前页面是否有指定的模板文件
		if(this.page.getTemplateFile()==null||this.page.getTemplateFile().equals("")){
			//当没有的时候往上级页面查找
			if(this.page.getParent()!=null){
				if(this.page.getParent().getTemplateFile()==null||this.page.getParent().getTemplateFile().equals("")){
					this.page.setTemplateFile("page.jsp");
				}else{
					this.page.setTemplateFile(this.page.getParent().getTemplateFile());
				}
			}else{
				this.page.setTemplateFile("page.jsp");
			}
		}
		
		//处理子页面商品
		ArrayList pageIdList = new ArrayList();
		pageIdList.add(this.page.getId());
		//判断当前页面是否为父页面及该页面下是否含子页面
		if(this.page.getParent()==null&&this.page.getChildren().size()>0){
			for(Page child:(List<Page>)this.page.getChildren()){
				pageIdList.add(child.getId());
			}
		}
		String hql = "FROM Archive archive WHERE ";
		for(int i=0; i<pageIdList.size();i++){
			hql = hql + "archive.page.id='" + pageIdList.get(i) + "'";
			if(i < pageIdList.size()-1){
				hql = hql + " OR ";
			}
		}
		hql = hql + " ORDER BY archive.datetime DESC";
		//System.out.println("******HQL:"+hql);
		this.pageCount = (int)(this.archiveService.list(hql).size()-1)/this.pageSize+1;
		System.out.println(Math.ceil(this.archiveService.list(hql).size()/this.pageSize));
		List<Archive> archiveList = this.archiveService.list(hql,this.pageNum,this.pageSize,new Object[]{});
		ServletActionContext.getRequest().setAttribute("archiveList", archiveList);
		
		return SUCCESS;
	}
}
