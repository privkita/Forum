package javaee.forum.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="role_id", updatable=false, nullable=false)
	private int role_id;
	private String login;
	private String role;

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int roleId) {
		this.role_id = roleId;
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
