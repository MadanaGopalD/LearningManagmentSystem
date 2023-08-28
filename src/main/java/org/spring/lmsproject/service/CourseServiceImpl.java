package org.spring.lmsproject.service;

import org.spring.lmsproject.dao.CourseDaoImpl;
import org.spring.lmsproject.entity.Course;
import org.spring.lmsproject.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDaoImpl courseDao;

	@Override
	@Transactional
	public Course findCourseById(int id) {
		// TODO Auto-generated method stub
		Course course=courseDao.findCourseById(id);
		return course;
	}

	@Override
	@Transactional
	public Lesson findLessonById(int id) {
		// TODO Auto-generated method stub
		Lesson lesson=courseDao.findLessonById(id);
		return lesson;
	}

	@Override
	@Transactional
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.addCourse(course);
	}

	@Override
	@Transactional
	public void addLesson(Lesson lesson) {
		// TODO Auto-generated method stub
		courseDao.addLesson(lesson);
	}

}
