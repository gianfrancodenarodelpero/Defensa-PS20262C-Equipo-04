package com.spotifyclone.catalog.model;
import jakarta.persistence.*;
@Entity public class Song {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String title; private int duration; private String audioUrl;
 @ManyToOne(optional=false) private Album album; @ManyToOne(optional=false) private Artist artist;
 protected Song() {} public Song(String title,int duration,Album album,Artist artist,String audioUrl){this.title=title;this.duration=duration;this.album=album;this.artist=artist;this.audioUrl=audioUrl;}
 public Long getId(){return id;} public String getTitle(){return title;} public int getDuration(){return duration;} public String getAudioUrl(){return audioUrl;} public Album getAlbum(){return album;} public Artist getArtist(){return artist;}
}
