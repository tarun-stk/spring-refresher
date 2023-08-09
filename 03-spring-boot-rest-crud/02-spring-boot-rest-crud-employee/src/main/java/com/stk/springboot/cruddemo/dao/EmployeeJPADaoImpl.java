package com.stk.springboot.cruddemo.dao;

import com.stk.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeJPADaoImpl implements EmployeeDao{

//    Create field for entityManager
    private EntityManager entityManager;


//    inject entityt manager uysing constructotr injection
    public EmployeeJPADaoImpl(EntityManager theEntityManager){
//        EntityManager is already created by spring container, just injecting it
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
//        create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
//        execute the query
        List<Employee> employees = theQuery.getResultList();
//        return the result
        return employees;
    }

    @Override
    public Employee findById(Integer theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
//        merge:
//            if the given id is 0, inserts a new record(save)
//            if the given id is not 0, updates the record (update)
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(Integer theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        entityManager.remove(theEmployee);
    }
}
