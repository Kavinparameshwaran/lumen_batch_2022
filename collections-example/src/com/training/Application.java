package com.training;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.training.daos.StudentRepositoryImpl;
import com.training.exceptions.ElementNotFoundException;
import com.training.ifaces.CrudRepository;
import com.training.model.Student;
import com.training.utils.FirstNameComparator;

public class Application {

//	public static void main(String[] args) {
//		int key=1;
//		CrudRepository<Student> repo=new StudentRepositoryImpl();
//		Student obj=new Student("Ram", "18bcs444", 22, 7776655544L, "Chennai");
//		Student obj1=new Student("Charan","18bcs224", 24, 7774455544L, "Mumbai");
//		Student obj2=new Student("NTR","18bit224", 25, 7774455544L, "Mumbai");
//		do {
//			switch (key) {
//			case 1: 
//				System.out.println("is Element Addes:="+repo.save(obj));
//				System.out.println("is Element Addes:="+repo.save(obj1));
//				System.out.println("is Element Addes:="+repo.save(obj2));
//				break;
//			case 2:
//				Collection<Student> list=repo.findAll();
//				for(Student eachStudent:list) {
//					System.out.println(eachStudent);
//				}
//				break;
//			case 3:
//				boolean result;
//				try {
//					result=repo.delete(obj1);
//					System.out.println("Is Deleted:="+result);
//				} catch (ElementNotFoundException e) {
//					e.printStackTrace();
//				}
//				break;
//			default:
//				break;
//				}
//			key++;
//		}while(key<4);
//
//		}

	public static void main(String[] args) {

		CrudRepository<Student> repo = new StudentRepositoryImpl();

		Student ramesh = new Student("Ram", "18bcs444", 22, 7776655544L, "Chennai");
		Student rajesh = new Student("Charan", "18bcs224", 24, 7774455544L, "Mumbai");
		Student vishal = new Student("NTR", "18bit224", 25, 7774455544L, "Mumbai");
		Student aman = new Student("RaviTej", "18bit324", 26, 7774458884L, "Goa");

		repo.save(vishal);
		repo.save(ramesh);
		repo.save(rajesh);
		repo.save(aman);

		List<Student> list = (List<Student>) repo.findAll();
		Collections.sort(list);

		for (Student eachStudent : repo.findAll()) {
			System.out.println(eachStudent);
		}

		Collections.sort(list, new FirstNameComparator());

		System.out.println("Order by name");

		for (Student eachStudent : repo.findAll()) {
			System.out.println(eachStudent);
		}
		
		try {
			repo.delete(aman);
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("After Deleting");

		for (Student eachStudent : repo.findAll()) {
			System.out.println(eachStudent);
		}

		
		System.out.println("Swagat");
	}

}
