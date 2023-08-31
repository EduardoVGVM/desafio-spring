package next.school.cesar.desafioNext.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import next.school.cesar.desafioNext.entity.Vehicle;
import next.school.cesar.desafioNext.repository.VehicleRepository;

@RequestMapping("/vehicle")
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleController {
    private VehicleRepository repository;

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle v) {
        repository.save(v);
        return new ResponseEntity<Vehicle>(v, HttpStatus.OK);
    }

    @PutMapping("/{id}/{client_id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Vehicle> update(@PathVariable Long id, @RequestBody Vehicle v, @PathVariable Long client_id) {
        Optional<Vehicle> optional = repository.findById(id);
        if(optional.isPresent()) {
            Vehicle vehicle = optional.get();
            vehicle.setClient(vehicle.getClient());
            return new ResponseEntity<>(v,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vehicle> delete(@PathVariable Long id) {
        Optional<Vehicle> optional = repository.findById(id);
        if(optional.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}