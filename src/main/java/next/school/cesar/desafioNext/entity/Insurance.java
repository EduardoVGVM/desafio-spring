package next.school.cesar.desafioNext.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import next.school.cesar.desafioNext.enums.InsuranceAnalysis;
import next.school.cesar.desafioNext.enums.InsuranceType;

@Entity //Declara classe como uma entidade que possa ser tabelada no banco
@Builder //Automatizar criação de código através do lombok
@Data //Simplificar métodos ToString, Getters e Setters
@AllArgsConstructor //Construtor completo
@NoArgsConstructor //Construtor vazio
public class Insurance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated
    private InsuranceType type;
    private int risk;
    @Enumerated
    private InsuranceAnalysis analysis;
    private String observation;
    private LocalDate createdAt;
    private LocalDate validatedAt;
    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = true, referencedColumnName = "id")
    private Client client;
}