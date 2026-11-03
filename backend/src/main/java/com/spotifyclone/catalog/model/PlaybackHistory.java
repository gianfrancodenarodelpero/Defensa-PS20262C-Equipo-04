package com.spotifyclone.catalog.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity public class PlaybackHistory {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private AppUser user;
 @ManyToOne(optional=false) private Song song;
 @Column(nullable=false) private LocalDateTime playedAt;
 protected PlaybackHistory(){} public PlaybackHistory(AppUser user,Song song,LocalDateTime playedAt){this.user=user;this.song=song;this.playedAt=playedAt;}
 public Long getId(){return id;} public AppUser getUser(){return user;} public Song getSong(){return song;} public LocalDateTime getPlayedAt(){return playedAt;}
}
