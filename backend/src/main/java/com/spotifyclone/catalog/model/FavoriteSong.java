package com.spotifyclone.catalog.model;
import jakarta.persistence.*;
@Entity @Table(name="favorite_songs",uniqueConstraints=@UniqueConstraint(columnNames={"user_id","song_id"})) public class FavoriteSong {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private AppUser user;
 @ManyToOne(optional=false) private Song song;
 protected FavoriteSong(){} public FavoriteSong(AppUser user,Song song){this.user=user;this.song=song;}
 public Long getId(){return id;} public AppUser getUser(){return user;} public Song getSong(){return song;}
}
