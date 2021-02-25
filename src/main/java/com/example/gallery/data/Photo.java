package com.example.gallery.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {

    public Long albumId;
    public Long id;
    public String title;
    public String url;
    public String thumbnailUrl;

    public Photo() {}

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "albumId=" + albumId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }
}
