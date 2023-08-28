package org.spring.lmsproject.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.spring.lmsproject.dao.InstructorDao;
import org.spring.lmsproject.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDao instructorDao;

	@Override
	@Transactional
	public List<Instructor> findAllInstructor() {
		// TODO Auto-generated method stub
		List<Instructor> findAllInstructor = instructorDao.findAllInstructor();
		for(Instructor instructor:findAllInstructor) {
			Hibernate.initialize(instructor.getCourses());
		}
		return findAllInstructor;
	}

	@Override
	@Transactional
	public void saveInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		instructorDao.saveInstructor(instructor);
	}

	@Override
	@Transactional
	public Instructor searchInstructor(int id) {
		// TODO Auto-generated method stub
		Instructor instructor = instructorDao.searchInstructor(id);
		return instructor;
	}

	@Override
	@Transactional
	public List<Instructor> searchInstructorByName(String name) {
		// TODO Auto-generated method stub
		return instructorDao.searchInstructorByName(name);
	}

	@Override
	@Transactional
	public void deleteInstructor(int id) {
		// TODO Auto-generated method stub
		instructorDao.deleteInstructor(id);
	}

}
