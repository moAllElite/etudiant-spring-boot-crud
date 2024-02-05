package com.groupeisi.etudiantspringboot.exceptions;


import jakarta.persistence.EntityExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class HandleExcepetion  extends  Exception{
    @ExceptionHandler(value = {EntityExistsException.class,})
    public ResponseEntity<ApiException> handlerEntityExistsException(EntityExistsException e) {
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.CONFLICT,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value = {RequestException.class,})
    public ResponseEntity<ApiException> handlerRequestException(RequestException  e) {
        ApiException apiException = new ApiException(
               e.getMessage(),
                e.status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException  ,  e.status);
    }
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> etudiantNotFoundException(EntityNotFoundException e){
        ApiException apiException = new ApiException(
                    e.getMessage(),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException  ,  HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiException> handleMethodArgumentNotValideException(MethodArgumentNotValidException e){
        ApiException apiException=new ApiException("La valeur saisie est incorrecte ",HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return  new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);
    }
}
