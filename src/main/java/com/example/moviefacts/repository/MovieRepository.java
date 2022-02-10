package com.example.moviefacts.repository;

import com.example.moviefacts.model.Movie;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieRepository {
    ArrayList<Movie> movies = new ArrayList();
    //læse movies

    public String findAll() {
        try {
            //findAll
            File file = new ClassPathResource("imdb-data.csv").getFile();
            Scanner reader = new Scanner(file);
            boolean headline = true;
            while (reader.hasNextLine()) {
                if (headline) {
                    String headlinee = reader.nextLine();
                    headline = false;
                } else {
                    String line = reader.nextLine();
                    String[] wordsOnLine = line.split(";");
                    boolean awards = false;
                    if (wordsOnLine[5].equalsIgnoreCase("yes")) {
                        awards = true;
                    }
                    movies.add(new Movie(Integer.parseInt(wordsOnLine[0]), Integer.parseInt(wordsOnLine[1]), wordsOnLine[2], wordsOnLine[3], Integer.parseInt(wordsOnLine[4]), awards));
                }
                //Her skal den enkelte linie behandles og movies oprettes
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
        String movieList = "";
        for (int i = 0; i < movies.size(); i++) {
            movieList += movies.get(i);
        }
        return movieList;
    }

}
