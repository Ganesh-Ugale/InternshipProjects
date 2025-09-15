package com.example.Mobile.dao.daoImpl;

import com.example.Mobile.dao.MobileDAO;
import com.example.Mobile.entity.Mobile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;

@Repository
public class MobileDAOImpl implements MobileDAO {

    private final EntityManager theManager;

    @Autowired
    public MobileDAOImpl(EntityManager theManager){
        this.theManager = theManager;
    }

    @Override
    @Transactional
    public void save(Mobile theMobile) {
        theManager.persist(theMobile);
    }

    @Override
    @Transactional
    public void update(int byID) {

        Mobile found = theManager.find(Mobile.class,byID);

        Scanner sc = new Scanner(System.in);

        System.out.println("\n1. Update Brand");
        System.out.println("2. Update Model");
        System.out.println("3. Update IMEI");
        System.out.println("4. Update Price");
        System.out.println("5. Update Processor");
        System.out.println("6. Update Type");
        System.out.println("7. Update RAM");
        System.out.println("8. Update Storage");

        System.out.print("Select Option : ");
        int op = sc.nextByte();
        sc.nextLine();
        switch (op){
            case 1:
            {
                if (found != null){
                    System.out.print("Enter the Brand :");
                    found.setBrand(sc.nextLine());
                    System.out.println("Brand Updated Successfully!");
                }
                else{
                    System.out.println("Mobile Not Found!");
                }
                break;
            }
            case 2:
            {
                if (found != null){
                    System.out.print("Enter the Model :");
                    found.setModel(sc.nextLine());
                    System.out.println("Model Updated Successfully!");
                }
                else{
                    System.out.println("Mobile Not Found!");
                }
                break;
            }
            case 3:
            {
                if (found != null){
                    System.out.print("Enter the IMEI :");
                    found.setImei(sc.nextLong());
                    System.out.println("IMEI Updated Successfully!");
                }
                else{
                    System.out.println("Mobile Not Found!");
                }
                break;
            }
            case 4:
            {
                if (found != null){
                    System.out.print("Enter the Price :");
                    found.setPrice(sc.nextDouble());
                    System.out.println("Price Updated Successfully!");
                }
                else{
                    System.out.println("Mobile Not Found!");
                }
                break;
            }
            case 5:
            {
                if (found != null){
                    System.out.print("Enter the Processor :");
                    found.setProcessor(sc.nextLine());
                    System.out.println("Processor Updated Successfully!");
                }
                else{
                    System.out.println("Mobile Not Found!");
                }
                break;
            }
            case 6:
            {
                if (found != null){
                    System.out.print("Enter the Type :");
                    found.setType(sc.nextLine());
                    System.out.println("Type Updated Successfully!");
                }
                else{
                    System.out.println("Mobile Not Found!");
                }
                break;
            }
            case 7:
            {
                if (found != null){
                    System.out.print("Enter the RAM(GB) :");
                    found.setRam(sc.nextInt());
                    System.out.println("RAM Updated Successfully!");
                }
                else{
                    System.out.println("Mobile Not Found!");
                }
                break;
            }
            case 8:
            {
                if (found != null){
                    System.out.print("Enter the Storage(GB) :");
                    found.setStorage(sc.nextInt());
                    System.out.println("Storage Updated Successfully!");
                }
                else{
                    System.out.println("Mobile Not Found!");
                }
                break;
            }
            default:
            {
                System.out.println("Please Select Right Options");
            }
        }
    }

    @Override
    public List<Mobile> fetchAll() {
        Query query = theManager.createQuery("select m from Mobile m");
        return query.getResultList();
    }

    @Override
    public Mobile fetchByID(int byID) {
        return theManager.find(Mobile.class, byID);
    }

    @Override
    @Transactional
    public void remove(int byID) {

        Mobile found = theManager.find(Mobile.class,byID);

        if (found != null){
            theManager.remove(found);
            System.out.println("Mobile Removed Successfully");
        }
        else {
            System.out.println("Mobile Not Found!");
        }

    }
}
