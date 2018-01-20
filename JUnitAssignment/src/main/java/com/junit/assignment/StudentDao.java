package com.junit.assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.junit.assignment.Student;

public class StudentDao {
	private  Map<Integer,Student> allStudents;
	public StudentDao() {
		allStudents=new HashMap<Integer,Student>();
		allStudents.put(1,new Student(1, "Nishant Kaushik", parseDate("2000-01-02"), "CS","9931829338"));
		allStudents.put(2,new Student(2, "Nishant Kaushik", parseDate("2000-01-02"), "CS","9931829338"));
		allStudents.put(3,new Student(3, "Nishant Kaushik", parseDate("2000-01-02"), "CS","9931829338"));
	}
	
	public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	
	public Student addStudent(Student student) {
		if(allStudents.get(student.getRegNo())!=null)
		return null;
		allStudents.put(student.getRegNo(), student);
		return allStudents.get(student.getRegNo());
	}

	public Student updateStudent(Student student) {
		if(allStudents.get(student.getRegNo())==null)
			return null;
		allStudents.put(student.getRegNo(), student);	
		return allStudents.get(student.getRegNo());
	}

	public Student getStudent(int rollNo) {
		if(allStudents.get(rollNo)==null)
			return null;
		return allStudents.get(rollNo);
	}

	public Student deleteStudent(int rollNo) {
		if(allStudents.get(rollNo)==null)
			return null;
		Student stud=allStudents.remove(rollNo);
		return stud;
	}

}