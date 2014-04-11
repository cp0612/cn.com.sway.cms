package cn.com.sway.cms.config.model;

public class Config {

	private String id;
	
	private String remark;
	
	private boolean allowDelete;
	
	private Integer orderNum;
	
	private String type;
	
	private Integer maxLength;
	
	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public boolean isAllowDelete() {
		return allowDelete;
	}

	public void setAllowDelete(boolean allowDelete) {
		this.allowDelete = allowDelete;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
