package com.weddingring.exception;

import com.weddingring.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProfileNotFoundException.class)
    ResponseEntity<ErrorResponse> handleIllegalStateException(ProfileNotFoundException ex){
        ErrorResponse resourceNotFound=ErrorResponse.builder()
                .errorMessage(ex.getMessage()).status("404").build();

        return ResponseEntity.status(200).body(resourceNotFound);
    }
}
