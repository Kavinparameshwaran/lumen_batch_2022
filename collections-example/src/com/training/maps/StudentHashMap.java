package com.training.maps;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.training.model.Student;

public class StudentHashMap {
	public static void usingHashMap() {
		HashMap<Integer, Student> map = new HashMap<>();
		Student ram = new Student("Ram", "17bit443", 33, 7778899988L, "Pune");
		System.out.println(map.put(Integer.parseInt(ram.getStudentRollNumber().substring(5)), ram));
		Student ramdu = new Student("Ramdu", "18bcs403", 34, 9998877766L, "Mumbai");
		System.out.println(map.put(443, ramdu));
		System.out.println(map.get(443));
	}

	public static void usingHashTable() {
		Hashtable<Integer, Student> map = new Hashtable<>();
		Student ram = new Student("Ram", "17bit443", 33, 7778899988L, "Pune");
		Student ramdu = new Student("Ramdu", "18bcs403", 34, 9998877766L, "Mumbai");
		System.out.println(map.put(Integer.parseInt(ram.getStudentRollNumber().substring(5)), ram));
		System.out.println(map.put(Integer.parseInt(ramdu.getStudentRollNumber().substring(5)), ramdu));
		for (Map.Entry<Integer, Student> eachElement : map.entrySet()) {
			System.out.println(eachElement.getKey() + ":=" + eachElement.getValue());
		}
	}
	public static void usingHashMapWithKeys() {
		HashMap<Integer, Student> map = new HashMap<>();
		Student ram = new Student("Ram", "17bit443", 33, 7778899988L, "Pune");
		System.out.println(map.put(Integer.parseInt(ram.getStudentRollNumber().substring(5)), ram));
		Student ramdu = new Student("Ramdu", "18bcs403", 34, 9998877766L, "Mumbai");
//		System.out.println(map.put(443, ramdu));
//		System.out.println(map.get(443));
		System.out.println(map.put(Integer.parseInt(ramdu.getStudentRollNumber().substring(5)), ramdu));
		Set<Integer> setMap=map.keySet();
		for(Integer EachInt:setMap) {
			System.out.println(EachInt);
			System.out.println(map.get(EachInt));
		}
	}
	
	

	public static void usingTreeMap() {
		TreeMap<Integer, Student> map = new TreeMap<>();
		Student ramdu = new Student("Ramdu", "18bcs421", 34, 9998877766L, "Mumbai");
		Student ram = new Student("Ram", "17bit413", 33, 7778899988L, "Pune");
		System.out.println(map.put(Integer.parseInt(ramdu.getStudentRollNumber().substring(5)), ramdu));
		System.out.println(map.put(Integer.parseInt(ram.getStudentRollNumber().substring(5)), ram));
		for (Map.Entry<Integer, Student> eachElement : map.entrySet()) {
			System.out.println(eachElement.getKey() + ":=" + eachElement.getValue());
		}
	}

	public static void main(String[] args) {
//		usingHashMap();
//		usingHashTable();
//		usingTreeMap();
		usingHashMapWithKeys();
	}

}
