package com.example.Employee.dao.daoImpl;

import com.example.Employee.dao.EmployeeDAO;
import com.example.Employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager theManager;
    private int size = 0;

    @Autowired
    public EmployeeDAOImpl(EntityManager theManager) {
        this.theManager = theManager;
        size = size();
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        size++;
        theManager.persist(theEmployee);
    }

    @Override
    public void fetch() {

        if (size == 0){
            System.out.println("\nDatabase is Empty!\n");
            return;
        }

        Scanner sc = new Scanner(System.in);

        for (int i = 0; true; i++){
            System.out.println("\n----|| Welcome to Display Menu ||----\n");

            System.out.println("1. Fetch by UNIC ID");
            System.out.println("2. Fetch by First Name");
            System.out.println("3. Fetch by Last Name");
            System.out.println("4. Fetch by Contact Info");
            System.out.println("5. Fetch by Designation");
            System.out.println("6. Fetch by Salary");
            System.out.println("7. Fetch All");
            System.out.println("8. Exit");
            System.out.println();

            int attm = 3, op = 0;
            for (int l = 0; l < 3; l++){
                try{
                    System.out.print("Select Option : ");
                    op = sc.nextByte();
                    break;
                }
                catch (InputMismatchException e){
                    System.out.println("\nAttempts Left " + --attm);
                    System.out.println("Please Select from 1 to 8 Only!\n");
                    sc.nextLine();
                }
            }

            switch (op){
                case 1:
                {
                    Employee byID = null;
                    for (int z = 0; true; z++){
                        try{
                            System.out.print("Enter the employee ID : ");
                            byID =  fetchByID(sc.nextByte());
                            break;
                        }
                        catch (InputMismatchException e){
                            System.out.println("\nPlease Give Employee ID Only!\n");
                            sc.nextLine();
                        }
                    }

                    if (byID != null){
                        System.out.println("\n"+byID);
                        System.out.println("Employee Found!\n");
                    }
                    else {
                        System.out.println("\nNo Records Found!\n");
                    }
                    break;
                }

                case 2:
                {
                    System.out.print("Enter the employee first name : ");
                    Employee byFirstName =  fetchByFirstName(sc.next());

                    if (byFirstName != null){
                        System.out.println("\n"+byFirstName);
                        System.out.println("Employee Found!\n");
                    }
                    else {
                        System.out.println("\nNo Records Found!\n");
                    }
                    break;
                }

                case 3:
                {
                    System.out.print("Enter the employee last name : ");
                    Employee byLastName =  fetchByLastName(sc.next());

                    if (byLastName != null){
                        System.out.println("\n"+byLastName);
                        System.out.println("Employee Found!\n");
                    }
                    else {
                        System.out.println("\nNo Records Found!\n");
                    }
                    break;
                }
                case 4:
                {
                    System.out.print("Enter the employee contact info : ");
                    Employee byContactInfo =  fetchByContInfo(sc.nextLong());

                    if (byContactInfo != null){
                        System.out.println("\n"+byContactInfo);
                        System.out.println("Employee Found!\n");
                    }
                    else {
                        System.out.println("\nNo Records Found!\n");
                    }
                    break;
                }
                case 5:
                {
                    System.out.print("Enter the employee designation : ");
                    Employee byDesignation =  fetchByDesignation(sc.nextLine());

                    if (byDesignation != null){
                        System.out.println("\n"+byDesignation);
                        System.out.println("Employee Found!\n");
                    }
                    else {
                        System.out.println("\nNo Records Found!\n");
                    }
                    break;
                }
                case 6:
                {
                    System.out.print("Enter the employee salary : ");
                    Employee bySalary =  fetchBySalary(sc.nextLong());

                    if (bySalary != null){
                        System.out.println("\n"+bySalary);
                        System.out.println("Employee Found!\n");
                    }
                    else {
                        System.out.println("\nNo Records Found!\n");
                    }
                    break;
                }
                case 7:
                {
                    List<Employee> byFetchAll =  fetchAll();

                    if (byFetchAll != null){
                        System.out.println();
                        for (Employee e: byFetchAll){
                            System.out.println(e);
                        }
                        System.out.println("Employees Found!\n");
                    }
                    else {
                        System.out.println("\nDatabase is Empty!\n");
                    }
                    break;
                }
                case 8:
                {
                    return;
                }
                default:{
                    System.out.println("\nPlease Select Right Option!\n");
                }
            }

//          Attempts Lefts
            char ch = '\u0000';
            byte att = 3;

            for (int j = 0; j < 3; j++){
                System.out.print("\n Do you want to Fetch More Employees?(y/n) : ");
                ch = sc.next().toLowerCase().charAt(0);

                if (ch == 'y'){
                    break;
                } else if (ch == 'n') {
                    return;
                }

                if (i == 4){
                    return;
                }
                System.out.println("Attempts Left " + --att);
            }

        }
    }

    @Override
    public Employee fetchByID(int empID) {
        return theManager.find(Employee.class,empID);
    }

    @Override
    public Employee fetchByContInfo(long contNum) {
        try{
            Query query = theManager.createQuery("select e from Employee e where e.contactInfo=:contactInfo");
            query.setParameter("contactInfo", contNum);
            return (Employee) query.getSingleResult();
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public Employee fetchByFirstName(String firstName) {
        try{
            Query query = theManager.createQuery("select e from Employee e where e.firstName=:firstName");
            query.setParameter("firstName", firstName);
            return (Employee) query.getSingleResult();
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public Employee fetchByLastName(String lastName) {
        try{
            Query query = theManager.createQuery("select e from Employee e where e.lastName=:lastName");
            query.setParameter("lastName", lastName);
            return (Employee) query.getSingleResult();
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public Employee fetchByDesignation(String designation) {
        try{
            Query query = theManager.createQuery("select e from Employee e where e.designation=:designation");
            query.setParameter("designation", designation);
            return (Employee) query.getSingleResult();
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public Employee fetchBySalary(double salary) {
        try{
            Query query = theManager.createQuery("select e from Employee e where e.salary=:salary");
            query.setParameter("salary", salary);
            return (Employee) query.getSingleResult();
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Employee> fetchAll() {
        Query query = theManager.createQuery("select e from Employee e");
        return query.getResultList();
    }

    @Override
    public void update(int empID) {

        if (size == 0){
            System.out.println("\nDatabase is Empty!\n");
            return;
        }
        Scanner sc = new Scanner(System.in);

        Employee isFound = theManager.find(Employee.class,empID);

        for (int i = 0; true; i++){
            System.out.println("\n1. Update Fist Name");
            System.out.println("2. Update Last Name");
            System.out.println("3. Update Contact Info");
            System.out.println("4. Update Designation");
            System.out.println("5. Update Salary");
            System.out.println("6. Exit");
            System.out.println();

            System.out.print("Select Option : ");
            int op = sc.nextByte();

            switch (op){
                case 1:
                {
                    if (isFound != null){
                        System.out.print("Enter the Employee first name : ");
                        isFound.setFirstName(sc.next());
                        System.out.println("Employee First Name Updated Successfully!");
                    }
                    else{
                        System.out.println("Employee Not Found!");
                    }
                    break;
                }

                case 2:
                {
                    if (isFound != null){
                        System.out.print("Enter the Employee last name : ");
                        isFound.setLastName(sc.next());
                        System.out.println("Employee last Name Updated Successfully!");
                    }
                    else{
                        System.out.println("Employee Not Found!");
                    }
                    break;
                }

                case 3:
                {
                    if (isFound != null){
                        System.out.print("Enter the Employee contact number : ");
                        isFound.setContactInfo(sc.nextLong());
                        System.out.println("Employee contact Info Updated Successfully!");
                    }
                    else{
                        System.out.println("Employee Not Found!");
                    }
                    break;
                }

                case 4:
                {
                    if (isFound != null){
                        System.out.print("Enter the Designation : ");
                        isFound.setDesignation(sc.nextLine());
                        System.out.println("Employee Designation Updated Successfully!");
                    }
                    else{
                        System.out.println("Employee Not Found!");
                    }
                    break;
                }

                case 5:
                {
                    if (isFound != null){
                        System.out.print("Enter the Employee Salary : ");
                        isFound.setSalary(sc.nextDouble());
                        System.out.println("Employee Salary Updated Successfully!");
                    }
                    else{
                        System.out.println("Employee Not Found!");
                    }
                    break;
                }

                case 6:
                {
                    return;
                }
                default:{
                    System.out.println("Please Select Right Options!");
                }
            }

    //      Attempts Lefts
            char ch = '\u0000';
            byte att = 3;

            for (int j = 0; j < 3; j++){
                System.out.print("\n Do you want to Update More Details?(y/n) : ");
                ch = sc.next().toLowerCase().charAt(0);

                if (ch == 'y'){
                    break;
                } else if (ch == 'n') {
                    return;
                }

                if (i == 4){
                    return;
                }
                System.out.println("Attempts Left " + --att);
            }
        }
    }

    @Override
    @Transactional
    public void remove(int empID) {
        if (size == 0){
            System.out.println("\nDatabase is Empty!");
            return;
        }
        Employee found = theManager.find(Employee.class,empID);

        if (found  != null){
            theManager.remove(found);
            size--;
            System.out.println("Employee removed Successfully!");
        }
        else{
            System.out.println("Employee Not Found!");
        }
    }

//    To Fetch the size of DB
    private int size(){
        List<Employee> temp = fetchAll();
        return temp.size();
    }
}
