package com.training.daos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.training.exceptions.ElementNotFoundException;
import com.training.ifaces.CrudRepository;
import com.training.model.Student;

public class StudentRepositoryImpl implements CrudRepository<Student> {
private List<Student> studentList;

	public StudentRepositoryImpl() {
	super();
	this.studentList = new ArrayList<>();
}

//	@Override
//	public boolean save(Student obj) {
//		return this.studentList.add(obj);
//	}
	
	@Override
	public boolean save(Student obj) throws RuntimeException {
		if(this.studentList.contains(obj)) {
			throw new RuntimeException("Element not found");
		}
		else return this.studentList.add(obj);
	}

	@Override
	public Collection<Student> findAll() {
		return this.studentList;
	}

	@Override
	public boolean delete(Student obj) throws ElementNotFoundException {
		if(this.studentList.contains(obj)) {
			return this.studentList.remove(obj);
		}
		else {
			throw new ElementNotFoundException("ERR-106","Element not found");
		}
		
		
	}
	

}
