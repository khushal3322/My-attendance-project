package com.jforce.__my_attendance_project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jforce.__my_attendance_project.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	
		
	
}
