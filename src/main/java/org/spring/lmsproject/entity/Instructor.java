package org.spring.lmsproject.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="instructors")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Instructor_Name")
	private String name;
	
	@Column(name="Instructor_Exp")
	private float experience;
	
	@Column(name="Email")
	private String email;
	
//	@OneToMany(mappedBy = "instructor",fetch = FetchType.EAGER)
	@OneToMany(mappedBy = "instructor",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Course> courses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", experience=" + experience + ", email=" + email
				+ ", course=" + getCourses() + "]";
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourse(List<Course> courses) {
		this.courses = courses;
	}

}
