package com.example.Mobile;

import com.example.Mobile.dao.MobileDAO;
import com.example.Mobile.entity.Mobile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MobileApplication {

    @Bean
    public CommandLineRunner commandLineRunner(MobileDAO theMobileDAO){
        return runner ->{
            Scanner sc = new Scanner(System.in);

            System.out.println("1. Add Mobile");
            System.out.println("2. Fetch by ID");
            System.out.println("3. Fetch ALL");
            System.out.println("4. Update Mobile");
            System.out.println("5. Remove Mobile");

            System.out.print("Select Option : ");
            int op = sc.nextByte();

            switch (op){
                case 1:
                {
                    sc.nextLine();
                    System.out.print("Enter Brand : ");
                    String brand = sc.nextLine();

                    System.out.print("Enter Model : ");
                    String model = sc.nextLine();

                    System.out.print("Enter IMEI : ");
                    Long imei = sc.nextLong();

                    System.out.print("Enter Price : ");
                    double price = sc.nextDouble();

                    sc.nextLine();
                    System.out.print("Enter Processor : ");
                    String processor = sc.nextLine();

                    System.out.print("Enter Type : ");
                    String type = sc.nextLine();

                    System.out.print("Enter RAM(GB) : ");
                    int ram = sc.nextInt();

                    System.out.print("Enter Storage(GB) : ");
                    int storage = sc.nextInt();

                    theMobileDAO.save(new Mobile(brand, model, imei, price,
                    processor, type, ram, storage));

                    System.out.println("Mobile Saved Successfully");
                    break;
                }
                case 2:
                {
                    System.out.print("Enter the Mobile ID : ");
                    int id = sc.nextInt();
                    Mobile found = theMobileDAO.fetchByID(id);

                    if (found != null){
                        System.out.println(found);
                    }
                    else {
                        System.out.println("No Mobile Found!");
                    }
                    break;
                }
                case 3:
                {
                    List<Mobile> found = theMobileDAO.fetchAll();

                    if (found != null){
                        System.out.println(found);
                    }
                    else {
                        System.out.println("No Mobile Found!");
                    }
                    break;
                }
                case 4:
                {
                    System.out.print("Enter Mobile ID : ");
                    int id = sc.nextInt();
                    theMobileDAO.update(id);
                    break;
                }
                case 5:
                {
                    System.out.print("Enter Mobile ID : ");
                    int id = sc.nextInt();

                    theMobileDAO.remove(id);
                    break;
                }
                case 6:
                {
                    System.out.println("Thank You!");
                    return;
                }
                default:{
                    System.out.println("Select Right Options");
                }
            }

        };
    }

	public static void main(String[] args) {
		SpringApplication.run(MobileApplication.class, args);
	}

}
