package com.example.laptop;

import com.example.laptop.dao.LaptopDAO;
import com.example.laptop.entity.Laptop;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class LaptopApplication {

    @Bean
    public CommandLineRunner commandLineRunner (LaptopDAO theLaptopDAO){
        return runner ->{

            Scanner sc = new Scanner(System.in);

            System.out.println("\n------|| Welcome to Laptop Database Application ||-----\n");

            for (int j = 0; true; j++){
                System.out.println("1. Add Laptop");
                System.out.println("2. Fetch By ID");
                System.out.println("3. Fetch By IMIE");
                System.out.println("4. Update Laptop Details");
                System.out.println("5. Remove Laptop");
                System.out.println("6. Exit");
                System.out.println();

                System.out.print("Select Option : ");
                int op = sc.nextByte();
                sc.nextLine();

                switch (op){
                    case 1:
                    {
                        for (int i = 0; true; i++){
                            System.out.println("\n-----|| Welcome to add Laptop page ||------\n");

                            System.out.print("Enter brand name : ");
                            String brand = sc.next();

                            sc.nextLine();
                            System.out.print("Enter model name : ");
                            String model = sc.nextLine();

                            System.out.print("Enter IMIE number : ");
                            long imie = sc.nextLong();

                            System.out.print("Enter Memory(GB) : ");
                            int memory = sc.nextInt();

                            System.out.print("Enter Storage(GB) : ");
                            int storage = sc.nextInt();

                            sc.nextLine();
                            System.out.print("Enter Generation : ");
                            String generation = sc.nextLine();

                            sc.nextLine();
                            System.out.print("Enter Processor Name : ");
                            String processor = sc.nextLine();

                            System.out.print("Enter the Price : ");
                            double price = sc.nextDouble();

                            theLaptopDAO.save(new Laptop(brand, model, imie, memory,
                            storage, generation, processor, price));
                            System.out.println("Laptop Saved Successfully!");

                            System.out.print("\nDo you want to add more Laptops(y/n)? : ");
                            char ch = sc.next().toLowerCase().charAt(0);

                            if (ch == 'n'){
                                break;
                            }
                            System.out.println();
                        }
                        break;
                    }
                    case 2:
                    {
                        System.out.print("Enter the Laptop ID to Fetch by ID : ");
                        Laptop byID =  theLaptopDAO.findByID(sc.nextByte());

                        if (byID != null){
                            System.out.println(byID);
                            System.out.println("Laptop Found!");
                        }
                        else {
                            System.out.println("No Records Found!");
                        }

                        break;
                    }
                    case 3:
                    {
                        System.out.print("Enter the Laptop IMIE to Fetch by IMIE : ");
                        Laptop byIMIE =  theLaptopDAO.findByIMIE(sc.nextLong());

                        if (byIMIE != null){
                            System.out.println(byIMIE);
                            System.out.println("Laptop Found!");
                        }
                        else {
                            System.out.println("No Records Found!");
                        }

                        break;
                    }
                    case 4:
                    {
                        System.out.print("Enter the Laptop ID : ");
                        theLaptopDAO.update(sc.nextInt());
                        break;
                    }
                    case 5:
                    {
                        System.out.print("Enter the Employee ID : ");
                        theLaptopDAO.remove(sc.nextInt());
                        break;
                    }
                    case 6:
                    {
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
		SpringApplication.run(LaptopApplication.class, args);
	}

}
