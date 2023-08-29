package next.school.cesar.desafioNext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import next.school.cesar.desafioNext.entity.House;

@Repository //Declara interface como um repositório
public interface HouseRepository extends JpaRepository<House, Long>{
    
}