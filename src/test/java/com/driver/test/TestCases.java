package com.driver.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.driver.Director;
import com.driver.Movie;
import com.driver.MovieController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.driver.Application;

@SpringBootTest(classes = Application.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCases {

    public void testAddMovie(){

        Movie movie = new Movie("RRR",120,8.7);
        ResponseEntity<String> ans = movieController.addMovie(movie);
        ResponseEntity<Movie> movieResponse = movie.Controller.getMovieName("RRR");

        if(objects.nonNull(testResponse)){
            assertEquals(9.0,movieResponse.getBody().getImdbRating());
        }
        else {
            assertEquals(9.0,null);
        }
    }

    public void testAddDirector(){
        Director director = new Director("Arjun",6,8.0);
        ResponseEntity<String> ans = movieController.addDirector(director);
        ResponseEntity<Director> movieResponse = movie.Controller.getDirectorByName("Arjun");

        if(objects.nonNull(testResponse)){
            assertEquals(8.0,directorResponse.getBody().getImdbRating());
        }
        else {
            assertEquals(8.0,null);
        }
    }
    
}
