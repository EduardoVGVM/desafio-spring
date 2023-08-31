package next.school.cesar.desafioNext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import next.school.cesar.desafioNext.entity.House;

@Repository //Declara interface como um repositório
public interface HouseRepository extends JpaRepository<House, Long>{
    List<House> findByZipcode(@Param(value = "zipcode") String zipcode);
    //Método para poder encontrar uma casa pelo seu zipcode
    // já que não iremos utilizar seu id
}