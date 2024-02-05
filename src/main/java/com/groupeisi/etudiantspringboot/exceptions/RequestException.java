package com.groupeisi.etudiantspringboot.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
public class RequestException  extends  RuntimeException{

    final String message;
    final HttpStatus status;
}
