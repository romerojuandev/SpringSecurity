package com.concesionario.controller;

import com.concesionario.controller.dto.RoleEntityDTO;
import com.concesionario.persistence.entities.RoleEntity;
import com.concesionario.service.interfaces.IRoleEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
@PreAuthorize("denyAll()")
public class RoleEntityController {

    @Autowired
    private IRoleEntityService roleEntityService;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("find/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<RoleEntityDTO> findById(@PathVariable Long id){

        Optional<RoleEntity> entityOptional = roleEntityService.findById(id);

        if(entityOptional.isPresent()){
            RoleEntity roleEntity = entityOptional.get();
            RoleEntityDTO roleEntityDTO = modelMapper.map(roleEntity, RoleEntityDTO.class);

            return ResponseEntity.ok(roleEntityDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<List<RoleEntityDTO>> findAll(){

        List<RoleEntityDTO> roleEntityDTOList = roleEntityService.findAll()
                .stream()
                .map(rol -> modelMapper.map(rol, RoleEntityDTO.class))
                .toList();

        return ResponseEntity.ok(roleEntityDTOList);
    }
}
