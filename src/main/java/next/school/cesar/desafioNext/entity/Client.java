package next.school.cesar.desafioNext.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import next.school.cesar.enums.MaritalStatus;

@Entity //Declara classe como uma entidade que possa ser tabelada no banco
@Builder //Automatizar criação de código através do lombok
@Data //Simplificar métodos ToString, Getters e Setters
@AllArgsConstructor //Construtor completo
@NoArgsConstructor //Construtor vazio
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private int dependents;
    private double income;
    private MaritalStatus marital_status;
    @OneToMany(mappedBy = "Client", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private House[] houses;
    @OneToMany(mappedBy = "Client", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Vehicle[] vehicles;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}