package javaee.forum.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User implements Serializable{
	
	@Id
	@GeneratedValue
	private int userId;
	private String login;
	private String password;
	private Timestamp date;
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private Set<Subject> subjects;
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private Set<Post> posts;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

}
