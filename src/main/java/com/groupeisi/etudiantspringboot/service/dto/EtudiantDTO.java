package com.groupeisi.etudiantspringboot.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDTO {
    private Long id;
    @NotEmpty(message = "Le nom complet est obligatoire")
    @Size(min = 3, max = 50, message = "Le nom complet doit comporter entre 3 et 50 caractères")
    @NotEmpty(message = "L'email est obligatoire")
    private String nomComplet;
    @Email(message = "L'adresse email est invalide",flags = Pattern.Flag.COMMENTS)
    private String email;
    @Pattern(regexp = "^(1[ \\-+]{0,3}|\\+1[ -+]{0,3}|\\+1|\\+)?((\\(\\+?1-[2-9][0-9]{1,2}\\))|(\\(\\+?[2-8][0-9][0-9]\\))|(\\(\\+?[1-9][0-9]\\))|(\\(\\+?[17]\\))|(\\([2-9][2-9]\\))|([ \\-.]{0,3}[0-9]{2,4}))?([ \\-.][0-9])?([ \\-.]{0,3}[0-9]{2,4}){2,3}$")
    private String telephone;
    private String classe;
    @NotEmpty(message = "La filière est obligatoire")
    private String filiere;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YYYY")
    @NotNull(message = "La date de naissance est obligatoire")
    private Date dateNaissance;
}
