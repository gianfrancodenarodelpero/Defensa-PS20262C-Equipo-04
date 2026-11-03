package com.spotifyclone.catalog.model;
import jakarta.persistence.*;
@Entity public class Artist {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String name; @Column(length=1000) private String description; private String imageUrl;
 protected Artist() {} public Artist(String name,String description,String imageUrl){this.name=name;this.description=description;this.imageUrl=imageUrl;}
 public Long getId(){return id;} public String getName(){return name;} public String getDescription(){return description;} public String getImageUrl(){return imageUrl;}
}
