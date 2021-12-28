package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {
	

	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;
	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	/**
	 * Call method to get employee details
	 * @return : Employee details id, name and salary
	 */
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollRepository.findAll();
	}

	/**
	 * Call get method 
	 * @return : Employee details with id
	 */
	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		 return employeePayrollRepository.findById(empId).orElseThrow(()-> 
		 		new EmployeePayrollException("Employee with employeeId "+empId+ "dose not exists..!!"));
    }

	/**
	 * Call post method to add data in database
	 * @return : Employee details with id
	 */
	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(empPayrollDTO);
		log.debug("Emp data: "+empData.toString());
		return employeePayrollRepository.save(empData);
	}

	/**
	 * Call update method 
	 * @return : updated Employee details from database
	 */
	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		empData.updateEmployeePayrollData(empPayrollDTO);
		return employeePayrollRepository.save(empData);
	}

	/**
	 * Call delete method 
	 * to delete data from database
	 */
	@Override
	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		employeePayrollRepository.delete(empData);
	}

}
