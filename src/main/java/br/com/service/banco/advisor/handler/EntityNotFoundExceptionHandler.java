package br.com.service.banco.advisor.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.service.banco.advisor.EntityNotFoundException;

@ControllerAdvice
public class EntityNotFoundExceptionHandler {

	    @ExceptionHandler(EntityNotFoundException.class)
	    public ResponseEntity<Map<String, String>> handlerException(EntityNotFoundException ex) {
	        Map<String, String> response = new HashMap<>();
	        response.put("error", ex.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	    }
}
