package br.edu.ifpr.foz.locacao_vhs.repositories;

import br.edu.ifpr.foz.locacao_vhs.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
