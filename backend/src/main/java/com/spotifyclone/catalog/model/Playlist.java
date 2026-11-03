package com.spotifyclone.catalog.model;
import jakarta.persistence.*; import java.util.*;
@Entity public class Playlist {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String name;
 @ManyToOne(optional=false) private AppUser owner;
 @ManyToMany @JoinTable(name="playlist_songs",joinColumns=@JoinColumn(name="playlist_id"),inverseJoinColumns=@JoinColumn(name="song_id")) private List<Song> songs=new ArrayList<>();
 protected Playlist(){} public Playlist(String name,AppUser owner){this.name=name;this.owner=owner;}
 public Long getId(){return id;} public String getName(){return name;} public AppUser getOwner(){return owner;} public List<Song> getSongs(){return songs;}
 public void rename(String name){this.name=name;} public void addSong(Song song){if(songs.stream().noneMatch(s->s.getId().equals(song.getId())))songs.add(song);} public void removeSong(Long songId){songs.removeIf(s->s.getId().equals(songId));}
}
