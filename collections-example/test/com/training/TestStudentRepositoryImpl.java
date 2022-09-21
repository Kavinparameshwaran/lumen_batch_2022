package com.training;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.training.daos.StudentRepositoryImpl;
import com.training.model.Student;

class TestStudentRepositoryImpl {

	@Test
	void testAllMethods() {
		StudentRepositoryImpl repo = new StudentRepositoryImpl();
		Student ramesh = new Student("Ram", "18bcs444", 22, 7776655544L, "Chennai");
		Student rajesh = new Student("Charan", "18bcs224", 24, 7774455544L, "Mumbai");
		Student vishal = new Student("NTR", "18bit224", 25, 7774455544L, "Mumbai");
		Student aman = new Student("RaviTej", "18bit324", 26, 7774458884L, "Goa");
		Student Kaushik = new Student("Kaushik", "18bit334", 27, 7774666884L, "Pune");

		assertAll("Test all student repository methods", 
				() -> {
					  repo.save(ramesh); 
					  repo.save(rajesh);
					  repo.save(vishal);
					  repo.save(aman);
					  assertTrue(repo.findAll().size() >= 3);
				}, 
				() -> { 
					assertThrows(RuntimeException.class, () -> repo.save(aman));
					},
				() -> assertEquals(true,repo.save(Kaushik)), 
				() -> assertNotNull(repo.findAll()));

	}

}
