/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
import entities.Movie;
/**
 *
 * @author Emil PC
 */
public class MovieDTO {
    
    private String name;

    public MovieDTO(Movie movie) {
        this.name = movie.getName();
    }

    public String getName() {
        return name;
    }
    
    
}
