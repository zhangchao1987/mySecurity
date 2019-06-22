package cn.itsource.mySecurity.dto;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class UserDto {
	private String userId;
	private String userName;
	private String pwd;
	private String roleId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public UserDto(String userId, String userName, String pwd, String roleId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.pwd = pwd;
		this.roleId = roleId;
	}

	public UserDto() {
		super();
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userName=" + userName + ", pwd=" + pwd + ", roleId=" + roleId + "]";
	}

	public String getToken(UserDto user) {
        String token="";
        token= JWT.create().withAudience(user.getUserId())
                .sign(Algorithm.HMAC256(user.getPwd()));
        return token;
    }
}
