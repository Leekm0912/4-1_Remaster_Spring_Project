package db.vo;

import org.hibernate.validator.constraints.NotBlank;

public class UserVO {
	@NotBlank
	private String id;
	@NotBlank
	private String pw;
	@NotBlank
	private String name;
	@NotBlank
	private String phoneNumber;
	private String userType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "이름 : " + this.name + " id : " + this.id + " 타입 : " + this.userType;
	}

}
