package br.edu.ifpr.foz.locacao_vhs.repositories;

import br.edu.ifpr.foz.locacao_vhs.TapeStatus;
import br.edu.ifpr.foz.locacao_vhs.models.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VHSRepository extends JpaRepository<VHS, Long> {
    List<VHS> findByStatus(TapeStatus status);
    List<VHS> findByTitleContainingIgnoreCase(String title);
    List<VHS> findByCategoryId(Long categoryId);
}
