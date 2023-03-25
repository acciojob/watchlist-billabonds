package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDb = new HashMap<>();
    HashMap<String,Director> directorDb = new HashMap<>();
    HashMap<String,String> movieDirectorPair = new HashMap<>();

    public String addMovie(Movie movie){

        String key = movie.getName();
        movieDb.put(key,movie);
        return "Movie added Successfully";
    }
    public String addDirector(Director director){

        String key = director.getName();
        directorDb.put(key,director);
        return "Director added Successfully";
    }

    public String addMovieDirectorPair(String movieName,String directorName){

        movieDirectorPair.put(movieName,directorName);

        return "Movie with Director added Successfully";
    }

    public Movie getMovieByName(String MovieName){

        return movieDb.get(MovieName);
    }

    public Director getDirectorByName(String directorName){

        return directorDb.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName){

        List<String> list = (List<String>) directorDb.get(directorName);
        return list;
    }

    public List<String> findAllMovies(){

        List<String> list = (List<String>) movieDb.keySet();
        return list;
    }

    public String deleteDirectorByName(String directorName){

        //   1. directorDb
        //   2. also need to remove the entries in movie_director hashmap
        //   3. Corresponding movies also

        directorDb.remove(directorName);

        for(Map.Entry<String,String> Entry : movieDirectorPair.entrySet()){

            if(Entry.getValue().equals(directorName)){
                String movieName = Entry.getKey();
                movieDb.remove(movieName);
                movieDirectorPair.remove(movieName);
            }
        }
        return "Director removed Successfully";
    }

    public String removeAllDirector(){

        for(String directorName : directorDb.keySet()){

            directorDb.remove(directorName);

            for(Map.Entry<String,String> Entry : movieDirectorPair.entrySet()){

                if(Entry.getValue().equals(directorName)){
                    String movieName = Entry.getKey();
                    movieDb.remove(movieName);
                    movieDirectorPair.remove(movieName);
                }
            }
        }
        return "Director removed Successfully";
    }
}
