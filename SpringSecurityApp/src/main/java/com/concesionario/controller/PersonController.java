package com.concesionario.controller;

import com.concesionario.controller.dto.PersonDTO;
import com.concesionario.persistence.entities.Person;
import com.concesionario.service.interfaces.IPersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/find")
    public ResponseEntity<List<PersonDTO>> findAll(){

        List<PersonDTO> personDTOList = this.personService.findAll()
                .stream()
                .map(person -> this.modelMapper.map(person, PersonDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(personDTOList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id){

        Optional<Person> optionalPerson = this.personService.findById(id);

        if (optionalPerson.isPresent()){

            Person person = optionalPerson.get();

            PersonDTO personDTO = this.modelMapper.map(person, PersonDTO.class);

            return ResponseEntity.ok(personDTO);
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/save")
    public ResponseEntity<PersonDTO> save(@RequestBody PersonDTO personDTO) throws URISyntaxException {

        Person person = this.modelMapper.map(personDTO, Person.class);
        this.personService.save(person);

        return ResponseEntity.created(new URI("/person/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO personDTO, @PathVariable Long id){

        Optional<Person> optionalPerson = this.personService.findById(id);

        if (optionalPerson.isPresent()){

            Person person = optionalPerson.get();
            person.setName(personDTO.getName());
            person.setEmail(personDTO.getEmail());
            person.setPhone(personDTO.getPhone());
            person.setLastName(personDTO.getEmail());
            person.setAddress(personDTO.getAddress());
            person.setIdentity(personDTO.getIdentity());
            person.setBirthDate(personDTO.getBirthDate());
            this.personService.save(person);

            return ResponseEntity.ok(personDTO);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

        Optional<Person> optionalPerson = this.personService.findById(id);

        if(optionalPerson.isPresent()){

            this.personService.deleteById(id);

            return ResponseEntity.ok("Usuario eliminado");
        }

        return  ResponseEntity.badRequest().build();
    }

}
