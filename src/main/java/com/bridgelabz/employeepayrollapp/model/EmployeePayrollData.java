package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.List;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

@Data
public class EmployeePayrollData {

	private int employeeId;
	private String name;
	private String gender;
	private long salary;
	private LocalDate startdate;
	private String note;
	private String profilePic;
	private List<String>departments;
	
	
	public EmployeePayrollData() {}

	public EmployeePayrollData(int empId, EmployeePayrollDTO empPayRollDTO) {
		this.employeeId = empId;
		this.updateEmployeePayrollData(empPayRollDTO);
	}

	private void updateEmployeePayrollData(EmployeePayrollDTO empPayRollDTO) {
		this.name = empPayRollDTO.name;
		this.salary = empPayRollDTO.salary;
		this.gender = empPayRollDTO.gender;
		this.note = empPayRollDTO.note;
		this.startdate = empPayRollDTO.startdate;
		this.profilePic = empPayRollDTO.profilePic;
		this.departments = empPayRollDTO.departments;
		
	}
}
