package com.bridgelabz.employeepayrollapp.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionalHandler {
	private static final String message = "Exception while processing REST Request ";
	
	/**
	 * Method to handle any Exception thrown
	 * @param exception :HttpMessageNotReadableException
	 * @return
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(
			HttpMessageNotReadableException exception) {
		log.error("Invalid date format",exception);
		ResponseDTO responseDTO = new ResponseDTO(message,"Should have date in the format dd MMM yyyy");
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	/**
	 * Method to handle any Exception thrown
	 * @param exception
	 * @return : ResponseEntity of Exception
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO(message, errMsg);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Method to handle when user Id not found
	 * @param exception
	 * @return : Response Entity of Exception
	 */
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handlerEmployeePayrollException(EmployeePayrollException exception) {
		ResponseDTO responseDTO = new ResponseDTO(message, exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}

}
