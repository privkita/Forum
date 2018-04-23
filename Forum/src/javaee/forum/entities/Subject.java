package javaee.forum.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="subjects")
public class Subject implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="subject_id", updatable=false, nullable=false)
	private int subject_id;
	private String title;
	@Lob()
	private String content;
	private Timestamp date;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user_id;
	@OneToMany(mappedBy="subject_id", fetch=FetchType.EAGER)
	@OrderBy("date ASC")
	private Set<Post> posts;

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

}
