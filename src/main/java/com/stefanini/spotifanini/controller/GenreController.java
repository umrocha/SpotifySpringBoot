package com.stefanini.spotifanini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.spotifanini.exception.GenreNotFoundException;
import com.stefanini.spotifanini.model.Genre;
import com.stefanini.spotifanini.service.GenreService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    // <---------- GET All Genres ---------->
    @ApiOperation(value = "Genre List", notes = "This Endpoint Provides The List of All Genres")
    @ApiResponses({
            @ApiResponse(code = 204, message = "List Returned")
    })
    @GetMapping
    public List<Genre> findAllGenres() {
        return genreService.findAllGenres();
    }
    /*GET localhost:8082/artist/{id}
    
    */

    // <---------- GET Genre ---------->
    @ApiOperation(value = "Genre", notes = "This Endpoint Provides The Genre by The ID")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Genre Returned")
    })
    @GetMapping("/{id}")
    public Genre findById(@PathVariable Long id) throws GenreNotFoundException {
        return genreService.findById(id);
    }
    /*GET localhost:8082/genre/{id}
    
    */

    // <---------- POST METHOD ---------->
    @ApiOperation(value = "Genre", notes = "This Endpoint Saves a New Genre")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Genre Saved")
    })
    @PostMapping
    public Genre save(@RequestBody Genre genre) {
        return genreService.save(genre);
    }/*POST localhost:8082/genre
    {
    "name": "new",
    }
    */

    // <---------- PUT METHOD ---------->
    @ApiOperation(value = "Genre", notes = "This Endpoint Updates a Genre")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Genre Updated")
    })
    @PutMapping("/{id}")
    public Genre update(@PathVariable Long id, @RequestBody Genre genre) throws GenreNotFoundException {
        return genreService.update(id, genre);
    }
    /*PUT localhost:8082/genre/{id}
    {
    
    "name": "new",
    }
    */

    // <---------- DELETE METHOD ---------->
    @ApiOperation(value = "Genre", notes = "This Endpoint Deletes a Genre")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Genre Deleted")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws GenreNotFoundException {
        genreService.delete(id);
    }
    /*DEL localhost:8082/artist/{id}
    
    */
    
}
