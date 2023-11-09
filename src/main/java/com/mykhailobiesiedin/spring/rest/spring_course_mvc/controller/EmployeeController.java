package com.mykhailobiesiedin.spring.rest.spring_course_mvc.controller;

import com.mykhailobiesiedin.spring.rest.spring_course_mvc.entity.Employee;
import com.mykhailobiesiedin.spring.rest.spring_course_mvc.exceptions.NoSuchEmployeeException;
import com.mykhailobiesiedin.spring.rest.spring_course_mvc.service.JpaEmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private JpaEmployeeServiceInterface service;

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable long id) {
        return service.getById(id);
    }

    @PostMapping
    public void createOrUpdate(@RequestBody Employee employee) {
        service.createOrUpdateEmployee(employee);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/delete-by-name/{name}")
    public void deleteEmployeeByName(@PathVariable String name) {
        service.deleteEmployeeByName(name);
    }
//    @PutMapping
//    public void updateEmployee(@RequestBody Employee employee){
//        service.updateEmployee(employee);
//    }

}
