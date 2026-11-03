package com.spotifyclone.catalog.model;
import jakarta.persistence.*;
@Entity public class Album {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String title; private String releaseYear; private String coverUrl;
 @ManyToOne(optional=false) private Artist artist;
 protected Album() {} public Album(String title,String releaseYear,String coverUrl,Artist artist){this.title=title;this.releaseYear=releaseYear;this.coverUrl=coverUrl;this.artist=artist;}
 public Long getId(){return id;} public String getTitle(){return title;} public String getReleaseYear(){return releaseYear;} public String getCoverUrl(){return coverUrl;} public Artist getArtist(){return artist;}
}
