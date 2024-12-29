package com.weddingring.exception;

import com.weddingring.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GeneralException.class)
    ResponseEntity<ErrorResponse> handleIllegalStateException(GeneralException ex){
        ErrorResponse resourceNotFound=ErrorResponse.builder()
                .errorMessage(ex.getMessage()).status("404").build();

        return ResponseEntity.status(200).body(resourceNotFound);
    }
}
