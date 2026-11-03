package com.spotifyclone.catalog.controller;
import com.spotifyclone.catalog.model.*; import com.spotifyclone.catalog.repository.*; import jakarta.servlet.http.HttpSession; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException; import java.time.LocalDateTime; import java.util.*;
@RestController @RequestMapping("/api/me") @CrossOrigin(origins={"http://localhost:5173","http://127.0.0.1:5173"},allowCredentials="true")
public class PersonalLibraryController {
 private final AppUserRepository users; private final PlaylistRepository playlists; private final SongRepository songs; private final FavoriteSongRepository favorites; private final PlaybackHistoryRepository history;
 public PersonalLibraryController(AppUserRepository u,PlaylistRepository p,SongRepository s,FavoriteSongRepository f,PlaybackHistoryRepository h){users=u;playlists=p;songs=s;favorites=f;history=h;}
 private AppUser user(HttpSession session){Object id=session.getAttribute("userId");if(!(id instanceof Long userId))throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Iniciá sesión");return users.findById(userId).orElseThrow(()->new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Iniciá sesión"));}
 private Playlist owned(Long id,AppUser user){return playlists.findByIdAndOwnerId(id,user.getId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Playlist no encontrada"));}
 @GetMapping("/playlists") public List<Playlist> playlists(HttpSession s){return playlists.findByOwnerIdOrderByIdDesc(user(s).getId());}
 @PostMapping("/playlists") public Playlist create(@RequestBody NameBody b,HttpSession s){String n=validName(b.name());return playlists.save(new Playlist(n,user(s)));}
 @PutMapping("/playlists/{id}") public Playlist rename(@PathVariable Long id,@RequestBody NameBody b,HttpSession s){Playlist p=owned(id,user(s));p.rename(validName(b.name()));return playlists.save(p);}
 @DeleteMapping("/playlists/{id}") public ResponseEntity<Void> delete(@PathVariable Long id,HttpSession s){playlists.delete(owned(id,user(s)));return ResponseEntity.noContent().build();}
 @PostMapping("/playlists/{id}/songs/{songId}") public Playlist addSong(@PathVariable Long id,@PathVariable Long songId,HttpSession s){Playlist p=owned(id,user(s));Song song=songs.findById(songId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Canción no encontrada"));p.addSong(song);return playlists.save(p);}
 @DeleteMapping("/playlists/{id}/songs/{songId}") public Playlist removeSong(@PathVariable Long id,@PathVariable Long songId,HttpSession s){Playlist p=owned(id,user(s));p.removeSong(songId);return playlists.save(p);}
 @GetMapping("/favorites") public List<FavoriteSong> favorites(HttpSession s){return favorites.findByUserIdOrderByIdDesc(user(s).getId());}
 @PostMapping("/favorites/{songId}") public FavoriteSong addFavorite(@PathVariable Long songId,HttpSession s){AppUser u=user(s);Song song=songs.findById(songId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Canción no encontrada"));return favorites.findByUserIdAndSongId(u.getId(),songId).orElseGet(()->favorites.save(new FavoriteSong(u,song)));}
 @DeleteMapping("/favorites/{songId}") public ResponseEntity<Void> removeFavorite(@PathVariable Long songId,HttpSession s){favorites.findByUserIdAndSongId(user(s).getId(),songId).ifPresent(favorites::delete);return ResponseEntity.noContent().build();}
 @GetMapping("/history") public List<PlaybackHistory> history(HttpSession s){return history.findByUserIdOrderByPlayedAtDesc(user(s).getId());}
 @PostMapping("/history/{songId}") public PlaybackHistory played(@PathVariable Long songId,HttpSession s){AppUser u=user(s);Song song=songs.findById(songId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Canción no disponible"));return history.save(new PlaybackHistory(u,song,LocalDateTime.now()));}
 private String validName(String name){if(name==null||name.trim().isEmpty()||name.trim().length()>100)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Ingresá un nombre de hasta 100 caracteres");return name.trim();}
 public record NameBody(String name){}
}
