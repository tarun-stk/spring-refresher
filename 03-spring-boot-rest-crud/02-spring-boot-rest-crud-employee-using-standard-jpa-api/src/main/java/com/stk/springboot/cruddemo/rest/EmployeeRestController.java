package com.stk.springboot.cruddemo.rest;

import com.stk.springboot.cruddemo.dao.EmployeeDao;
import com.stk.springboot.cruddemo.entity.Employee;
import com.stk.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
//    inject employeedao using constructor injection
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

//    expose /employees to get all employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

//    expose /employees/{employeeId} to get employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable Integer employeeId){
        return employeeService.findById(employeeId);
    }

//    expose /employees to add a emoployee
    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){
        System.out.println("employee: " + theEmployee);
        return employeeService.save(theEmployee);
    }

    //    expose /employees to delete an emoployee by id
    @DeleteMapping("/employees/{employeeId}")
    public void deleteById(@PathVariable Integer employeeId){
        employeeService.deleteById(employeeId);
    }




}
















