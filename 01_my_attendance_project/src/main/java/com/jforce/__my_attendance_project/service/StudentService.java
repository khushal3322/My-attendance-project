package com.jforce.__my_attendance_project.service;

import java.util.List;

import com.jforce.__my_attendance_project.entity.Sheet;
import com.jforce.__my_attendance_project.entity.Student;

public interface StudentService {

	public Student RegisterStudent(Student student);
		
	
	public List<Student> allStudent();
	
	public int findStudent(int id);
		
	public List<Sheet> sheetlist(Student student);
		
	public Student findbyID(int id);
		
	public Student savestudentwithsheet(Student student,List<Sheet> sheet);


		
	
}
