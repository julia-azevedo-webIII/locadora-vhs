package br.edu.ifpr.foz.locacao_vhs.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    private boolean administrador;

    @OneToMany(mappedBy = "usuario")
    private List<VHS> fitasAlugadas;

}
