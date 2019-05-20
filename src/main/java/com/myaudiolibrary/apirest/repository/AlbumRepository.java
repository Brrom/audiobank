package com.myaudiolibrary.apirest.repository;

import com.myaudiolibrary.apirest.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Album findByTitle(String title);
}
