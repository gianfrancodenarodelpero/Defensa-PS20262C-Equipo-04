package com.spotifyclone.catalog.model;
import jakarta.persistence.*;
@Entity @Table(name="app_users") public class AppUser {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String email;
 @Column(nullable=false) private String password;
 @Column(nullable=false) private boolean active=true;
 protected AppUser(){}
 public AppUser(String email,String password){this.email=email;this.password=password;this.active=true;}
 public Long getId(){return id;} public String getEmail(){return email;} public boolean isActive(){return active;} public boolean matchesPassword(String candidate){return password.equals(candidate);}
}
