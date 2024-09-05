package com.concesionario.controller;

import com.concesionario.controller.dto.MakerDTO;
import com.concesionario.persistence.entities.Maker;
import com.concesionario.service.interfaces.IMakerService;
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
@RequestMapping("/maker")
public class MakerController {

    @Autowired
    private IMakerService makerService;

    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/find")
    public ResponseEntity<List<MakerDTO>> findAll(){

        List<MakerDTO> makerDTOList = this.makerService.findAll()
                .stream()
                .map(maker -> this.modelMapper.map(maker, MakerDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(makerDTOList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MakerDTO> findById(@PathVariable Long id){

        Optional<Maker> optionalMaker = this.makerService.findById(id);

        if (optionalMaker.isPresent()){

            Maker maker = optionalMaker.get();
            MakerDTO makerDTO = this.modelMapper.map(maker, MakerDTO.class);

            return ResponseEntity.ok(makerDTO);
        } else {

            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<MakerDTO> save(@RequestBody MakerDTO makerDTO) throws URISyntaxException {

        Maker maker = this.modelMapper.map(makerDTO, Maker.class);
        this.makerService.save(maker);

        return ResponseEntity.created(new URI("/maker/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MakerDTO> update(@PathVariable Long id, @RequestBody MakerDTO makerDTO){

        Optional<Maker> optionalMaker = this.makerService.findById(id);

        if (optionalMaker.isPresent()){

            Maker maker = optionalMaker.get();
            maker.setName(makerDTO.getName());
            this.makerService.save(maker);

            return ResponseEntity.ok(makerDTO);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

        Optional<Maker> optionalMaker = this.makerService.findById(id);

        if (optionalMaker.isPresent()){

            this.makerService.deleteById(id);

            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }
}
