package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

/**
 * EmployeePayrollDTO : Details of employees
 * @author praja
 *
 */
public @ToString class EmployeePayrollDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "Employee name Invalid")
	public String name;
	
	@Min (value = 500, message = "Min salary should be more than 500")
	public long salary;
	
	@Pattern(regexp = "male|female",message = "Gender should be male or female")
	public String gender;
	
	@JsonFormat(pattern="dd MMM yyyy")
	@NotNull(message = "startdate should Not be empty")
	@PastOrPresent(message = "start date should be past or todays date")
	public LocalDate startdate;
	
	@javax.validation.constraints.NotBlank(message = "Note can not be Empty")
	public String note;
	
	@javax.validation.constraints.NotBlank(message = "profilePic can not be Empty")
	public String profilePic;
	
	@NotEmpty(message = "Department should not be Empty")
	public List<String>departments;
	
}
