package org.spring.lmsproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spring.lmsproject.entity.Course;
import org.spring.lmsproject.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl implements CourseDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Course findCourseById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Course course=session.get(Course.class, id);
		return course;
	}

	@Override
	public Lesson findLessonById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Lesson lession=session.get(Lesson.class, id);
		return lession;
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.persist(course);
//		Course myCourse=session.merge(course);
//		System.out.println("saved course");
//		return myCourse.getCourse_id();
	}

	@Override
	public void addLesson(Lesson lesson) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.merge(lesson);
	}

}
