package com.example.Movies;

import com.example.Movies.dao.MoviesDAO;
import com.example.Movies.entity.Movies;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import com.example.Movies.entity.Movies;
import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class MoviesApplication {

    @Bean
    public CommandLineRunner commandLineRunner(MoviesDAO theMovie){
        return runner ->{

            Scanner sc = new Scanner(System.in);

            System.out.println("\n------|| Welcome to Movies Database Application ||-----");

            for (int j = 0; true; j++){
                System.out.println("\n1. Add Movie");
                System.out.println("2. Display Movie");
                System.out.println("3. Update Movie Details");
                System.out.println("4. Remove Movie");
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
                            System.out.println("\n-----|| Welcome to add Movie page ||------\n");
                            sc.nextLine();

                            String movieName = null, duration = null, movieLang = null;
                            float movieRating = 0;

                            for (int m = 0; true; m++){
                                try{
                                    System.out.print("Enter the Movie Name : ");
                                    movieName = sc.nextLine();
                                    System.out.print("Enter the Movie Duration : ");
                                    duration = sc.nextLine();
                                    System.out.print("Enter the Movie Language : ");
                                    movieLang = sc.nextLine();
                                    System.out.print("Enter the Movie Rating : ");
                                    movieRating = sc.nextFloat();
                                    break;
                                }
                                catch (InputMismatchException e){
                                    System.out.println("\nPlease give Right Input\n");
                                    sc.nextLine();
                                }
                            }

                            theMovie.saveMovies(new Movies(movieName,movieRating,duration,movieLang));
                            System.out.println("\nMovie Saved Successfully!");

//                          Attempts Lefts
                            char ch = '\u0000';
                            byte att = 3;

                            for (int k = 0; k < 3; k++){
                                System.out.print("\n Do you want to add More Movies?(y/n) : ");
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
                        Movies byID = theMovie.fetch();

                        if (byID != null){
                            System.out.println("\n"+byID);
                            System.out.println("Movie Found!\n");
                        }
                        else {
                            System.out.println("\nNo Records Found!\n");
                        }
                        break;
                    }
                    case 3:
                    {
                        for (int y = 0; true; y++){
                            try{
                                System.out.print("Enter the Movie ID : ");
                                theMovie.update(sc.nextInt());
                                break;
                            }
                            catch (InputMismatchException e){
                                System.out.println("\nPlease Enter Movie ID Only!\n");
                                sc.nextLine();
                            }
                        }
                        break;
                    }
                    case 4:
                    {
                        for (int w = 0; true; w++){
                            try{
                                System.out.print("Enter the Movie ID : ");
                                theMovie.remove(sc.nextInt());
                                break;
                            }
                            catch (InputMismatchException e){
                                System.out.println("\nPlease Enter Movie ID Only!\n");
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
		SpringApplication.run(MoviesApplication.class, args);
	}

}
