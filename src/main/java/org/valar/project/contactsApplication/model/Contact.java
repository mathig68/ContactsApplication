package org.valar.project.contactsApplication.model;

public class Contact {
	private Integer contactid;
	private Integer userid;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String remark;
		
	public Contact(Integer userid, String name, String email, String address, String phone,
			String remark) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getContactId() {
		return contactid;
	}
	public void setContactId(Integer contactId) {
		this.contactid = contactId;
	}
	public Integer getUserId() {
		return userid;
	}
	public void setUserId(Integer userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Contact() {}
	@Override
	public String toString() {
		return "Contact [contactid=" + contactid + ", userid=" + userid + ", name=" + name + ", email=" + email
				+ ", address=" + address + ", phone=" + phone + ", remark=" + remark + "]";
	}
	
	
	
}
