package com.appsdeveloperblog.ws.api.albums.controllers;

import com.appsdeveloperblog.ws.api.albums.model.Album;
import com.appsdeveloperblog.ws.api.albums.services.AlbumsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class AlbumsControllerTest {

    @Mock
    AlbumsService albumsService;

    @InjectMocks
    AlbumsController albumsController;

    MockMvc mockMvc;

    Album validAlbum1;

    Album validAlbum2;

    List<Album> validAlbumList;

    @BeforeEach
    void setUp() {
        validAlbum1 = new Album();
        validAlbum1.setAlbumId("albumIdHere");
        validAlbum1.setUserId("1");
        validAlbum1.setAlbumTitle("Album 1 title");
        validAlbum1.setAlbumDescription("Album 1 description");
        validAlbum1.setAlbumUrl("Album 1 URL");

        validAlbum2 = new Album();
        validAlbum2.setAlbumId("albumIdHere");
        validAlbum2.setUserId("2");
        validAlbum2.setAlbumTitle("Album 2 title");
        validAlbum2.setAlbumDescription("Album 2 description");
        validAlbum2.setAlbumUrl("Album 2 URL");

        validAlbumList = List.of(validAlbum1, validAlbum2);
        mockMvc = MockMvcBuilders.standaloneSetup(albumsController).build();
    }

    @Test
    void testGetAlbums() throws Exception {
        given(albumsService.getAlbums()).willReturn(validAlbumList);

        mockMvc.perform(get("/albums"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
