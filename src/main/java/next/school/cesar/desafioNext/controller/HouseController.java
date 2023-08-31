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
import next.school.cesar.desafioNext.entity.House;
import next.school.cesar.desafioNext.repository.HouseRepository;

@RequestMapping("/house")
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HouseController {
    private HouseRepository repository;

    @PostMapping
    public ResponseEntity<House> createHouse(@RequestBody House h) {
        repository.save(h);
        return new ResponseEntity<House>(h, HttpStatus.OK);
    }

    @GetMapping("/{zipcode}")
    public ResponseEntity<List<House>> getbyzipCode(@PathVariable("zipcode") String zipcode){
        List<House> optional = repository.findByZipcode(zipcode);
        if(optional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(optional,HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<House> update(@PathVariable Long id, @RequestBody House h) {
        Optional<House> optional = repository.findById(id);
        if(optional.isPresent()) {
            House house = optional.get();
            house.setClient(house.getClient());
            house.setLocation(house.getLocation());
            house.setOwnership_status(house.getOwnership_status());
            house.setZipcode(house.getZipcode());
            return new ResponseEntity<>(h, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<House> delete(@PathVariable Long id) {
        Optional<House> optional = repository.findById(id);
        if(optional.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}