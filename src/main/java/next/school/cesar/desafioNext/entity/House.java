package next.school.cesar.desafioNext.entity;

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
import next.school.cesar.desafioNext.enums.OwnershipStatus;

@Entity //Declara classe como uma entidade que possa ser tabelada no banco
@Builder //Automatizar criação de código através do lombok
@Data //Simplificar métodos ToString, Getters e Setters
@AllArgsConstructor //Construtor completo
@NoArgsConstructor //Construtor vazio
public class House {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated
    private OwnershipStatus ownership_status;
    private String location;
    private String zipcode;
    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = true, referencedColumnName = "id")
    private Client client;
}