package com.example.Movies.dao.daoImpl;

import com.example.Movies.dao.MoviesDAO;
import com.example.Movies.entity.Movies;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Scanner;

@Repository
public class MoviesDAOImpl implements MoviesDAO {

//    @Autowired
    private final EntityManager theManager;
    private int size;

    @Autowired
    public MoviesDAOImpl(EntityManager theManager){
        this.theManager = theManager;
        size = size();
    }

    @Override
    @Transactional
    public void saveMovies(Movies theMovie) {
        size++;
        theManager.persist(theMovie);
    }

    @Override
    public Movies fetch() {

        if (size == 0){
            System.out.println("\nDatabase is Empty!\n");
            return null;
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Movie ID : ");
        int byID = sc.nextInt();

        return theManager.find(Movies.class, byID);
    }

    @Override
    @Transactional
    public void update(int byID) {

        if (size == 0){
            System.out.println("\nDatabase is Empty!\n");
            return;
        }

        Scanner sc = new Scanner(System.in);

        Movies isFound = theManager.find(Movies.class,byID);

        for (int i = 0; true; i++){
            System.out.println("\n1. Update Movie Name");
            System.out.println("2. Update Movie Rating");
            System.out.println("3. Update Movie Duration");
            System.out.println("4. Update Movie Language");
            System.out.println("5. Exit");
            System.out.println();

            System.out.print("Select Option : ");
            int op = sc.nextByte();

            switch (op){
                case 1:
                {
                    if (isFound != null){
                        sc.nextLine();
                        System.out.print("Enter the Movie Name : ");
                        isFound.setMovieName(sc.nextLine());
                        System.out.println("Movie Name Updated Successfully!");
                    }
                    else{
                        System.out.println("Movie Not Found!");
                    }
                    break;
                }

                case 2:
                {
                    if (isFound != null){
                        System.out.print("Enter the Movie Rating : ");
                        isFound.setMovieRating(sc.nextFloat());
                        System.out.println("Movie Rating Updated Successfully!");
                    }
                    else{
                        System.out.println("Movie Not Found!");
                    }
                    break;
                }

                case 3:
                {
                    if (isFound != null){
                        System.out.print("Enter the Movie Duration : ");
                        isFound.setDuration(sc.nextLine());
                        System.out.println("Movie Duration Updated Successfully!");
                    }
                    else{
                        System.out.println("Movie Not Found!");
                    }
                    break;
                }

                case 4:
                {
                    if (isFound != null){
                        System.out.print("Enter the Movie Language : ");
                        isFound.setMovieLang(sc.next());
                        System.out.println("Movie Language Updated Successfully!");
                    }
                    else{
                        System.out.println("Movie Not Found!");
                    }
                    break;
                }

                case 5:
                {
                    System.out.println("\nThank You, Please Visit Again!\n");
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
    public void remove(int byID) {
        if (size == 0){
            System.out.println("\nDatabase is Empty!");
            return;
        }

        Movies found = theManager.find(Movies.class, byID);

        if (found  != null){
            theManager.remove(found);
            size--;
            System.out.println("\nMovie removed Successfully!");
        }
        else{
            System.out.println("\nMovie Not Found!");
        }

    }

//    To Fetch all Record from DB
    private List<Movies> fetchAll(){
        Query query = theManager.createQuery("select m from Movies m");
        return query.getResultList();
    }

    //    To Fetch the size of DB
    private int size(){
        List<Movies> temp = fetchAll();
        return temp.size();
    }
}
