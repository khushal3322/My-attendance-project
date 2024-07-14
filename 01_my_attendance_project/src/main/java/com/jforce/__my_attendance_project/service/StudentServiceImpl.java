package com.jforce.__my_attendance_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jforce.__my_attendance_project.entity.Sheet;
import com.jforce.__my_attendance_project.entity.Student;
import com.jforce.__my_attendance_project.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student RegisterStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}
	
	
	
	public List<Student> allStudent() {
		
		return studentRepository.findAll();
	}



	@Override
	public int findStudent(int id) {
		// TODO Auto-generated method stub
		return id;
		
	}



	@Override
	public List<Sheet> sheetlist(Student student) {
		// TODO Auto-generated method stub
		List<Student> list = studentRepository.findAll();
		
		for (Student student2 : list) {
			if (student2.getId()==student.getId()) {
				return student2.getSheet();
			}
		}
		return null;
	}



	@Override
	public Student findbyID(int id) {
		// TODO Auto-generated method stub
		
		List<Student> allStudent = studentRepository.findAll();
		for (Student student : allStudent) {
			if (student.getId()==id) {
				return student;
			}
		}
		
		return null;
	}


	@Override
	public Student savestudentwithsheet(Student student, List<Sheet> sheet) {
		student.setSheet(sheet);
		Sheetserviceimpl sheetserviceimpl = new Sheetserviceimpl();
		for (Sheet sheet2 : sheet) {
			
			sheet2.setStudent(student);
			sheetserviceimpl.AddSheet(sheet2);
		}
		
		
		return studentRepository.save(student);
		// TODO Auto-generated method stub
		
	}

	


	

}
