package cn.com.sway.cms.uploadImages.model;

import cn.com.sway.cms.archive.model.Archive;

public class UploadImages {

	private String id;
	
	private Archive archive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

}
