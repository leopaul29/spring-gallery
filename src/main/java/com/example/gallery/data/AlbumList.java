package com.example.gallery.data;

import java.util.List;

public class AlbumList {
    public Album[] albums;

    public AlbumList() {
    }

    public Album[] getAlbums() {
        return albums;
    }

    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "AlbumList{" +
                "albums=" + albums +
                '}';
    }
}
