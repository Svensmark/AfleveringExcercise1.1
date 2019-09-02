/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.MovieDTO;
import java.util.ArrayList;
import entities.Movie;

/**
 *
 * @author Emil PC
 */
public interface MovieFacadeInterface {
    
    public ArrayList<MovieDTO> getMovie(String name);
    public ArrayList<MovieDTO> getAllMovies(String name);
    
    public void createMovie(Movie movie);
    public void deleteMovie(Long id);
    
}
