package com.junit.assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;

import com.junit.assignment.App;
import com.junit.assignment.Student;


public class StudentTest {
	@Mock
	StudentDAO mockedStudentDAO;
	@BeforeEach
	void setup()
	{
		MockitoAnnotations.initMocks(this);

	}
	
	@Test
	public void isAddStudentWorking() {
	
	Student student= new Student(1, "Nishant Kaushik", parseDate("2000-01-02"), "CS","9931829338");
	Student student1=new Student(2, "Nishant Kaushik", parseDate("2000-01-02"), "CS","9931829338");
	Student student2=new Student(3, "Nishant Kaushik", parseDate("2000-01-02"), "CS","9931829338");
	
	Mockito.when(mockedStudentDAO.addStudent(student)).thenReturn(null);
	Mockito.when(mockedStudentDAO.addStudent(student1)).thenReturn(null);

	App studentApp =new App();
	
	Student stud=studentApp.addStudent(student);
	Student stud1=studentApp.addStudent(student1);
	Student stud2=studentApp.addStudent(student2);
	assertNull(stud);
	assertNull(stud1);
	assertNotNull(stud2);
	assertEquals(student2, stud2);
}
	
	@Test
	public void isDeleteWorking()
	{
		Student student= new Student(1, "Nishant Kaushik", parseDate("2000-01-02"), "CS","9931829338");
		
		Mockito.when(mockedStudentDAO.deleteStudent(1)).thenReturn(student);
		
		App studentService=new App();
		
		Student stud=studentService.deleteStudent(1);
		assertNotNull(stud);
	}
	
	@Test
	public void isGetStudentWorking()
	{
		Student student= new Student(1, "Nishant Kaushik", parseDate("2000-01-02"), "CS","9931829338");
		
		Mockito.when(mockedStudentDAO.getStudent(Matchers.anyInt())).thenReturn(student);
		
		App studentService=new App();
		
		Student stud=studentService.deleteStudent(1);
		assertNotNull(stud);
	}
	
	public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	
}