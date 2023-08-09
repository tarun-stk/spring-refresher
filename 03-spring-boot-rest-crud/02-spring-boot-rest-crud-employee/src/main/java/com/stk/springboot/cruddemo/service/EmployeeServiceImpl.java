package com.stk.springboot.cruddemo.service;

import com.stk.springboot.cruddemo.dao.EmployeeDao;
import com.stk.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

//    delcare employeedao
    private EmployeeDao employeeDao;

//    inject employeeDao
    public EmployeeServiceImpl(EmployeeDao theEmployeeDao){
        employeeDao = theEmployeeDao;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(Integer theId) {
        Employee employee = employeeDao.findById(theId);
        if(employee == null)
            throw new RuntimeException("Employee with given id: " + theId + ", not found");
        return employee;
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDao.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(Integer theId) {
        employeeDao.deleteById(theId);
    }
}
