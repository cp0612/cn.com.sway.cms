package cn.com.sway.cms.admin.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import cn.com.sway.cms.archive.model.Archive;
import cn.com.sway.cms.archive.service.ArchiveService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("admin/archive")
@Namespace("/admin/archive")
public class ArchiveAction extends ActionSupport {
	
	private String  redirectNotic;
	private String redirectURL;
	
	private File file;
	private String fileContentType;
	private String fileFileName;
	private String savePath;
	
	private Archive archive;
	private ArchiveService archiveService;

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
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

	public ArchiveService getArchiveService() {
		return archiveService;
	}

	public void setArchiveService(ArchiveService archiveService) {
		this.archiveService = archiveService;
	}

	@Action(value="index",results={
			@Result(name ="success", location = "/admin/archive/index.jsp")
	}) 
	public String index(){
		
		List<Archive> archiveList = null;
		
		if(this.archive!=null){
			if(this.archive.getPage()!=null){
				if(this.archive.getPage().getId()!=null){
					archiveList = this.archiveService.list("FROM Archive archive WHERE archive.page.id=? ORDER BY archive.datetime DESC",new Object[]{this.archive.getPage().getId()});
				}
			}
		}else{
			archiveList = this.archiveService.list("FROM Archive archive ORDER BY archive.datetime DESC");
		}
		
		ServletActionContext.getRequest().setAttribute("archiveList", archiveList);
		
		return SUCCESS;
	}
	
	@Action(value="edit",results={
			@Result(name ="success", location = "/admin/archive/edit.jsp")
	}) 
	public String edit(){
		
		//archive.page.id任何情况都不为null且不为空值
		
		//新建的时候archive.id=""
		if(this.archive.getId().equals("")){
			//this.archive = this.archiveService.get(this.archive.getId());
			/*if(this.archive.getDatetime()==null){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
				this.archive.setDatetime(new Date());
			}*/

			System.out.println((new SimpleDateFormat("HH:mm:ss")).format(Calendar.getInstance().getTime()));//显示当前时间
			this.archive.setDatetime(new Date());
			System.out.println("**********:"+this.archive.getDatetime());
		}else{
			this.archive = this.archiveService.get(this.archive.getId());
		}
		return SUCCESS;
	}
	
	@Action(value="saveOrUpdate",results={
			@Result(name ="success", location = "/admin/redirect.jsp"),
			@Result(name ="input", location = "/admin/archive/index.jsp")
	})
	public String saveOrUpdate(){
		
		//验证环节
		//判断archive是否为新条目,是的话则设定id为null以让系统生成主键
		if(this.archive.getId()==null||this.archive.getId().equals("")){
			this.archive.setId(null);
		}
		//检查上传文件是否为空
		if(this.file==null||this.file.equals("")){
			//没有需要上传的文件
		}else{
			if(this.getFileContentType().indexOf("image/pjpeg")!=0){
				this.addFieldError("file", "只允许上传jpg文件。");
			}
		}
		//最后判断是否存在输入错误，存在的话则返回input
		if(this.hasFieldErrors()){
			return INPUT;
		}
		
		this.archiveService.saveOrUpdate(this.archive);
		
		
		if(this.file!=null&&this.file.equals("")!=true){
			//*********文件上传模块*********
			try{
				//设定图片上传的临时目录
				File srcFile = new File(ServletActionContext.getRequest().getRealPath("/uploads/preview/source"), this.archive.getId()+".jpg");
				//File tagFile = new File(ServletActionContext.getRequest().getRealPath("/uploads/preview/source"), this.archive.getId()+".jpg");
				
				//以服务器的文件保存地址和原文件名建立上传文件输出流
				FileOutputStream fos = new FileOutputStream(srcFile);
				//以上传文件建立一个文件上传流
				FileInputStream fis = new FileInputStream(this.getFile());
				//将上传文件的内容写入服务器
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		this.redirectNotic = "archive项目添加或修改成功！";
		this.redirectURL = "admin/archive/index";
		return SUCCESS;
	}

	@Action(value="delete",results={
			@Result(name ="success", location = "/admin/redirect.jsp")
	}) 
	public String delete(){
		
		if(this.archive!=null){
			
			this.archive = this.archiveService.get(this.archive.getId());
			
			new File(ServletActionContext.getRequest().getRealPath("/uploads/preview/source"), this.archive.getId()+".jpg").delete();
			
			this.archiveService.delete(this.archive);
			
			this.redirectNotic = "archive删除成功！";
			this.redirectURL = "admin/archive/index";
			
		}
		
		return SUCCESS;
	}
}
