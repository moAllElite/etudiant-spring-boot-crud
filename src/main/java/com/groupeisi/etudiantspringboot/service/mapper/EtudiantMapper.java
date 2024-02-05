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
        return new EtudiantDTO(
                etudiant.getId(),
                etudiant.getNomComplet(),
                etudiant.getEmail(),
                etudiant.getTelephone(),
                etudiant.getClasse(),
                etudiant.getFiliere(),
                etudiant.getDateNaissance()
        );
    }
}
