package com.myaudiolibrary.apirest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AlbumId")
    private Long id;

    @Column(name = "Title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "ArtistId")
    @JsonBackReference

    private Artist artist;

    public Album() {

    }

    public Album(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
    }


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public Artist getArtist() {

        return artist;
    }

    public void setArtist(Artist artist) {

        this.artist = artist;
    }
}
