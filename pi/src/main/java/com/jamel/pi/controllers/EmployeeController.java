package com.jamel.pi.controllers;

import com.jamel.pi.dto.EmployeeAllDto;
import com.jamel.pi.dto.EmployeeDto;
import com.jamel.pi.dto.PostDto;
import com.jamel.pi.entities.Employee;
import com.jamel.pi.mappers.MapStructMapper;
import com.jamel.pi.repositories.EmployeeRepository;
import com.jamel.pi.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private MapStructMapper mapStructMapper;
    private EmployeeRepository employeeRepository;
    PostRepository postRepository ;

    //add new employee ***works***
    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        EmployeeDto e = new EmployeeDto(employee.getId(), employee.getNom(), employee.getPrenom());
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    //retrieve employee brief-information ***works***
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "id") Long id) {
        Employee our_e = employeeRepository.getById(id);
        EmployeeDto e_dto = new EmployeeDto(our_e.getId(), our_e.getNom(), our_e.getPrenom());
        return new ResponseEntity<>(e_dto,HttpStatus.OK);
    }

    //employee now creates his own posts ***works***
    @PostMapping("/{id}/posts/add")
    public ResponseEntity<EmployeeAllDto> addPost(@PathVariable(value = "id") Long id ,@RequestBody String c) {

        PostController postController = new PostController(mapStructMapper,postRepository);

        Employee our_e = employeeRepository.getById(id);

        PostDto p = postController.createPost(c, our_e);

        EmployeeAllDto e = mapStructMapper.employeeToEmployeeAllDto(our_e);

        e.setId(our_e.getId());
        e.setNom(our_e.getNom());
        e.setPrenom(our_e.getPrenom());

        return new ResponseEntity<>(e,HttpStatus.OK);
    }

}
