package com.concesionario.controller;

import com.concesionario.controller.dto.EmployeeDTO;
import com.concesionario.persistence.entities.Employee;
import com.concesionario.service.interfaces.IEmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id){

        Optional<Employee> optionalEmployee = this.employeeService.findById(id);

        if (optionalEmployee.isPresent()){

            Employee employee = optionalEmployee.get();
            EmployeeDTO employeeDTO = this.modelMapper.map(employee, EmployeeDTO.class);

            return ResponseEntity.ok(employeeDTO);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/find")
    public ResponseEntity<List<EmployeeDTO>> findAll(){

        List<EmployeeDTO> employeeDTOList = this.employeeService.findAll()
                .stream()
                .map(employee -> this.modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(employeeDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeDTO> save(@RequestBody EmployeeDTO employeeDTO) throws URISyntaxException {

        Employee employee = this.modelMapper.map(employeeDTO, Employee.class);
        this.employeeService.save(employee);

        return ResponseEntity.created(new URI("/employee/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){

        Optional<Employee> optionalEmployee = this.employeeService.findById(id);

        if (optionalEmployee.isPresent()){

            Employee employee = optionalEmployee.get();
            employee.setUser(employeeDTO.getUser());
            employee.setName(employeeDTO.getName());
            employee.setEmail(employeeDTO.getEmail());
            employee.setPhone(employeeDTO.getPhone());
            employee.setCharge(employeeDTO.getCharge());
            employee.setLastName(employeeDTO.getEmail());
            employee.setAddress(employeeDTO.getAddress());
            employee.setIdentity(employeeDTO.getIdentity());
            employee.setBirthDate(employeeDTO.getBirthDate());
            this.employeeService.save(employee);

            return ResponseEntity.ok(employeeDTO);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

        Optional<Employee> optionalEmployee = this.employeeService.findById(id);

        if (optionalEmployee.isPresent()){

            this.employeeService.deleteById(id);

            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }
}

