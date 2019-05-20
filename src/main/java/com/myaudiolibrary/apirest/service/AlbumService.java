package com.myaudiolibrary.apirest.service;

import com.myaudiolibrary.apirest.exception.DoublonException;
import com.myaudiolibrary.apirest.model.Album;
import com.myaudiolibrary.apirest.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    //TODO Question 7 Add Album

    public Album addAlbum(Album album) throws DoublonException {
        if (albumRepository.findByTitle(album.getTitle()) != null) {
            throw new DoublonException("Le nom de l'artiste : " + album.getTitle() + " existe déjà");
        }
        return albumRepository.save(album);
    }

    //TODO Question 8 Delete album

    public void deleteAlbum(Long id) {
        albumRepository.delete(id);
    }
}
