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


}
