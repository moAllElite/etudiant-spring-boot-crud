package com.groupeisi.etudiantspringboot.repository;

import com.groupeisi.etudiantspringboot.domain.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

    Optional<Etudiant> findByEmail(String email);
}
