package com.example.Employee;

import com.example.Employee.dao.EmployeeDAO;
import com.example.Employee.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EmployeeApplication {

    @Bean
    public CommandLineRunner commandLineRunner (EmployeeDAO theEmployeeDAO){
        return runner ->{

            Scanner sc = new Scanner(System.in);

            System.out.println("\n------|| Welcome to Employee Database Application ||-----");

            for (int j = 0; true; j++){
                System.out.println("\n1. Add Employee");
                System.out.println("2. Display Employee");
                System.out.println("3. Update Employee Details");
                System.out.println("4. Remove Employee");
                System.out.println("5. Exit");
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
                        System.out.println("Please Select from 1 to 5 Only!\n");
                        sc.nextLine();
                    }
                }

                if (attm == 0){
                    System.out.println("Don't Come Again!\n");
                    return;
                }

                switch (op){
                    case 1:
                    {
                        for (int i = 0; true; i++){
                            System.out.println("\n-----|| Welcome to add employee page ||------\n");

                            String firstName,lastName,designation;
                            long contact;
                            double sal;

                            for (int m = 0; true; m++){
                                try{
                                    System.out.print("Enter Employee First Name : ");
                                    firstName = sc.next();
                                    System.out.print("Enter Employee Last Name : ");
                                    lastName = sc.next();
                                    sc.nextLine();
                                    System.out.print("Enter Employee Designation : ");
                                    designation = sc.nextLine();
                                    System.out.print("Enter Employee Contact Info : ");
                                    contact = sc.nextLong();
                                    System.out.print("Enter Employee salary : ");
                                    sal = sc.nextDouble();
                                    break;
                                }
                                catch (InputMismatchException e){
                                    System.out.println("\nPlease give Right Input\n");
                                    sc.nextLine();
                                }
                            }

                            theEmployeeDAO.save(new Employee(firstName,lastName,contact,designation,sal));
                            System.out.println("\nEmployee Saved Successfully!");

//                          Attempts Lefts
                            char ch = '\u0000';
                            byte att = 3;

                                for (int k = 0; k < 3; k++){
                                    System.out.print("\n Do you want to add More Employees?(y/n) : ");
                                    ch = sc.next().toLowerCase().charAt(0);

                                    if (ch == 'y' || ch == 'n'){
                                        break;
                                    }

                                    if (i == 4){
                                        return;
                                    }
                                    System.out.println("Attempts Left " + --att);
                                }

                                if (ch == 'n') {
                                    break;
                                }
                            System.out.println();
                        }
                        break;
                    }
                    case 2:
                    {
                        theEmployeeDAO.fetch();
                        break;
                    }
                    case 3:
                    {
                        for (int y = 0; true; y++){
                            try{
                                System.out.print("Enter the Employee ID : ");
                                theEmployeeDAO.update(sc.nextInt());
                                break;
                            }
                            catch (InputMismatchException e){
                                System.out.println("\nPlease Enter Employee ID Only!\n");
                                sc.nextLine();
                            }
                        }
                        break;
                    }
                    case 4:
                    {
                        for (int w = 0; true; w++){
                            try{
                                System.out.print("Enter the Employee ID : ");
                                theEmployeeDAO.remove(sc.nextInt());
                                break;
                            }
                            catch (InputMismatchException e){
                                System.out.println("\nPlease Enter Employee ID Only!\n");
                                sc.nextLine();
                            }
                        }
                        break;
                    }
                    case 5:
                    {
                        System.out.println("\nThank You, Come Again :-)!\n");
                        return;
                    }
                    default:{
                        System.out.println("Please Select Right Option!");
                    }
                }
            }
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
}
