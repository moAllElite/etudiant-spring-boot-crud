package com.groupeisi.etudiantspringboot.service.mapper;

import com.groupeisi.etudiantspringboot.service.dto.EtudiantDTO;
import com.groupeisi.etudiantspringboot.domain.Etudiant;
import org.springframework.stereotype.Component;

@Component
public class EtudiantMapper implements IEtudiantMapper{






    public   Etudiant toEtudiantEntity (EtudiantDTO etudiantDTO){
        return new Etudiant(
                etudiantDTO.getId(),
                etudiantDTO.getNomComplet(),
                etudiantDTO.getEmail(),
                etudiantDTO.getTelephone(),
                etudiantDTO.getClasse(),
                etudiantDTO.getFiliere(),
                etudiantDTO.getDateNaissance()
        );
    }

    public  EtudiantDTO toEtudiantDTO (Etudiant etudiant){
        return  EtudiantDTO.builder()
                .id(etudiant.getId())
                .nomComplet(etudiant.getNomComplet())
                .email(etudiant.getEmail())
                .telephone(etudiant.getTelephone())
                .filiere(etudiant.getFiliere())
                .dateNaissance(etudiant.getDateNaissance())
                .classe(etudiant.getClasse())
                .build();
    }
}
