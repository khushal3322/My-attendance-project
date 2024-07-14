package com.jforce.__my_attendance_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jforce.__my_attendance_project.entity.Sheet;
import com.jforce.__my_attendance_project.repository.SheetRepository;

@Service
public class Sheetserviceimpl implements SheetService{

	@Autowired
	private SheetRepository sheetRepository;
	
	@Override
	public Sheet AddSheet(Sheet sheet) {
		// TODO Auto-generated method stub
		
		return sheetRepository.save(sheet);
	}

	@Override
	public List<Sheet> Allsheet() {
		// TODO Auto-generated method stub
//		sheetRepository.getById(null)
		return sheetRepository.findAll();
	}

	@Override
	public Sheet findbyid(int id) {
		// TODO Auto-generated method stub
		List<Sheet> allsheet = Allsheet();
		
		return null;
	}
	
	

}
