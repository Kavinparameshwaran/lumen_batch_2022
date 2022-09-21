package com.training.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HashSetExample {
	public static void main(String[] args) {
		Doctor kannan = new Doctor(101, "Kannan", "Gynocology", 9997766655L);
		Doctor karnan = new Doctor(102, "Karnan", "EW", 99977669999L);
		Doctor jin = new Doctor(103, "Chunhojin", "Surgery", 99663669999L);
		Doctor jinn = new Doctor(103, "Chunhojin", "Surgery", 99663669999L);
		Set<Doctor> docList=new HashSet<>();
		
		docList.add(kannan);
		docList.add(jinn);
		docList.add(jin);
		docList.add(karnan);
		
		System.out.println(docList.size());
		for (Doctor doctor : docList) {
			System.out.println(doctor);
		}
		
		Set<Doctor> docList1=new TreeSet<>();
		docList1.add(kannan);
		docList1.add(jinn);
		docList1.add(jin);
		docList1.add(karnan);
		
		System.out.println(docList1.size());
		for (Doctor doctor : docList1) {
			System.out.println(doctor);
		}
		
		
		
	}

}
