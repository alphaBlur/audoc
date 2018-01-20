package com.junit.assignment;

import com.junit.assignment.Student;
import com.junit.assignment.StudentDao;

public class App {
	
	private static StudentDao d;  
	public App() {
		// TODO Auto-generated constructor stub
		d=new StudentDao();
	}

	public Student addStudent(Student student) {
		Student addedStudent=null;
		boolean status=verify(student);
		if(status==true)
		addedStudent=d.addStudent(student);
		return addedStudent;
	}
		
	private boolean verify(Student student) {
		if(student.getRegNo()<=0 || student.getName()==null || student.getDob()==null)
		return false;
		return true;
	}

	public Student getStudent(int rollNo)
	{
		if(rollNo<1)
			return null;
		Student student=d.getStudent(rollNo);
		
		return student;
	}
	
	public Student deleteStudent(int rollNo)
	{	if(rollNo<=0)
		return null;
		return d.deleteStudent(rollNo);
		
	}
	
}
