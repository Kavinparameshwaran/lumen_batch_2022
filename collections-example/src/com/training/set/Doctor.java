package com.training.set;

import java.util.Objects;

public class Doctor implements Comparable<Doctor> {
	private int doctorId;
	private String doctorName;
	private String department;
	private long mobileNumber;

	public Doctor(int doctorId, String doctorName, String department, long mobileNumber) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.department = department;
		this.mobileNumber = mobileNumber;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", department=" + department
				+ ", mobileNumber=" + mobileNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, doctorId, doctorName, mobileNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Doctor)) {
			return false;
		}
		Doctor other = (Doctor) obj;
		return Objects.equals(department, other.department) && doctorId == other.doctorId
				&& Objects.equals(doctorName, other.doctorName) && mobileNumber == other.mobileNumber;
	}

	@Override
	public int compareTo(Doctor otherObject) {
		return this.doctorName.compareTo(otherObject.doctorName);
	}



}
