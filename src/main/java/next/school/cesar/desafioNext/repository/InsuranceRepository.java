package next.school.cesar.desafioNext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import next.school.cesar.desafioNext.entity.Insurance;

@Repository //Declara interface como um repositório
public interface InsuranceRepository extends JpaRepository<Insurance, Long>{
    
}