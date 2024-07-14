package com.jforce.__my_attendance_project.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jforce.__my_attendance_project.entity.Sheet;
import com.jforce.__my_attendance_project.entity.Student;
import com.jforce.__my_attendance_project.service.SheetService;
import com.jforce.__my_attendance_project.service.StudentService;

@Controller
public class Studentcontroller {

	@Autowired
	private StudentService studentService;
	@Autowired
	private SheetService sheetService;
	
	@GetMapping("/login")
	public String login_page(Model model) {
		
		return "login";
	}
	
	int studentobject;
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String useranme,@RequestParam("password") String password, Model model) {
		List<Student> allStudent = studentService.allStudent();
		
		for (Student student : allStudent) {
		
		if (student.getUsername().equals(useranme)&&student.getPassword().equals(password)) {
			model.addAttribute("id", student.getId());
		studentobject=studentService.findStudent(student.getId());
//			System.out.println();
			return "redirect:/signin";
			}
		}
		model.addAttribute("error", "Login fail");
		return "login";
	} 
	
	
	
	@GetMapping("/in")
	public String Sign(Model model) {
		System.out.println(studentobject);
		Sheet sheet = new Sheet();
		Student student = studentService.findbyID(studentobject);
		
		LocalTime localTime = LocalTime.now();
		LocalDate localDate = LocalDate.now();
		
		
//		model.addAttribute("id", sheet.getId());
		sheet.setSignin(localTime);
		sheet.setThats_Day(localDate);
		sheet.setStudent(student);
		
		System.out.println(student.getEmail());
													//		List<Sheet> sheetlist = studentService.sheetlist(student);
													//		List<Sheet> list = student.getSheet();
													//		list.add(sheet);
													//		for (Sheet sheet2 : list) {
													//			System.out.println(sheet2.getSignin());
													//		}
													//		for (Sheet sheet2 : list) {
		sheetService.AddSheet(sheet);
													//		}
		System.out.println(sheet.getId());
		
													//		student.setSheet(list);
													//		studentService.savestudentwithsheet(student, list); 
													//////		System.out.println(sheetlist);
															
													//		student.setSheet(list);  
													//		studentService.RegisterStudent(student);
		model.addAttribute("id", sheet.getId());
		
		return "redirect:/signout";
	}
	
	@GetMapping("/Signout")
	public String Signout(@ModelAttribute("id") int id) {
//		System.out.println(studentobject);
		Student student = studentService.findbyID(studentobject);
	
															//		List<Sheet> list = sheetService.Allsheet();
															//		Sheet getsheet=null;
															//		for (Sheet sheet : list) {
															//			 getsheet = sheet;
															//		}
															//		LocalTime localTime = LocalTime.now();
															//		Sheet sheet = new Sheet();
																	
															//		getsheet.setSignout(localTime);
															//		System.out.println(student.getEmail());
															//		sheetService.AddSheet(getsheet);
																	
															//		List<Sheet> sheetlist = studentService.sheetlist(student);
															//		List<Sheet> list = student.getSheet();
																	
															//		list.add(sheet);
															////		for (Sheet sheet2 : list) {
															////			System.out.println(sheet2.getSignin());
															////		}
															//		for (Sheet sheet2 : list) {
															//			sheetService.AddSheet(sheet);
															//		}
															//		student.setSheet(list);
															//		studentService.savestudentwithsheet(student, list); 
															//////		System.out.println(sheetlist);
//		System.out.println(id);															
															//		student.setSheet(list);  
															//		studentService.RegisterStudent(student);
		return "redirect:/login";
	}
	
	
	
	
	@GetMapping("/register")
	public String register_page(Model model) {
		model.addAttribute("Student", new Student());
																//		Student name = new Student();
																//		name.setUsername("khushal");
																//		name.setPassword("123");
																//		name.setEmail("k@3");
																//		name.setPhone(98765432);
																//		
																//		studentService.RegisterStudent(name);
																//		system.out.println(name);
		return "register";
	}
	
	@PostMapping("/register")
	public String registerstudent(@ModelAttribute Student studentdetail) {
		
		studentService.RegisterStudent(studentdetail);
//		studentService.RegisterStudent(studentdetail);
		
		return "redirect:/login";
	}
	
	@GetMapping("/signin")
	public String SignIn() {
		
		return "signin";
	}
	
	@GetMapping("/signout")
	public String Sign_out() {
		
		return "signout";
	}
}
