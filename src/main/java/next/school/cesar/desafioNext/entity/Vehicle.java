package next.school.cesar.desafioNext.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder //Automatizar criação de código através do lombok
@Data //Simplificar métodos ToString, Getters e Setters
@AllArgsConstructor //Construtor completo
@NoArgsConstructor //Construtor vazio
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;
    private int year;
    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = true, referencedColumnName = "id")
    private Client client;
}