package db.vo;

import org.hibernate.validator.constraints.NotBlank;

public class LoginCommand {
	@NotBlank
	private String id;
	@NotBlank
	private String pw;
	private String userType;
	private String kakaoUser = "";
	private String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getKakaoUser() {
		return kakaoUser;
	}

	public void setKakaoUser(String kakaoUser) {
		this.kakaoUser = kakaoUser;
	}

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

	@Override
	public String toString() {
		return " id : " + this.id + " 타입 : " + this.userType;
	}
}
