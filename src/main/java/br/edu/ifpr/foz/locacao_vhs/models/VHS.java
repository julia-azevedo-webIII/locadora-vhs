package br.edu.ifpr.foz.locacao_vhs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class VHS {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String imageUrl; 
    private String registrationDate;

    //@ManyToOne
    //@JoinColumn(name = "category_id")
    //private Category category;
    //@Enumerated(EnumType.STRING)
    //private TapeStatus status;

}
