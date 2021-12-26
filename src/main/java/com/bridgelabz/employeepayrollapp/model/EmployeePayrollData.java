package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;
@Data
public class EmployeePayrollData {

	private int employeeId;
	private String name;
	private long salary;
	
	public EmployeePayrollData() {}

	public EmployeePayrollData(int empId, EmployeePayrollDTO empPayRollDTO) {
		super();
		this.employeeId = empId;
		this.name = empPayRollDTO.name;
		this.salary = empPayRollDTO.salary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollData [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
