package br.edu.ifpr.foz.locacao_vhs.repositories;

<<<<<<< HEAD
import br.edu.ifpr.foz.locacao_vhs.TapeStatus;
import br.edu.ifpr.foz.locacao_vhs.models.*;

import java.util.List;

=======
import br.edu.ifpr.foz.locacao_vhs.models.*;

>>>>>>> 94be84c198fc5841158e3b6036a40f20ec424843
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VHSRepository extends JpaRepository<VHS, Long> {
<<<<<<< HEAD
    List<VHS> findByStatus(TapeStatus status);
    List<VHS> findByTitleContainingIgnoreCase(String title);
    List<VHS> findByCategoryId(Long categoryId);
=======
    
>>>>>>> 94be84c198fc5841158e3b6036a40f20ec424843
}
