package com.example.laptop;

import com.example.laptop.dao.LaptopDAO;
import com.example.laptop.entity.Laptop;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class LaptopApplication {

    @Bean
    public CommandLineRunner commandLineRunner (LaptopDAO theLaptopDAO){
        return runner ->{

            Scanner sc = new Scanner(System.in);

            System.out.println("\n------|| Welcome to Laptop Database Application ||-----\n");

            for (int j = 0; true; j++){
                System.out.println("\n1. Add Laptop");
                System.out.println("2. Fetch By ID");
                System.out.println("3. Fetch By IMIE");
                System.out.println("4. Update Laptop Details");
                System.out.println("5. Remove Laptop");
                System.out.println("6. Exit");
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
                            System.out.println("\n-----|| Welcome to add Laptop page ||------\n");

                            String brand = null, model = null, generation = null, processor = null;
                            long imie = 0;
                            int memory = 0, storage = 0;
                            double price = 0;
                            char ch = '\u0000';
                            for (int c = 1; true; c++){
                                try{
                                    System.out.print("Enter brand name : ");
                                    brand = sc.next();

                                    sc.nextLine();
                                    System.out.print("Enter model name : ");
                                    model = sc.nextLine();

                                    System.out.print("Enter IMIE number : ");
                                    imie = sc.nextLong();

                                    System.out.print("Enter Memory(GB) : ");
                                    memory = sc.nextInt();

                                    System.out.print("Enter Storage(GB) : ");
                                    storage = sc.nextInt();

                                    sc.nextLine();
                                    System.out.print("Enter Generation : ");
                                    generation = sc.nextLine();

                                    System.out.print("Enter Processor Name : ");
                                    processor = sc.nextLine();

                                    System.out.print("Enter the Price : ");
                                    price = sc.nextDouble();

                                    theLaptopDAO.save(new Laptop(brand, model, imie, memory,
                                            storage, generation, processor, price));
                                    System.out.println("Laptop Saved Successfully!\n");

                                    break;
                                }
                                catch (InputMismatchException e){
                                    System.out.println("\nPlease Give Right Input!\n");
                                    sc.nextLine();
                                    System.out.print("Do you want go to Continue?(y/n) : ");
                                    ch = sc.next().toLowerCase().charAt(0);
                                    if (ch == 'n'){
                                        break;
                                    }
                                }
                            }

                            if (ch == 'n'){
                                ch = '\u0000';
                                break;
                            }

                            System.out.print("\nDo you want to add more Laptops(y/n)? : ");
                            ch = sc.next().toLowerCase().charAt(0);

                            if (ch == 'n'){
                                break;
                            }
                            System.out.println();
                        }
                        break;
                    }
                    case 2:
                    {
                        Laptop byID = null;
                        int attmp = 3;
                        for (int e = 0; e < 3; e++){
                            try{
                                System.out.print("Enter the Laptop ID to Fetch by ID : ");
                                byID =  theLaptopDAO.findByID(sc.nextByte());
                                break;
                            }
                            catch (InputMismatchException f){
                                System.out.println("\nAttempts Left " + --attmp);
                                System.out.println("Please Enter Laptop ID Only!\n");
                                sc.nextLine();
                            }

                            if (attmp == 0){
                                System.out.println("Don't Come Again!\n");
                                return;
                            }
                        }

                        if (byID != null){
                            System.out.println();
                            System.out.println(byID);
                            System.out.println("Laptop Found!\n");
                        }
                        else {
                            System.out.println("\nNo Records Found!\n");
                        }

                        break;
                    }
                    case 3:
                    {
                        Laptop byIMIE = null;
                        int attmp = 3;
                        for (int e = 0; e < 3; e++){
                            try{
                                System.out.print("Enter the Laptop IMIE to Fetch by IMIE : ");
                                byIMIE =  theLaptopDAO.findByIMIE(sc.nextLong());

                                break;
                            }
                            catch (InputMismatchException f){
                                System.out.println("\nAttempts Left " + --attmp);
                                System.out.println("Please Enter Valid IMEI!\n");
                                sc.nextLine();
                            }

                            if (attmp == 0){
                                System.out.println("Don't Come Again!\n");
                                return;
                            }
                        }

                        if (byIMIE != null){
                            System.out.println(byIMIE);
                            System.out.println("\nLaptop Found!\n");
                        }
                        else {
                            System.out.println("\nNo Records Found!\n");
                        }

                        break;
                    }
                    case 4:
                    {
                        int attmp = 3;
                        for (int e = 0; e < 3; e++) {
                            try {
                                System.out.print("Enter the Laptop ID : ");
                                theLaptopDAO.update(sc.nextInt());
                                break;
                            } catch (InputMismatchException f) {
                                System.out.println("\nAttempts Left " + --attmp);
                                System.out.println("Please Enter Valid Laptop ID!\n");
                                sc.nextLine();
                            }

                            if (attmp == 0) {
                                System.out.println("Don't Come Again!\n");
                                return;
                            }
                        }
                        break;
                    }
                    case 5:
                    {
                        int attmp = 3;
                        for (int e = 0; e < 3; e++) {
                            try {
                                System.out.print("Enter the Laptop ID : ");
                                theLaptopDAO.remove(sc.nextInt());
                                break;
                            } catch (InputMismatchException f) {
                                System.out.println("\nAttempts Left " + --attmp);
                                System.out.println("Please Enter Valid Laptop ID!\n");
                                sc.nextLine();
                            }

                            if (attmp == 0) {
                                System.out.println("Don't Come Again!\n");
                                return;
                            }
                        }
                        break;
                    }
                    case 6:
                    {
                        return;
                    }
                    default:{
                        System.out.println("\nPlease Select Right Option!\n");
                    }
                }
            }
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(LaptopApplication.class, args);
	}

}
