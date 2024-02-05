package com.groupeisi.etudiantspringboot.service.mapper;

import com.groupeisi.etudiantspringboot.domain.Etudiant;
import com.groupeisi.etudiantspringboot.service.dto.EtudiantDTO;
import org.springframework.stereotype.Component;

@Component
public interface IEtudiantMapper {
    EtudiantDTO toEtudiantDTO(Etudiant etudiant);
    Etudiant toEtudiantEntity(EtudiantDTO  etudiantDTO);
}
