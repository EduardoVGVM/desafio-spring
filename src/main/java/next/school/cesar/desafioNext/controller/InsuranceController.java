package next.school.cesar.desafioNext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import next.school.cesar.desafioNext.entity.Insurance;
import next.school.cesar.desafioNext.repository.InsuranceRepository;

@RequestMapping("/insurance")
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InsuranceController {
    private InsuranceRepository repository;

    @PostMapping("/life")
    public ResponseEntity<Insurance> lifeInsurance(@RequestBody Insurance i) {
        repository.save(i);
        return new ResponseEntity<Insurance>(i, HttpStatus.OK);
    }

    @PostMapping("/disability")
    public ResponseEntity<Insurance> disabilityInsurance(@RequestBody Insurance i) {
        repository.save(i);
        return new ResponseEntity<Insurance>(i, HttpStatus.OK);
    }

    @PostMapping("/home")
    public ResponseEntity<Insurance> homeInsurance(@RequestBody Insurance i) {
        repository.save(i);
        return new ResponseEntity<Insurance>(i, HttpStatus.OK);
    }

    @PostMapping("/auto")
    public ResponseEntity<Insurance> autoInsurance(@RequestBody Insurance i) {
        repository.save(i);
        return new ResponseEntity<Insurance>(i, HttpStatus.OK);
    }

}