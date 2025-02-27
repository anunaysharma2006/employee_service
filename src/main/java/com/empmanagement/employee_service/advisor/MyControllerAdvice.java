package com.empmanagement.employee_service.advisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
        return new ResponseEntity<String>("Required input fields are empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityObjectNotFoundException.class)
    public ResponseEntity<String> entityNotFound(EntityObjectNotFoundException entityObjectNotFoundException) {

        return new ResponseEntity<String>("The data for the respective object is not found in the database", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateDataException.class)
    public ResponseEntity<String> duplicateDataEntry(DuplicateDataException duplicateDataException) {

        return new ResponseEntity<String>("Duplicate data is entered ,Please review your entries", HttpStatus.BAD_REQUEST);
    }
}
