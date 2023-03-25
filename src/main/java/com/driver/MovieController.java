package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired                    // Connecting MovieService class
    MovieService movieService;

    @PostMapping("/add-movie")                                                                // 1st API
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){

        String ans = movieService.addMovie(movie);

        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")                                                             // 2nd API
    public ResponseEntity<String> addDirector(@RequestBody Director director){

        String ans = movieService.addDirector(director);

        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }


    @PutMapping("/add-movie-director-pair")                                                  // 3rd API
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName,
                                                       @RequestParam String directorName){


        String ans = movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")                                                    // 4th API - Done
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName){

        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")                                                // 5th API - Done
    public ResponseEntity<Director> getDirectorByName(@PathVariable String directorName){

        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name")                                               // 6th API - Done
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String directorName){

        List<String> list = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")                                                           // 7th API - Done
    public ResponseEntity<List<String>> findAllMovies(){

        List<String> list = movieService.findAllMovies();
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")                                                  // 8th API - Done
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName){

        String ans = movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")                                                     // 9th API - Done
    public ResponseEntity<String> deleteAllDirector(){

        String ans = movieService.deleteAllDirector();
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }

}
