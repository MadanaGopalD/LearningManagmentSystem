package org.spring.lmsproject.dao;

import org.spring.lmsproject.entity.Course;
import org.spring.lmsproject.entity.Lesson;

public interface CourseDao {

	public Course findCourseById(int id);
	
	public Lesson findLessonById(int id);

	void addCourse(Course course);

	void addLesson(Lesson lesson);
}
