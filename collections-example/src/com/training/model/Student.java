package com.training.model;

public class Student implements Comparable<Student> {

	private String studentName;
	private String studentRollNumber;
	private int studentAge;
	private long studentPhoneNumber;
	private String studentCity;

	
	public Student(String studentName, String studentRollNumber, int studentAge, long studentPhoneNumber,
			String studentCity) {
		super();
		this.studentName = studentName;
		this.studentRollNumber = studentRollNumber;
		this.studentAge = studentAge;
		this.studentPhoneNumber = studentPhoneNumber;
		this.studentCity = studentCity;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentRollNumber() {
		return studentRollNumber;
	}

	public void setStudentRollNumber(String studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public long getStudentPhoneNumber() {
		return studentPhoneNumber;
	}

	public void setStudentPhoneNumber(long studentPhoneNumber) {
		if ((String.valueOf(studentPhoneNumber)).length() <= 10) {
			this.studentPhoneNumber = studentPhoneNumber;
		}
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}
	@Override
	public String toString() {
		return this.studentName + "," + this.studentRollNumber + "," + this.studentAge + "," + this.studentPhoneNumber+","+this.studentCity;
	}

	@Override
	public int compareTo(Student otherObj) {
		if(studentAge<otherObj.studentAge) return -1;
		if(studentAge>otherObj.studentAge) return 1;
		return 0;
	}
	

}
