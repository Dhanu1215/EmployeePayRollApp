package com.bridgelabz.employeepayrollapp.dto;

/**
 * EmployeePayrollDTO : Details of emloyees
 * @author praja
 *
 */
public class EmployeePayrollDTO {
	
	public long id;
	public String name;
	public long salary;
	
	public EmployeePayrollDTO(long id, String name, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
