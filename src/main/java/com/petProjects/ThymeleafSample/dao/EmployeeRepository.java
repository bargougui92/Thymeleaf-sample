package com.petProjects.ThymeleafSample.dao;

import com.petProjects.ThymeleafSample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name... SpringDataJPA will parse the name of the methode
    public List<Employee> findAllByOrderByLastNameAsc();

}
