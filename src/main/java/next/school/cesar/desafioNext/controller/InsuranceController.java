package next.school.cesar.desafioNext.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import next.school.cesar.desafioNext.entity.Insurance;
import next.school.cesar.desafioNext.repository.InsuranceRepository;

@RequestMapping("/Insurance")
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InsuranceController {
    private InsuranceRepository repository;

    @GetMapping
    public ResponseEntity<List<Insurance>> getAll() {
        return new ResponseEntity<List<Insurance>>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Insurance> getInsurance(@PathVariable Long id) {
        Optional<Insurance> optional = repository.findById(id);
        if(optional.isPresent()) {
            return new ResponseEntity<Insurance>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Insurance> createInsurance(@RequestBody Insurance i) {
        repository.save(i);
        return new ResponseEntity<Insurance>(i, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Insurance> update(@PathVariable Long id, @RequestBody Insurance i) {
        Optional<Insurance> optional = repository.findById(id);
        if(optional.isPresent()) {
            Insurance insurance = optional.get();
            insurance.setAnalysis(insurance.getAnalysis());
            insurance.setClient(insurance.getClient());
            insurance.setObservation(insurance.getObservation());
            insurance.setRisk(insurance.getRisk());
            insurance.setType(insurance.getType());
            insurance.setCreatedAt(insurance.getCreatedAt());
            insurance.setValidatedAt(insurance.getValidatedAt());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Insurance> delete(@PathVariable Long id) {
        Optional<Insurance> optional = repository.findById(id);
        if(optional.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}