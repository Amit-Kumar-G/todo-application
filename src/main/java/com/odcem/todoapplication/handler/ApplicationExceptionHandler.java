package com.odcem.todoapplication.handler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.odcem.todoapplication.exception.TaskValidationException;
import com.odcem.todoapplication.exception.UserValidationException;
import com.odcem.todoapplication.json.ErrorDetial;
import com.odcem.todoapplication.service.TaskServiceImpl;
import com.odcem.todoapplication.service.UserServiceImpl;
import com.odcem.todoapplication.utility.Utils;

@ControllerAdvice(basePackages = {"com.odcem.todoapplication.controller"})
public class ApplicationExceptionHandler {
	
	private Logger strategyLogger;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = TaskValidationException.class)
	public ErrorDetial taskDtoValidationException(TaskValidationException e) {
		
		strategyLogger = LogManager.getLogger(TaskServiceImpl.class);
		strategyLogger.fatal("The task could not be understood, bad format.");
		strategyLogger.fatal(Utils.getStackTraceInStringFmt(e));
		return new ErrorDetial("TA_100-01", e.getMessage());
	}
	
	@ExceptionHandler(value = UserValidationException.class)
	public ResponseEntity<ErrorDetial> handleUserValidationException(UserValidationException e) {
		
		strategyLogger = LogManager.getLogger(UserServiceImpl.class);
		strategyLogger.fatal("Bad user request format.");
		strategyLogger.fatal(Utils.getStackTraceInStringFmt(e));
		//return new ErrorDetial("US_100-01", e.getMessage());
		return new ResponseEntity<ErrorDetial>( new ErrorDetial("US_100-01", e.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
}
