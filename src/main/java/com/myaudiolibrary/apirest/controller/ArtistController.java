package com.myaudiolibrary.apirest.controller;

import com.myaudiolibrary.apirest.exception.DoublonException;
import com.myaudiolibrary.apirest.model.Artist;
import com.myaudiolibrary.apirest.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/artists")

public class ArtistController {

    @Autowired
    private ArtistService artistService;

    //TODO Question 1 Display Artist

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Artist findArtist(@PathVariable(value = "id") Long id) throws EntityNotFoundException {

        return artistService.findById(id);
    }

    //TODO Question 2 Find By Name

    @RequestMapping(params = "name")
    public List<Artist> findByName(@RequestParam("name") String name) throws EntityNotFoundException {

        return artistService.findByName(name);
    }

    //TODO Question 3 Display List

    @RequestMapping()
    public Page<Artist> ListName(@RequestParam(value = "page") Integer page,
                                 @RequestParam(value = "size") Integer size,
                                 @RequestParam(value = "sortDirection") String sortDirection,
                                 @RequestParam(value = "sortProperty") String sortProperty) throws IllegalArgumentException {

        return artistService.ListName(page, size, sortDirection, sortProperty);
    }

    //TODO Question 4 Create Artist

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Artist addArtist(@RequestBody Artist artist) throws DoublonException {

        return artistService.addArtist(artist);
    }

    //TODO Question 5 Modify Artist

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public Artist modifArtist(@PathVariable(value = "id") Long id, @RequestBody Artist artist) {

        return artistService.modifArtist(id, artist);
    }

    //TODO Question 6 Delete Artist

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)

    public void deleteArtist(@PathVariable(value = "id") Long id) {

        artistService.deleteArtist(id);
    }


}

