package com.jamel.pi.repositories;

import com.jamel.pi.entities.Employee;
import com.jamel.pi.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    Optional<Employee> findById(Long aLong);

    //List<Post> findAllById(Long id);

    @Override
    List<Employee> findAll();

    @Override
    long count();

    @Override
    void delete(Employee entity);

    @Override
    Employee getById(Long aLong);

    @Override
    <S extends Employee> S save(S entity);
}

