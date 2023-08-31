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
import next.school.cesar.desafioNext.entity.Client;
import next.school.cesar.desafioNext.repository.ClientRepository;

@RequestMapping("/client")
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {
    private ClientRepository repository;

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        return new ResponseEntity<List<Client>>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        Optional<Client> optional = repository.findById(id);
        if(optional.isPresent()) {
            return new ResponseEntity<Client>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client c) {
        repository.save(c);
        return new ResponseEntity<Client>(c, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client c) {
        Optional<Client> optional = repository.findById(id);
        if(optional.isPresent()) {
            Client client = optional.get();
            client.setName(client.getName());
            client.setAge(client.getAge());
            client.setMarital_status(client.getMarital_status());
            client.setDependents(client.getDependents());
            client.setIncome(client.getIncome());
            client.setVehicles(client.getVehicles());
            client.setHouses(client.getHouses());
            return new ResponseEntity<>(c,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete(@PathVariable Long id) {
        Optional<Client> optional = repository.findById(id);
        if(optional.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}