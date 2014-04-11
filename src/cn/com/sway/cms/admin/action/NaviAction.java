package cn.com.sway.cms.admin.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import cn.com.sway.cms.navi.model.Navi;
import cn.com.sway.cms.navi.service.NaviService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("admin/navi")
@Namespace("/admin/navi")
public class NaviAction extends ActionSupport {
	
	private String  redirectNotic;
	private String redirectURL;
	
	private Navi navi;
	private NaviService naviService;

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
	
	public Navi getNavi() {
		return navi;
	}

	public void setNavi(Navi navi) {
		this.navi = navi;
	}

	public NaviService getNaviService() {
		return naviService;
	}

	public void setNaviService(NaviService naviService) {
		this.naviService = naviService;
	}

	@Action(value="index",results={
			@Result(name ="success", location = "/admin/navi/index.jsp")
	}) 
	public String index(){
		
		List<Navi> naviList = this.naviService.list("FROM Navi navi WHERE navi.parent=null ORDER BY navi.orderNum ASC");
		ServletActionContext.getRequest().setAttribute("naviList", naviList);
		
		if(this.navi!=null){
			this.navi = this.naviService.get(this.navi.getId());
		}
		
		return SUCCESS;
	}
	
	@Action(value="edit",results={
			@Result(name ="success", location = "/admin/navi/edit.jsp")
	}) 
	public String edit(){
		
		//判断是否正在增加新的项目
		if(this.navi.getId()==null||this.navi.getId().equals("")){
			this.navi.setTarget("_self");
			//判断新增的导航是否为"子导航"
			if(this.navi.getParent()!=null){
				if(this.navi.getParent().getId()!=null&&this.navi.getParent().getId().equals("")!=true){
					//获取并设定子导航信息
					this.navi.setParent(this.naviService.get(this.navi.getParent().getId()));
				}
			}
		}else{
			this.navi = this.naviService.get(this.navi.getId());
		}
		
		return SUCCESS;
	}
	
	@Action(value="saveOrUpdate",results={
			@Result(name ="success", location = "/admin/redirect.jsp"),
			@Result(name ="input", location = "/admin/navi/index.jsp")
	})
	public String saveOrUpdate(){
		
		//验证环节
		//判断navi是否为新条目,是的话则设定id为null以让系统生成主键
		if(this.navi.getId()==null||this.navi.getId().equals("")){
			this.navi.setId(null);
			this.redirectNotic = "导航["+this.navi.getName()+"]添加成功！";
		}else{
			this.redirectNotic = "导航["+this.navi.getName()+"]修改成功！";
		}
		//判断标题不能为空
		if(this.navi.getName()==null||this.navi.getName().equals("")){
			this.addFieldError("navi.name", "页面的名称不能为空。");
		}
		//判断navi.orderNum的最大值
		System.out.println("navi.orderNum = "+this.navi.getOrderNum());
		if(this.navi.getOrderNum()==null){
			this.navi.setOrderNum(999);
		}else if(this.navi.getOrderNum()<0||this.navi.getOrderNum()>999){
			System.out.println("***************:"+this.navi.getOrderNum());
			this.addFieldError("navi.orderNum", "排序号码的值范围必须在0-999之间。");
		}
		//最后判断是否存在输入错误，存在的话则返回input
		if(this.hasFieldErrors()){
			List<Navi> naviList = this.naviService.list("FROM Navi navi ORDER BY navi.orderNum ASC");
			ServletActionContext.getRequest().setAttribute("naviList", naviList);
			return INPUT;
		}
		//判断navi.parent.id是否存在,存在的话则当前添加的分类为子分类
		if(this.navi.getParent().getId()==null||this.navi.getParent().getId().equals("")){
			this.navi.setParent(null);
		}else{
			this.navi.setParent(this.naviService.get(this.navi.getParent().getId()));
		}
		
		this.naviService.saveOrUpdate(this.navi);
		this.redirectURL = "admin/navi/index";
		return SUCCESS;
	}

	@Action(value="delete",results={
			@Result(name ="success", location = "/admin/redirect.jsp")
	}) 
	public String delete(){
		
		if(this.navi!=null){
			
			this.navi = this.naviService.get(this.navi.getId());
			
			this.naviService.delete(this.navi);
			this.redirectNotic = "navi删除成功！";
			this.redirectURL = "admin/navi/index";
			
		}
		
		return SUCCESS;
	}
}
