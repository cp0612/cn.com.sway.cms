package cn.com.sway.cms.interceptor;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.com.sway.cms.account.model.Account;
import cn.com.sway.cms.config.service.ConfigService;
import cn.com.sway.cms.navi.model.Navi;
import cn.com.sway.cms.navi.service.NaviService;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminInterceptor extends AbstractInterceptor{
	
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Account account = (Account) ServletActionContext.getRequest().getSession().getAttribute("account");
		//System.out.println("********AdminInterceptor*******");
		
		if(account==null){
			//System.out.println("account==null");
			return "login";
		}else if(account.isAdministrator()==false){
			//System.out.println("account.isAdministrator()==false");
			return "login";
		}
		
		return invocation.invoke();
	}

	
	
}
