package cn.com.sway.cms.web.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import cn.com.sway.cms.account.model.Account;
import cn.com.sway.cms.account.service.AccountService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("account")
@Namespace("/account")
public class AccountAction extends ActionSupport {
	
	public Map<String, String> getConfigMap() {
		return (Map<String, String>) ServletActionContext.getContext().getApplication().get("configMap");
	}
	
	private String  redirectNotic;
	private String redirectURL;
	
	private Account account;
	private AccountService accountService;

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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getMenber() {
		return account;
	}

	public void setMenber(Account account) {
		this.account = account;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Action(value="login",
			results=@Result(name="success", type="dispatcher", location="/account/login.jsp")
	)
	public String login(){
		return SUCCESS;
	}
	
	
	private String captcha;
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	@Action(value="loginCheck",
			results={
				@Result(name ="success", location = "/account/redirect.jsp"),
				@Result(name ="input", location = "/account/login.jsp")
			}
	)
	public String loginCheck(){
		
		//输入检查
		if(this.account.getUsername()==null||this.account.getUsername().equals("")){
			this.addFieldError("account.userbname", "请输入您的登录账号。");
		}
		if(this.account.getPassword()==null||this.account.getPassword().equals("")){
			this.addFieldError("account.password", "请输入您的登录密码。");
		}
		if(this.captcha.equals(ServletActionContext.getRequest().getSession().getAttribute("captcha"))!=true){
			this.addFieldError("captcha", "验证码输入错误。");
		}
		if(this.hasFieldErrors()){
			return INPUT;
		}
		//账号密码检查
		if(this.accountService.list("FROM Account account WHERE account.username=? AND account.password=?", new Object[]{this.account.getUsername(),this.account.getPassword()}).size()==0){
			this.addFieldError("account.password", "账号或密码错误,请检查后重新输入。");
		}
		if(this.hasFieldErrors()){
			return INPUT;
		}
		
		//登录正确
		this.account = (Account) this.accountService.list("FROM Account account WHERE account.username=? AND account.password=?", new Object[]{this.account.getUsername(),this.account.getPassword()}).get(0);
		ServletActionContext.getRequest().getSession().setAttribute("account", this.account);
		this.redirectNotic = "登录成功，正在以会员身份进入本站。";
		this.redirectURL = "";
		
		return SUCCESS;
	}
	
	@Action(value="logout",results={
			@Result(name ="success", location = "/account/redirect.jsp"),
	})
	public String logout(){
		
		ServletActionContext.getRequest().getSession().setAttribute("account", this.account);
		this.redirectNotic = "退出登录成功，正在返回网站首页。";
		this.redirectURL = "";
		
		return SUCCESS;
	}
	
}
