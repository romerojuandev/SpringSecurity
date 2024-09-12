package com.concesionario.controller;

import com.concesionario.controller.dto.SaleDTO;
import com.concesionario.persistence.entities.Sale;
import com.concesionario.service.interfaces.ISaleService;
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
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/find")
    public ResponseEntity<List<SaleDTO>> findAll(){

        List<SaleDTO> saleDTOList = this.saleService.findAll()
                .stream()
                .map(sale -> this.modelMapper.map(sale, SaleDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(saleDTOList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SaleDTO> findById(@PathVariable Long id){

        Optional<Sale> optionalSale = this.saleService.findById(id);

        if (optionalSale.isPresent()){

            Sale sale = optionalSale.get();
            SaleDTO saleDTO = this.modelMapper.map(sale, SaleDTO.class);

            return ResponseEntity.ok(saleDTO);
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/save")
    public ResponseEntity<SaleDTO> save(@RequestBody SaleDTO saleDTO) throws URISyntaxException {

        Sale sale = this.modelMapper.map(saleDTO, Sale.class);
        this.saleService.save(sale);

        return ResponseEntity.created(new URI("/sale/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SaleDTO> update(@PathVariable Long id, @RequestBody SaleDTO saleDTO){

        Optional<Sale> optionalSale = this.saleService.findById(id);

        if (optionalSale.isPresent()){

            Sale sale = optionalSale.get();
            sale.setDate(saleDTO.getDate());
            sale.setAmount(saleDTO.getAmount());
            sale.setVehicle(saleDTO.getVehicle());
            sale.setCustomer(saleDTO.getCustomer());
            sale.setEmployee(saleDTO.getEmployee());
            sale.setDescription(saleDTO.getDescription());
            this.saleService.save(sale);

            return ResponseEntity.ok(saleDTO);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteByID(@PathVariable Long id){

        Optional<Sale> optionalSale = this.saleService.findById(id);

        if (optionalSale.isPresent()){

            this.saleService.deleteById(id);

            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }

}
