package com.appsdeveloperblog.ws.api.albums.controllers;

import com.appsdeveloperblog.ws.api.albums.model.Album;
import com.appsdeveloperblog.ws.api.albums.services.AlbumsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private final AlbumsService albumsService;

    public AlbumsController(AlbumsService albumsService) {
        this.albumsService = albumsService;
    }

    @GetMapping(produces = {"application/json"})
    public List<Album> getAlbums() {
        return albumsService.getAlbums();
    }
}
