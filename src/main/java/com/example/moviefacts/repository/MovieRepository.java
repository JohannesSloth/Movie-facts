package com.example.moviefacts.repository;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MovieRepository {
    //læse movies

    public String findAll() {
        try {
            //findAll
            File file = new ClassPathResource("imdb-data.csv").getFile();
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                //Her skal den enkelte linie behandles og movies oprettes
                System.out.println(reader.next());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
        return "Her skal filmene komme";
    }

}
