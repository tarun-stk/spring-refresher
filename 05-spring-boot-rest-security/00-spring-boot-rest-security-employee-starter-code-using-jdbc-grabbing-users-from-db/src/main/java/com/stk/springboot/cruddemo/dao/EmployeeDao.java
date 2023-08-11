package com.stk.springboot.cruddemo.dao;

import com.stk.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}














