package org.spring.lmsproject.service;

import org.spring.lmsproject.entity.Course;
import org.spring.lmsproject.entity.Lesson;

public interface CourseService {

	public Course findCourseById(int id);
	
	public Lesson findLessonById(int id);

	public void addCourse(Course course);

	public void addLesson(Lesson lesson);
}
