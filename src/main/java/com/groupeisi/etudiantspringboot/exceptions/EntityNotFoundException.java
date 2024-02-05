package com.groupeisi.etudiantspringboot.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter@Setter
public class EntityNotFoundException extends RuntimeException{
    private final String message;

}
