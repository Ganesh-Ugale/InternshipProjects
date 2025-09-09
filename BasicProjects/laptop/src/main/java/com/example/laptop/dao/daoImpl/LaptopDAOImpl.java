package com.example.laptop.dao.daoImpl;

import com.example.laptop.dao.LaptopDAO;
import com.example.laptop.entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.Scanner;

@Repository
public class LaptopDAOImpl implements LaptopDAO {

    private final EntityManager theManager;
    private int size = 0;
    @Autowired
    public LaptopDAOImpl(EntityManager theManager){
        this.theManager = theManager;
    }

    @Override
    @Transactional
    public void save(Laptop theLaptop) {
        size++;
        theManager.persist(theLaptop);
    }

    @Override
    public Laptop findByID(int id) {
        return theManager.find(Laptop.class,id);
    }

    @Override
    public Laptop findByIMIE(long imie) {
        try{
            Query query = theManager.createQuery("select l from Laptop l where l.imie =: imie");
            query.setParameter("imie", imie);
            return (Laptop) query.getSingleResult();
        }
        catch (Exception o){
            return null;
        }
    }

    @Override
    @Transactional
    public void update(int id) {
        if (size == 0){
            System.out.println("\n Database is Empty!\n");
            return;
        }

        Scanner sc = new Scanner(System.in);

        Laptop isFound = theManager.find(Laptop.class,id);

        System.out.println("1. Update Brand Name");
        System.out.println("2. Update Model Name");
        System.out.println("3. Update IMIE");
        System.out.println("4. Update Memory");
        System.out.println("5. Update Storage");
        System.out.println("6. Update Generation");
        System.out.println("7. Update Processor");
        System.out.println("8. Update Price");
        System.out.println();

        System.out.print("Select Option : ");
        int op = sc.nextByte();

        switch (op){
            case 1:
            {
                if (isFound != null){
                    System.out.print("Enter the brand name : ");
                    isFound.setBrand(sc.next());
                    System.out.println("Brand Name Updated Successfully!");
                }
                else{
                    System.out.println("Laptop Not Found!");
                }
                break;
            }

            case 2:
            {
                if (isFound != null){
                    System.out.print("Enter the model name : ");
                    isFound.setModel(sc.nextLine());
                    System.out.println("Model Name Updated Successfully!");
                }
                else{
                    System.out.println("Laptop Not Found!");
                }
                break;
            }

            case 3:
            {
                if (isFound != null){
                    System.out.print("Enter the IMEI number : ");
                    isFound.setImie(sc.nextLong());
                    System.out.println("IMEI Updated Successfully!");
                }
                else{
                    System.out.println("Laptop Not Found!");
                }
                break;
            }

            case 4:
            {
                if (isFound != null){
                    System.out.print("Enter the Memory : ");
                    isFound.setMemory(sc.nextInt());
                    System.out.println("Memory Updated Successfully!");
                }
                else{
                    System.out.println("Laptop Not Found!");
                }
                break;
            }

            case 5:
            {
                if (isFound != null){
                    System.out.print("Enter the Storage : ");
                    isFound.setStorage(sc.nextInt());
                    System.out.println("Storage Updated Successfully!");
                }
                else{
                    System.out.println("Laptop Not Found!");
                }
                break;
            }
            case 6:
            {
                if (isFound != null){
                    System.out.print("Enter the Generation : ");
                    isFound.setGeneration(sc.next());
                    System.out.println("Generation Updated Successfully!");
                }
                else{
                    System.out.println("Laptop Not Found!");
                }
                break;
            }
            case 7:
            {
                if (isFound != null){
                    System.out.print("Enter the Processor Name : ");
                    isFound.setProcessor(sc.nextLine());
                    System.out.println("Processor Name Updated Successfully!");
                }
                else{
                    System.out.println("Laptop Not Found!");
                }
                break;
            }
            case 8:
            {
                if (isFound != null){
                    System.out.print("Enter the Price : ");
                    isFound.setPrice(sc.nextDouble());
                    System.out.println("Price Updated Successfully!");
                }
                else{
                    System.out.println("Laptop Not Found!");
                }
                break;
            }
            case 9:
            {
                return;
            }
            default:{
                System.out.println("Please Select Right Options!");
            }
            System.out.println("Laptop Details Updated Successfully!\n");
        }
    }

    @Override
    @Transactional
    public void remove(int id) {
        if (size == 0){
            System.out.println("\nDatabase is Empty!\n");
            return;
        }
        Laptop found = theManager.find(Laptop.class,id);

        if (found  != null){
            theManager.remove(found);
        }
        else{
            System.out.println("Laptop Not Found!");
        }
        System.out.println("Laptop removed Successfully!\n");
    }
}
