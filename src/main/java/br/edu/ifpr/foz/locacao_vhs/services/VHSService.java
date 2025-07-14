package br.edu.ifpr.foz.locacao_vhs.services;

<<<<<<< HEAD
import br.edu.ifpr.foz.locacao_vhs.TapeStatus;
=======
>>>>>>> 94be84c198fc5841158e3b6036a40f20ec424843
import br.edu.ifpr.foz.locacao_vhs.models.*;
import br.edu.ifpr.foz.locacao_vhs.repositories.*;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 94be84c198fc5841158e3b6036a40f20ec424843

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VHSService {
    @Autowired
    VHSRepository vhsRepository;

    public List<VHS> findAll() {
        return vhsRepository.findAll();
    }
<<<<<<< HEAD
    public Optional<VHS> findById(Long id) {
        return vhsRepository.findById(id);
    }
    
    public VHS save(VHS vhs) {
        return vhsRepository.save(vhs);
    }
    
    public void deleteById(Long id) {
        vhsRepository.deleteById(id);
    }
    
    public List<VHS> findByStatus(TapeStatus status) {
        return vhsRepository.findByStatus(status);
    }
    
    public List<VHS> findByTitle(String title) {
        return vhsRepository.findByTitleContainingIgnoreCase(title);
    }
    
    public List<VHS> findByCategory(Long categoryId) {
        return vhsRepository.findByCategoryId(categoryId);
    }
    
    public List<VHS> findAvailable() {
        return vhsRepository.findByStatus(TapeStatus.DISPONIVEL);
    }
    
    public VHS rent(Long id) {
        Optional<VHS> vhsOpt = vhsRepository.findById(id);
        if (vhsOpt.isPresent()) {
            VHS vhs = vhsOpt.get();
            if (vhs.getStatus() == TapeStatus.DISPONIVEL) {
                vhs.setStatus(TapeStatus.ALUGADO);
                return vhsRepository.save(vhs);
            }
        }
        return null;
    }
    
    public VHS returnVHS(Long id) {
        Optional<VHS> vhsOpt = vhsRepository.findById(id);
        if (vhsOpt.isPresent()) {
            VHS vhs = vhsOpt.get();
            if (vhs.getStatus() == TapeStatus.ALUGADO) {
                vhs.setStatus(TapeStatus.DISPONIVEL);
                return vhsRepository.save(vhs);
            }
        }
        return null;
    }
=======
>>>>>>> 94be84c198fc5841158e3b6036a40f20ec424843
}
