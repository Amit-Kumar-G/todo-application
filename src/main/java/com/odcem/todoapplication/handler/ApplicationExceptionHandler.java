package com.odcem.todoapplication.handler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.odcem.todoapplication.entity.TaskCategory;
import com.odcem.todoapplication.exception.TaskCategoryValidationException;
import com.odcem.todoapplication.exception.TaskValidationException;
import com.odcem.todoapplication.exception.UserValidationException;
import com.odcem.todoapplication.json.ErrorDetialJson;
import com.odcem.todoapplication.service.TaskCategoryServiceImpl;
import com.odcem.todoapplication.service.TaskServiceImpl;
import com.odcem.todoapplication.service.UserServiceImpl;
import com.odcem.todoapplication.utility.Utils;

@ControllerAdvice(basePackages = {"com.odcem.todoapplication.controller"})
public class ApplicationExceptionHandler {
	
	private Logger strategyLogger;

	@ExceptionHandler(value = TaskValidationException.class)
	public ResponseEntity<ErrorDetialJson> taskDtoValidationException(TaskValidationException e) {
		
		strategyLogger = LogManager.getLogger(TaskServiceImpl.class);
		strategyLogger.fatal("The task could not be understood, bad format.");
		strategyLogger.fatal(Utils.getStackTraceInStringFmt(e));
		return new ResponseEntity<ErrorDetialJson>( new ErrorDetialJson("TA_100-01", e.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = UserValidationException.class)
	public ResponseEntity<ErrorDetialJson> handleUserValidationException(UserValidationException e) {
		
		strategyLogger = LogManager.getLogger(UserServiceImpl.class);
		strategyLogger.fatal("Bad user request format.");
		strategyLogger.fatal(Utils.getStackTraceInStringFmt(e));
		return new ResponseEntity<ErrorDetialJson>( new ErrorDetialJson("US_100-01", e.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = TaskCategoryValidationException.class)
	public ResponseEntity<ErrorDetialJson> handleTaskCategoryValidationException(TaskCategoryValidationException e) {
		
		strategyLogger = LogManager.getLogger(TaskCategoryServiceImpl.class);
		strategyLogger.fatal("Bad task category request format.");
		strategyLogger.fatal(Utils.getStackTraceInStringFmt(e));
		return new ResponseEntity<ErrorDetialJson>( new ErrorDetialJson("TC_100-01", e.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
}
