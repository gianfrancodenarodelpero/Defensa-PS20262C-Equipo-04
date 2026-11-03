package com.spotifyclone.catalog.controller;
import com.spotifyclone.catalog.model.*; import com.spotifyclone.catalog.repository.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api") @CrossOrigin(origins={"http://localhost:5173","http://127.0.0.1:5173"},allowCredentials="true")
public class CatalogController {
 private final ArtistRepository artists; private final AlbumRepository albums; private final SongRepository songs;
 public CatalogController(ArtistRepository a,AlbumRepository b,SongRepository s){artists=a;albums=b;songs=s;}
 @GetMapping("/catalog") public Map<String,Object> catalog(){return Map.of("artists",artists.findAll(),"albums",albums.findAll(),"songs",songs.findAll());}
 @GetMapping("/artists") public List<Artist> artists(){return artists.findAll();}
 @GetMapping("/artists/search") public List<Artist> searchArtists(@RequestParam(defaultValue="") String q){return artists.findByNameContainingIgnoreCase(q);}
 @GetMapping("/artists/{id}") public Artist artist(@PathVariable Long id){return artists.findById(id).orElseThrow();}
 @GetMapping("/artists/{id}/albums") public List<Album> artistAlbums(@PathVariable Long id){return albums.findByArtistId(id);}
 @GetMapping("/artists/{id}/songs") public List<Song> artistSongs(@PathVariable Long id){return songs.findByArtistId(id);}
 @GetMapping("/albums") public List<Album> albums(){return albums.findAll();}
 @GetMapping("/albums/search") public List<Album> searchAlbums(@RequestParam(defaultValue="") String q){return albums.findByTitleContainingIgnoreCase(q);}
 @GetMapping("/albums/{id}") public Album album(@PathVariable Long id){return albums.findById(id).orElseThrow();}
 @GetMapping("/albums/{id}/songs") public List<Song> albumSongs(@PathVariable Long id){return songs.findByAlbumId(id);}
 @GetMapping("/songs") public List<Song> songs(){return songs.findAll();}
 @GetMapping("/songs/search") public List<Song> searchSongs(@RequestParam(defaultValue="") String q){return songs.findByTitleContainingIgnoreCase(q);}
 @GetMapping("/search") public Map<String,Object> search(@RequestParam(defaultValue="") String q){return Map.of("artists",artists.findByNameContainingIgnoreCase(q),"albums",albums.findByTitleContainingIgnoreCase(q),"songs",songs.findByTitleContainingIgnoreCase(q));}
}
