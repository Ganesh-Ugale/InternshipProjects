package com.example.Employee.dao;

import com.example.Employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
//    Requirements
    public void save (Employee theEmployee);
    public void fetch();
    public Employee fetchByID (int empID);
    public Employee fetchByContInfo (long contNum);
    public Employee fetchByFirstName (String firstName);
    public Employee fetchByLastName (String lastName);
    public Employee fetchByDesignation(String designation);
    public Employee fetchBySalary(double salary);
    public List<Employee> fetchAll();
    public void update(int empID);
    public void remove(int empID);
}
