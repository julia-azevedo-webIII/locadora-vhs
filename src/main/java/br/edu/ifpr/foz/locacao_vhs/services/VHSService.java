package br.edu.ifpr.foz.locacao_vhs.services;

import br.edu.ifpr.foz.locacao_vhs.models.*;
import br.edu.ifpr.foz.locacao_vhs.repositories.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VHSService {
    @Autowired
    VHSRepository vhsRepository;

    public List<VHS> findAll() {
        return vhsRepository.findAll();
    }
}
