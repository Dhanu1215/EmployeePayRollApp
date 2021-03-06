package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;
@Entity
@Table(name="employee_payroll")
public @Data class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name= "name")
	private String name;
	private String gender;
	private long salary;
	private LocalDate startdate;
	private String note;
	private String profilePic;
	
	@ElementCollection
	@CollectionTable(name ="employee_department", joinColumns =  @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String>departments;
	
	
	public EmployeePayrollData() {}

	public EmployeePayrollData(EmployeePayrollDTO empPayRollDTO) {
		this.updateEmployeePayrollData(empPayRollDTO);
	}

	public void updateEmployeePayrollData(EmployeePayrollDTO empPayRollDTO) {
		this.name = empPayRollDTO.name;
		this.salary = empPayRollDTO.salary;
		this.gender = empPayRollDTO.gender;
		this.note = empPayRollDTO.note;
		this.startdate = empPayRollDTO.startdate;
		this.profilePic = empPayRollDTO.profilePic;
		this.departments = empPayRollDTO.departments;
		
	}
}
