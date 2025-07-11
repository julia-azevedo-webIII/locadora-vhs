package br.edu.ifpr.foz.locacao_vhs.repositories;

import br.edu.ifpr.foz.locacao_vhs.models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VHSRepository extends JpaRepository<VHS, Long> {
    
}
