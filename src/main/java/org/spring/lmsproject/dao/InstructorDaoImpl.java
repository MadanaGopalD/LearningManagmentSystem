package org.spring.lmsproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.spring.lmsproject.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public class InstructorDaoImpl implements InstructorDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Instructor> findAllInstructor() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query<Instructor> query=session.createQuery("select i from Instructor i",Instructor.class);
		List<Instructor> instructors=query.list();
		return instructors;
	}

	@Override
	public void saveInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.persist(instructor);
		System.out.println("saved instructor");
	}

	@Override
	public Instructor searchInstructor(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Instructor instructor=session.get(Instructor.class, id);
		return instructor;
	}

	@Override
	public List<Instructor> searchInstructorByName(String name) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query<Instructor> query=session.createQuery("Select i from Instructor i where i.name like ?1",Instructor.class);
		query.setParameter(1,name+"%");
		return query.list();
	}

	@Override
	public void deleteInstructor(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Instructor instructor=searchInstructor(id);
		session.remove(instructor);
		System.out.println("instructor removed");
	}

}
