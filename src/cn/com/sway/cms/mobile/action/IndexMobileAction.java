package cn.com.sway.cms.mobile.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("mobile")
@Namespace("/mobile")
public class IndexMobileAction extends ActionSupport {
	
	public Map<String, String> getConfigMap() {
		return (Map<String, String>) ServletActionContext.getContext().getApplication().get("configMap");
	}
	
	@Action(value="index",results=@Result(name="success", type="dispatcher", location="/${configMap.templatePathForMobile}index.jsp"))
	public String index(){
		System.out.println("*****手机版index页面*****");
		//System.out.println("gnjkgehwrkjghtrghik iutghiuh irtjhgtrhg irtgj rthgio erg rtg hdh iuitgf fghbjk");
		return SUCCESS;
	}

}
