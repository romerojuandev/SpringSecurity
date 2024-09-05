package com.concesionario.controller;

import com.concesionario.controller.dto.VehicleDTO;
import com.concesionario.persistence.entities.Vehicle;
import com.concesionario.service.interfaces.IVehicleService;
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
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/find")
    public ResponseEntity<List<VehicleDTO>> findAll(){

        List<VehicleDTO> vehicleDTOList = this.vehicleService.findAll()
                .stream()
                .map(vehicle -> this.modelMapper.map(vehicle, VehicleDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(vehicleDTOList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<VehicleDTO> findById(@PathVariable Long id){

        Optional<Vehicle> optionalVehicle = this.vehicleService.findById(id);

        if (optionalVehicle.isPresent()){

            Vehicle vehicle = optionalVehicle.get();
            VehicleDTO vehicleDTO = this.modelMapper.map(vehicle, VehicleDTO.class);

            return ResponseEntity.ok(vehicleDTO);
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/save")
    public ResponseEntity<VehicleDTO> save(@RequestBody VehicleDTO vehicleDTO) throws URISyntaxException {

        Vehicle vehicle = this.modelMapper.map(vehicleDTO, Vehicle.class);
        this.vehicleService.save(vehicle);

        return ResponseEntity.created(new URI("/vehicle/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<VehicleDTO> update(@RequestBody VehicleDTO vehicleDTO, @PathVariable Long id){

        Optional<Vehicle> optionalVehicle = this.vehicleService.findById(id);

        if(optionalVehicle.isPresent()){

            Vehicle vehicle = optionalVehicle.get();
            vehicle.setColor(vehicleDTO.getColor());
            vehicle.setModel(vehicleDTO.getModel());
            vehicle.setMileage(vehicleDTO.getMileage());
            vehicle.setMaker(vehicleDTO.getMaker());
            vehicle.setPlate(vehicleDTO.getPlate());
            vehicle.setPrice(vehicleDTO.getPrice());
            vehicle.setDescription(vehicleDTO.getDescription());
            vehicle.setEngine(vehicleDTO.getEngine());
            vehicle.setYear(vehicleDTO.getYear());

            this.vehicleService.save(vehicle);

            return ResponseEntity.ok(vehicleDTO);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

        Optional<Vehicle> optionalVehicle = this.vehicleService.findById(id);

        if (optionalVehicle.isPresent()){

            this.vehicleService.deleteById(id);

            return ResponseEntity.ok("Registro eliminado.");
        }

        return ResponseEntity.badRequest().build();
    }

}
