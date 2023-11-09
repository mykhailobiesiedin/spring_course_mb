package com.mykhailobiesiedin.spring.rest.spring_course_mvc.service;

import com.mykhailobiesiedin.spring.rest.spring_course_mvc.entity.Employee;

import java.util.List;

public interface JpaEmployeeServiceInterface {
    List<Employee> getAll();

    Employee getById(long id);

    void add(Employee employee);

    void deleteById(long id);

    void deleteEmployeeByName(String name);

    void updateEmployee(Employee employee);

    Employee createOrUpdateEmployee(Employee employee);

}
