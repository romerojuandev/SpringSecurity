package com.concesionario.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()") //Hay que tener @EnableMethodSecurity en el SecurityConfig
public class TestAuthController {

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('READ')")
    public String helloGet(){
        return "Hello world - GET";
    }

    @PostMapping("/post")
    @PreAuthorize("hasAuthority('CREATE')")
    public String helloPost(){
        return "Hello world - POST";
    }

    @PutMapping("/put")
    @PreAuthorize("hasAuthority('CREATE') or hasAuthority('UPDATE')")
    public String helloPut(){
        return "Hello world - PUT";
    }

    @PutMapping("/delete")
    public String helloDelete(){
        return "Hello world - DELETE";
    }

    @PutMapping("/patch")
    public String helloPatch(){
        return "Hello world - PATCH";
    }
}
