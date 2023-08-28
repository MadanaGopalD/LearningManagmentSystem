package org.spring.lmsproject.dao;

import java.util.List;

import org.spring.lmsproject.entity.Instructor;

public interface InstructorDao {

	public List<Instructor> findAllInstructor();
	
	public void saveInstructor(Instructor instructor);
	
	public Instructor searchInstructor(int id);

	public List<Instructor> searchInstructorByName(String name);

	public void deleteInstructor(int id);
}
