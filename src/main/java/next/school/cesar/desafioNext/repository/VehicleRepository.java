package next.school.cesar.desafioNext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import next.school.cesar.desafioNext.entity.Vehicle;

@Repository //Declara interface como um repositório
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
    
}