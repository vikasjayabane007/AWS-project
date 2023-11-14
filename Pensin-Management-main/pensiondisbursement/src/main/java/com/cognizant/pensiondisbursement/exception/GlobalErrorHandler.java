package com.cognizant.pensiondisbursement.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.cognizant.pensiondisbursement.model.ResponseTypeDTO;



@RestControllerAdvice
public class GlobalErrorHandler {

	

	@ExceptionHandler(TokenInvalidException.class)
    public ResponseEntity<ResponseTypeDTO> customHandleNotExist(Exception ex, WebRequest request) {
        ResponseTypeDTO errorResponse = ResponseTypeDTO.builder().errMsg(ex.getMessage())
                .status(HttpStatus.FORBIDDEN.value())
                .timestamp(LocalDateTime.now())
                .errDetail(HttpStatus.FORBIDDEN).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }
}
