package com.groupeisi.etudiantspringboot.controllers;
import com.groupeisi.etudiantspringboot.exceptions.HandleExcepetion;
import com.groupeisi.etudiantspringboot.service.dto.EtudiantDTO;
import com.groupeisi.etudiantspringboot.service.interfaces.IEtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/etudiants")
@RestController
@Tag(name = "Etudiant", description = "Etudiant API")
public class EtudiantController {
    private final IEtudiantService etudiantService;
    @Operation(
            description = "Pagination de la liste des etudiants",
            summary = "retourne une liste paginée  des etudiants suivant une pageSize qui est par défaut à 5",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request"
                    )
            }
    )
    @GetMapping("")
    public ResponseEntity<Page<EtudiantDTO>> list(
            @RequestParam(value = "size",defaultValue = "5") int size,
            @RequestParam(value = "page", defaultValue = "0") int page
    ) {
        return ResponseEntity.ok(
                etudiantService.paginatedStudents(size, page)
        );
    }
    @Operation(
            description = "Récupérer un etudiant par son id",
            summary = "retourne un etudiant",
        responses = {
                    @ApiResponse(
                        responseCode = "200",
                            description = "Success"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found"
                    )
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EtudiantDTO>> getById(@PathVariable Long id){
        return ResponseEntity.ok(etudiantService.getById(id));
    }
    @Operation(
            summary = "Nouveau  etudiant",
            description = "Créer un etudiant",
            responses= {@ApiResponse(
                    responseCode = "201",
                    description = "Success"
            ), @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request"
                    )}
    )
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional()
    @PostMapping("")
    public ResponseEntity<Long> create(@Valid   @RequestBody EtudiantDTO etudiantDTO) {
        try {
            return ResponseEntity.ok(etudiantService.save(etudiantDTO));
        } catch (HandleExcepetion e) {
            throw new EntityExistsException(e.getMessage());
        }
    }
    @Operation(
            summary = "Suppression etudiant",
            description = "Supprimer un etudiant",
            responses= {@ApiResponse(
            responseCode = "204",
                    description = "Success"
                    )}
    )
    @Transactional()
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        etudiantService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @Operation(
            summary = "Modifier un etudiant",
            description = "Modifier un etudiant",
           responses= {@ApiResponse(
               responseCode = "204",
             description = "Success"
                ),@ApiResponse(
                          responseCode = "400",
          description = "Bad request"
           )}
    )
  @Transactional()
    @PutMapping("/{id}")
   public ResponseEntity<EtudiantDTO> update(@PathVariable("id") Long id, @Valid @RequestBody EtudiantDTO etudiantDTO) {
        return ResponseEntity.ok(etudiantService.update(id, etudiantDTO));
    }
}
