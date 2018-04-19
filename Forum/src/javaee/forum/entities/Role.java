package javaee.forum.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role implements Serializable{
	
	@Id
	@GeneratedValue
	private int roleId;
	private String login;
	private String role;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
