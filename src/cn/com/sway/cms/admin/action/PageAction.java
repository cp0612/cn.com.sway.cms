package cn.com.sway.cms.admin.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import cn.com.sway.cms.page.model.Page;
import cn.com.sway.cms.page.service.PageService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("admin/page")
@Namespace("/admin/page")
public class PageAction extends ActionSupport {
	
	private String  redirectNotic;
	private String redirectURL;
	
	private Page page;
	private PageService pageService;

	public String getRedirectNotic() {
		return redirectNotic;
	}

	public void setRedirectNotic(String redirectNotic) {
		this.redirectNotic = redirectNotic;
	}

	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
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

	@Action(value="index",results={
			@Result(name ="success", location = "/admin/page/index.jsp")
	}) 
	public String index(){
		
		List<Page> pageList = this.pageService.list("FROM Page page WHERE page.parent=null ORDER BY page.orderNum ASC");
		ServletActionContext.getRequest().setAttribute("pageList", pageList);
		
		if(this.page!=null){
			this.page = this.pageService.get(this.page.getId());
		}
		
		return SUCCESS;
	}

	@Action(value="edit",results={
			@Result(name ="success", location = "/admin/page/edit.jsp")
	}) 
	public String edit(){
		
		//判断是"新增分类"还是"修改分类"
		if(this.page.getId()==null||this.page.getId().equals("")){
			//判断新增的分类是否为"子分类"
			if(this.page!=null){
				if(this.page.getParent()!=null){
					if(this.page.getParent().getId()!=null||  this.page.getParent().getId().equals("")!=true){
						//获取并设定子分类信息
						this.page.setParent(this.pageService.get(this.page.getParent().getId()));
					}
				}
			}
		}else{
			this.page = this.pageService.get(this.page.getId());
		}
		
		return SUCCESS;
	}
	
	@Action(value="saveOrUpdate",results={
			@Result(name ="success", location = "/admin/redirect.jsp"),
			@Result(name ="input", location = "/admin/page/edit.jsp")
	})
	public String saveOrUpdate(){
		
		//验证环节
		//判断page是否为新条目
		if(this.page.getId()==null||this.page.getId().equals("")){
			//设定id为null以让系统生成主键
			this.page.setId(null);
			this.redirectNotic = "页面["+this.page.getName()+"]添加成功！";
		}else{
			this.redirectNotic = "页面["+this.page.getName()+"]修改成功！";
		}
		//判断标题不能为空
		if(this.page.getName()==null||this.page.getName().equals("")){
			this.addFieldError("page.name", "页面的名称不能为空。");
		}
		//判断page.orderNum的最大值
		System.out.println("page.orderNum = "+this.page.getOrderNum());
		if(this.page.getOrderNum()==null){
			this.page.setOrderNum(999);
		}else if(this.page.getOrderNum()<0||this.page.getOrderNum()>999){
			System.out.println("***************:"+this.page.getOrderNum());
			this.addFieldError("page.orderNum", "排序号码的值范围必须在0-999之间。");
		}
		//最后判断是否存在输入错误，存在的话则返回input
		if(this.hasFieldErrors()){
			return INPUT;
		}
		
		//判断page.parent.id是否存在,存在的话则当前添加的分类为子分类
		if(this.page.getParent().getId()==null||this.page.getParent().getId().equals("")){
			this.page.setParent(null);
		}else{
			this.page.setParent(this.pageService.get(this.page.getParent().getId()));
		}
		
		this.pageService.saveOrUpdate(this.page);
		this.redirectURL = "admin/page/index";
		return SUCCESS;
	}

	@Action(value="delete",results={
			@Result(name ="success", location = "/admin/redirect.jsp")
	}) 
	public String delete(){
		
		if(this.page!=null){
			
			this.page = this.pageService.get(this.page.getId());
			
			this.pageService.delete(this.page);
			this.redirectNotic = "page删除成功！";
			this.redirectURL = "admin/page/index";
			
		}
		
		return SUCCESS;
	}
}
