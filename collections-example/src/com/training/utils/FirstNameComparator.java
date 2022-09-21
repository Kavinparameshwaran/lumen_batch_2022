package com.training.utils;

import java.util.Comparator;

import com.training.model.Student;

public class FirstNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getStudentName().compareTo(o2.getStudentName());
	}

}
