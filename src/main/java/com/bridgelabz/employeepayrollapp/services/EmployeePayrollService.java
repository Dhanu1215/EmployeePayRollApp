package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	/**
	 * Call method to get employee details
	 * @return : Employee details id, name and salary
	 */
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		List<EmployeePayrollData> empDataList = new ArrayList<>();
		empDataList.add(new EmployeePayrollData(1, new EmployeePayrollDTO("Dhanashree",33000)));
		return empDataList;
	}

	/**
	 * Call get method 
	 * @return : Employee details with id
	 */
	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1, new EmployeePayrollDTO("Dhanashree", 33000));
		return empData;
	}

	/**
	 * Call post method 
	 * @return : Employee details with id
	 */
	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1,empPayrollDTO);
		return empData;
	}

	/**
	 * Call update method 
	 * @return :  updated Employee details
	 */
	@Override
	public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1,empPayrollDTO);
		return empData;
	}

	/**
	 * Call delete method 
	 */
	@Override
	public void deleteEmployeePayrollData(int empId) {
		
	}

}
