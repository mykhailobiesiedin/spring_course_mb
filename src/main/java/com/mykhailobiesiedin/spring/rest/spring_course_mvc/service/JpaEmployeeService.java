package com.mykhailobiesiedin.spring.rest.spring_course_mvc.service;

import com.mykhailobiesiedin.spring.rest.spring_course_mvc.entity.Employee;
import com.mykhailobiesiedin.spring.rest.spring_course_mvc.exceptions.NoSuchEmployeeException;
import com.mykhailobiesiedin.spring.rest.spring_course_mvc.repository.JpaEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaEmployeeService implements JpaEmployeeServiceInterface {
    @Autowired
    private JpaEmployeeRepository repository;


    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public Employee getById(long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchEmployeeException(
                "There is no employee with ID = " + id + "in Database"));
    }

    @Override
    public void add(Employee employee) {
        repository.save(new Employee( employee.getName(), employee.getSurname(),
                employee.getDepartment(), employee.getSalary(), employee.getEmail(),
                employee.getEmployee_username(), employee.getPassword()));
    }

    @Override
    public void updateEmployee(Employee employee){
        repository.save(employee);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteEmployeeByName(String name) {
        repository.deleteEmployeeByName(name);
    }

    @Override
    public Employee createOrUpdateEmployee(Employee employee){
        Employee employee1 = repository.findEmployeeByEmail(employee.getEmail());

        if (employee1 == null){
            return repository.save(new Employee(employee.getName(), employee.getSurname(),
                    employee.getDepartment(), employee.getSalary(), employee.getEmail(),
                    employee.getEmployee_username(), employee.getPassword()));

        } else{
            employee1.setName(employee.getName());
            employee1.setSurname(employee.getSurname());
            employee1.setDepartment(employee.getDepartment());
            employee1.setSalary(employee.getSalary());
            employee1.setEmail(employee.getEmail());
            employee1.setEmployee_username(employee.getEmployee_username());
            employee1.setPassword(employee.getPassword());
        }
        return employee1;
    }
}
