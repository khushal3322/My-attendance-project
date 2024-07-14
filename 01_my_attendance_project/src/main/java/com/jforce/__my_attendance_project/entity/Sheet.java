package com.jforce.__my_attendance_project.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Sheet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate thats_Day;
	@DateTimeFormat(pattern = "hh:mm:ss")
	private LocalTime signin;
	@DateTimeFormat(pattern = "hh:mm:ss")
	@UpdateTimestamp
	private LocalTime signout;
	
	@ManyToOne
	private Student student;

	public Sheet() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalTime getSignin() {
		return signin;
	}

	public void setSignin(LocalTime signin) {
		this.signin = signin;
	}

	public LocalTime getSignout() {
		return signout;
	}

	public void setSignout(LocalTime signout) {
		this.signout = signout;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public LocalDate getThats_Day() {
		return thats_Day;
	}

	public void setThats_Day(LocalDate thats_Day) {
		this.thats_Day = thats_Day;
	}

	
	
	
	
	
}
