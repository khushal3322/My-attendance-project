package com.jforce.__my_attendance_project.service;

import java.util.List;

import com.jforce.__my_attendance_project.entity.Sheet;

public interface SheetService {

	
	public Sheet AddSheet(Sheet sheet);
	
	public List<Sheet> Allsheet();
	
	public Sheet findbyid(int id);
}
