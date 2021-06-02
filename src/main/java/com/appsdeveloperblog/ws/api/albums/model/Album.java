package com.appsdeveloperblog.ws.api.albums.model;

import lombok.Data;

@Data
public class Album {
    private String userId;
    private String albumId;
    private String albumTitle;
    private String albumDescription;
    private String albumUrl;
}
