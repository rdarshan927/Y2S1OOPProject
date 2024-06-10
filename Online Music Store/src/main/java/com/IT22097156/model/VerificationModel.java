package com.IT22097156.model;

public class VerificationModel implements VerificationModelInterface{
    private int id;
    private String fullname;
    private String nic;
    private String mobile;
    private String email;
    private String address;
    private String userID;
    private String status;

    public VerificationModel(int id, String fullname, String nic, String mobile, String email, String address, String userID, String status) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.nic = nic;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.userID = userID;
		this.status = status;
	}
    
    public VerificationModel(String fullname, String nic, String mobile, String email, String address, String userID, String status) {
		super();
		this.fullname = fullname;
		this.nic = nic;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.userID = userID;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
