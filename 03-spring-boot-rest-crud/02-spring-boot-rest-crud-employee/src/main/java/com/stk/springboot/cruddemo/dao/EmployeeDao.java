package com.stk.springboot.cruddemo.dao;

import com.stk.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();
    Employee findById(Integer theId);
    Employee save(Employee theEmployee);
    void deleteById(Integer theId);

}














