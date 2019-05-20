package com.myaudiolibrary.apirest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "artist")

public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ArtistId")
    private Long id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "artist")
    @JsonManagedReference

    private List<Album> albums;

    public Artist() {

    }

    public Artist(String name, List<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<Album> getAlbums() {

        return albums;
    }

    public void setAlbums(List<Album> albums) {

        this.albums = albums;
    }
}
