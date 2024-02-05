package com.groupeisi.etudiantspringboot.service.interfaces;

import com.groupeisi.etudiantspringboot.exceptions.HandleExcepetion;
import com.groupeisi.etudiantspringboot.service.dto.EtudiantDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IEtudiantService {
    Long save(EtudiantDTO etudiantDTO) throws HandleExcepetion;
    void delete(Long id);
    Optional<EtudiantDTO> getById(Long id);
    EtudiantDTO update(Long id,EtudiantDTO etudiantDTO);
    Page<EtudiantDTO> paginatedStudents(int size, int page);
}
