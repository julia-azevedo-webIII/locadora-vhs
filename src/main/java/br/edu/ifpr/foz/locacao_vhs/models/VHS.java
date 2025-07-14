package br.edu.ifpr.foz.locacao_vhs.models;

import java.time.LocalDate;

import br.edu.ifpr.foz.locacao_vhs.TapeStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Entity
@Data
public class VHS {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String imageUrl; 
    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Enumerated(EnumType.STRING)
    private TapeStatus status;

    @PrePersist void onCreate() {
        registrationDate = LocalDate.now();
        if (status == null){
            status = TapeStatus.DISPONIVEL;
        }
    }

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}
