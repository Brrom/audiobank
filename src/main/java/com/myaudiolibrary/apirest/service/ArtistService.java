package com.myaudiolibrary.apirest.service;

import com.myaudiolibrary.apirest.exception.DoublonException;
import com.myaudiolibrary.apirest.model.Artist;
import com.myaudiolibrary.apirest.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    //TODO Question 1 Display Artist

    public Artist findById(Long id) throws EntityNotFoundException {
        Artist artist = artistRepository.findOne(id);
        if (artist == null) {
            throw new EntityNotFoundException("L'artiste d'identifiant : " + id + " n'a pas été trouvé");
        }
        return artist;
    }

    //TODO Question 2 Find By Name

    public List<Artist> findByName(String name) throws Exception{

        return artistRepository.findByNameContaining(name);
    }

    //TODO Question 3 Display List

    public Long countArtist() {
        return artistRepository.count();
    }

    public Page<Artist> ListName(Integer page, Integer size, String sortDirection, String sortProperty) throws IllegalArgumentException {

        if (page == null) {
            page = 0;
        } else if (page < 0) {
            throw new IllegalArgumentException("La page : " + page + " n'est pas valide. Le numéro de page ne peut pas être inferieur à 0.");
        } else if (page > countArtist() / size) {
            throw new IllegalArgumentException("La page ne doit pas être superieur à : " + ((countArtist() / size) + 1));
        }
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.fromString(sortDirection), sortProperty);
        return artistRepository.findAll(pageRequest);
    }

    //TODO Question 4 Create Artist

    public Artist addArtist(Artist artist) throws DoublonException {
        if (artistRepository.findByName(artist.getName()) != null) {
            throw new DoublonException("Le nom de l'artiste : " + artist.getName() + " existe déjà");
        }
        return artistRepository.save(artist);
    }

    //TODO Question 5 Modify Artist

    public Artist modifArtist(Long id, Artist artist) {
        return artistRepository.save(artist);
    }

    //TODO Question 6 Delete Artist

    public void deleteArtist(Long id) {
        artistRepository.delete(id);
    }

}

