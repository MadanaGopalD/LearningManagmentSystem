package org.spring.lmsproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Lessons")
public class Lesson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lessons_id;
	
	@Column(name="Lesson_Text")
	private String lessonText;
	
	@Column(name="link")
	private String link;
	
	@Column(name="Lesson_Name")
	private String name;
	
	@JoinColumn(name="course_id")
	@ManyToOne
	private Course course;

	public int getLessons_id() {
		return lessons_id;
	}

	public void setLessons_id(int lessons_id) {
		this.lessons_id = lessons_id;
	}

	public String getLessonText() {
		return lessonText;
	}

	public void setLessonText(String lessonText) {
		this.lessonText = lessonText;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Lesson [lessons_id=" + lessons_id + ", lessonText=" + lessonText + ", link=" + link + ", name=" + name
				+ "]";
	}
	
}
