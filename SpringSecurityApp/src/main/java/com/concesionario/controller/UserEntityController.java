package com.concesionario.controller;

import com.concesionario.controller.dto.RoleEntityDTO;
import com.concesionario.controller.dto.UserEntityDTO;
import com.concesionario.persistence.entities.UserEntity;
import com.concesionario.service.interfaces.IUserEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@PreAuthorize("denyAll()")
public class UserEntityController {

    @Autowired
    private IUserEntityService userEntityService;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("find/{id}")
    @PreAuthorize("hasAuthority('READ')")
    ResponseEntity<UserEntityDTO> findById(@PathVariable Long id){

        Optional<UserEntity> entityOptional = userEntityService.findById(id);

        if(entityOptional.isPresent()){
            UserEntity userEntity = entityOptional.get();
            UserEntityDTO userEntityDTO = modelMapper.map(userEntity, UserEntityDTO.class);

            return ResponseEntity.ok(userEntityDTO);
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/find")
    @PreAuthorize("hasAuthority('READ')")
    ResponseEntity<List<UserEntityDTO>> findAll(){

        List<UserEntityDTO> userEntityDTOList = userEntityService.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserEntityDTO.class))
                .toList();

        return ResponseEntity.ok(userEntityDTOList);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('CREATE')")
    ResponseEntity<UserEntityDTO> save(@RequestBody UserEntityDTO userEntityDTO) throws URISyntaxException {

        if(userEntityDTO.getUsername().isBlank() || userEntityDTO.getPassword().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        UserEntity userEntity = modelMapper.map(userEntityDTO, UserEntity.class);
        String pass = userEntity.getPassword();
        userEntity.setPassword(new BCryptPasswordEncoder().encode(pass));
        userEntityService.save(userEntity);

        return ResponseEntity.created(new URI("/user/create")).build();
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    ResponseEntity<String> updateUser(@RequestBody UserEntityDTO userEntityDTO, @PathVariable Long id){

        Optional<UserEntity> entityOptional = userEntityService.findById(id);

        if(entityOptional.isPresent()){
            UserEntity userEntity = entityOptional.get();
            userEntity.setUsername(userEntityDTO.getUsername());
            userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntityDTO.getPassword()));
            userEntity.setRoles(userEntityDTO.getRoles());

            return ResponseEntity.ok("Usuario actuzalizado");
        }

        return  ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    ResponseEntity<String> deleteById(@PathVariable Long id){

        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        Optional<UserEntity> entityOptional = userEntityService.findById(id);

        if(entityOptional.isPresent()){
            userEntityService.deleteById(id);

            return ResponseEntity.ok("Usuario eliminado");
        }

        return ResponseEntity.badRequest().build();
    }

}
