package com.alertSystem.exception;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


	@ControllerAdvice
	public class RestExceptionHandler extends ResponseEntityExceptionHandler {

		@ExceptionHandler(value = { NullPointerException.class,Exception.class})
		protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
			JSONObject obj = new JSONObject();
			obj.put("status", "FAILED");
			if(ex instanceof NullPointerException)
			{
			obj.put("error message", "exception occured during operation please check if the inputs are valid");
			}
			else
			{
				obj.put("error message", "exception occured during the process.");
			}
			
			return handleExceptionInternal(ex, obj.toString(), new HttpHeaders(), HttpStatus.ACCEPTED, request);
		}
}
