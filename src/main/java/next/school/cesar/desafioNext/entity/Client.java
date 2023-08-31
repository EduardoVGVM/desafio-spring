package next.school.cesar.desafioNext.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import next.school.cesar.desafioNext.enums.MaritalStatus;

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
    @Enumerated
    private MaritalStatus marital_status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", orphanRemoval = true)
    private List<House> houses;
    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "client", orphanRemoval = true)
    private List<Vehicle> vehicles;
    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "client", orphanRemoval = true)
    private List<Insurance> insurances;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}