package com.mykhailobiesiedin.spring.rest.spring_course_mvc.repository;

import com.mykhailobiesiedin.spring.rest.spring_course_mvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeByEmail(String email);
    void deleteEmployeeByName(String name);
}
