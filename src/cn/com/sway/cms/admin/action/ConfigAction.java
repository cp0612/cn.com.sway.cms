package cn.com.sway.cms.admin.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import cn.com.sway.cms.config.model.Config;
import cn.com.sway.cms.config.service.ConfigService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("admin/config")
@Namespace("/admin/config")
public class ConfigAction extends ActionSupport {
	
	private String  redirectNotic;
	private String redirectURL;
	
	private Config config;
	private ConfigService configService;

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

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public ConfigService getConfigService() {
		return configService;
	}

	public void setConfigService(ConfigService configService) {
		this.configService = configService;
	}

	@Action(value="index",results={
			@Result(name ="success", location = "/admin/config/index.jsp")
	}) 
	public String index(){
		
		List<Config> configList = this.configService.list("FROM Config config ORDER BY config.orderNum ASC");
		ServletActionContext.getRequest().setAttribute("configList", configList);
		
		if(this.config!=null){
			this.config = this.configService.get(this.config.getId());
		}
		
		return SUCCESS;
	}
	
	@Action(value="saveOrUpdate",results={
			@Result(name ="success", location = "/admin/redirect.jsp"),
			@Result(name ="input", location = "/admin/config/index.jsp")
	})
	public String saveOrUpdate(){
		
		//验证环节
		//验证config.id
		//System.out.println("config.id = "+this.config.getId());
		if(this.config.getId()==null||this.config.getId().equals("")){	//判断config.id是否为空
			if(this.config.getId().length()<2||this.config.getId().length()>50){
				this.addFieldError("config.id", "ID的长度必须在2-50之间。");
			}else if(this.config.getId().matches("[^\\w+$]")!=true){	//判断config.id是否由数字、26个英文字母或者下划线组成的字符串 
				this.addFieldError("config.id", "ID必须是由数字、26个英文字母或者下划线组成的字符串。");
			}else if(this.configService.get(this.config.getId())!=null){	//判断config.id在数据库中是否已经存在
				this.addFieldError("config.id", "已存在相同的config.id。");	//存在的话返回错误信息
			}
		}
		//判断config.remark的长度
		System.out.println("config.remark = "+this.config.getRemark());
		if(this.config.getRemark().length()>255){
			this.addFieldError("config.remark", "备注信息不能超过255个字符。");
		}
		//判断config.allowDelete的正确性
		//System.out.println("config.allowDelete = "+this.config.isAllowDelete());
		if(this.config.isAllowDelete()){
			//......
		}
		//判断config.orderNum的最大值
		//System.out.println("config.orderNum = "+this.config.getOrderNum());
		if(this.config.getOrderNum()==null){
			this.config.setOrderNum(999);
		}else if(this.config.getOrderNum()<0||this.config.getOrderNum()>999){
			//System.out.println("***************:"+this.config.getOrderNum());
			this.addFieldError("config.orderNum", "排序号码的值范围必须在0-999之间。");
		}
		//判断config.maxLength的最大值
		//System.out.println("config.maxLength = "+this.config.getMaxLength());
		if(this.config.getMaxLength()==null){
			this.config.setMaxLength(0);
		}
		//判断config.type的类型是否正确
		//System.out.println("config.value = "+this.config.getValue());
		if(this.config.getType()==null||this.config.getType().equals("")){
			this.addFieldError("config.type", "请选择参数类型。");
		}else{
			switch(this.config.getType()){
				case "int":
					//System.out.println("config.type = int");
					if(this.config.getValue().matches("^-?\\d+$")!=true){	//判断config.value
						this.addFieldError("config.value", "当参数类型为int时值只能输入整数");
					}
					if(this.config.getValue()==null||this.config.getValue().equals("")){	//config.value为空时则为0
						this.config.setValue("0");
					}
					break;
				case "float":
					//System.out.println("config.type = float");
					if(this.config.getValue().matches("^(-?\\d+)(\\.\\d+)?$")!=true){	//判断config.value
						this.addFieldError("config.value", "当config.type为float时，此值只能输入浮点数");		//config.value为空时则为0
					}
					if(this.config.getValue()==null||this.config.getValue().equals("")){
						this.config.setValue("0");
					}
					break;
				case "boolean":
					//System.out.println("config.type = boolean");
					if(!(this.config.getValue().equals("0")||this.config.getValue().equals("1"))){	//判断config.value
						this.addFieldError("config.value", "当config.type为boolean时，此值只能输入“1(true)”或“0(false)”。");
					}
					break;
				case "text":
					//System.out.println("config.type = text");
					break;
				default:
					this.addFieldError("config.type", "参数类型设置不正确，请勿进行非法操作。");
					break;
			}
		}
		//最后判断是否存在输入错误，存在的话则返回input
		if(this.hasFieldErrors()){
			List<Config> configList = this.configService.list("FROM Config config ORDER BY config.orderNum ASC");
			ServletActionContext.getRequest().setAttribute("configList", configList);
			return INPUT;
		}
		
		this.configService.saveOrUpdate(this.config);
		ServletActionContext.getContext().getApplication().remove("configMap");
		
		this.redirectNotic = "config参数添加成功！";
		this.redirectURL = "admin/config/index";
		return SUCCESS;
	}

	@Action(value="delete",results={
			@Result(name ="success", location = "/admin/redirect.jsp")
	}) 
	public String delete(){
		
		if(this.config!=null){
			
			this.config = this.configService.get(this.config.getId());
			
			if(this.config.isAllowDelete()){
				
				this.configService.delete(this.config);
				ServletActionContext.getContext().getApplication().remove("configMap");
				
				this.redirectNotic = "config参数删除成功！";
				this.redirectURL = "admin/config/index";
			}else{
				this.redirectNotic = "此参数不允许删除！";
				this.redirectURL = "admin/config/index";
			}
		}
		
		return SUCCESS;
	}
}
