package com.jforce.__my_attendance_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jforce.__my_attendance_project.entity.Sheet;

@Repository
public interface SheetRepository extends JpaRepository<Sheet, Integer>{

}
