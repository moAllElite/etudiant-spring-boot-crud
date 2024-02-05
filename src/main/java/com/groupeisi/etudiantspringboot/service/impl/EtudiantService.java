package com.groupeisi.etudiantspringboot.service.impl;

import com.groupeisi.etudiantspringboot.domain.Etudiant;
import com.groupeisi.etudiantspringboot.exceptions.EntityNotFoundException;
import com.groupeisi.etudiantspringboot.repository.EtudiantRepository;
import com.groupeisi.etudiantspringboot.service.dto.EtudiantDTO;
import com.groupeisi.etudiantspringboot.service.interfaces.IEtudiantService;
import com.groupeisi.etudiantspringboot.service.mapper.IEtudiantMapper;
import jakarta.persistence.EntityExistsException;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EtudiantService implements IEtudiantService {
    private final EtudiantRepository etudiantRepository;
    private final IEtudiantMapper etudiantMapper;



    @Override
    public Long save(EtudiantDTO etudiantDTO)  {
        if(etudiantRepository.findByEmail(etudiantDTO.getEmail()).isPresent()){
            throw new EntityExistsException("Etudiant  fourni existe déjà  l'email fourni "+etudiantDTO.getEmail());
        }
        return etudiantRepository.save(
                etudiantMapper.toEtudiantEntity(etudiantDTO)
        ).getId();


    }

    @Override
    public void delete(Long id) {
        if (etudiantRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException("Etudiant  fourni n'existe pas  l'ID fourni "+id);
        }
        etudiantRepository.deleteById(id);
    }

    @Override
    public Optional<EtudiantDTO> getById(Long id) {
        if(!etudiantRepository.existsById(id)){
            throw new EntityNotFoundException("Etudiant  fourni n'existe pas  l'ID fourni "+id);
        }

        return etudiantRepository.findById(id).map(etudiantMapper::toEtudiantDTO);
    }

    @Override
    public EtudiantDTO update(Long id, EtudiantDTO etudiantDTO) {

        if (etudiantRepository.findById(id).isPresent()) {
            Etudiant etudiant = etudiantRepository.save(etudiantMapper.toEtudiantEntity(etudiantDTO));
            return etudiantMapper.toEtudiantDTO(etudiant);
        }
        throw new EntityNotFoundException("Etudiant  fourni n'existe pas  l'ID fourni"+id);

    }


    @Override
    public Page<EtudiantDTO> paginatedStudents(int size, int page) {
      Pageable paging = PageRequest.of(page,size);
        return  etudiantRepository
                .findAll(paging)
                .map(etudiantMapper::toEtudiantDTO);
    }
}
