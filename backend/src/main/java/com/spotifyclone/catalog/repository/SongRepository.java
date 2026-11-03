package com.spotifyclone.catalog.repository;
import com.spotifyclone.catalog.model.Song; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface SongRepository extends JpaRepository<Song,Long> { List<Song> findByTitleContainingIgnoreCase(String q); List<Song> findByArtistId(Long id); List<Song> findByAlbumId(Long id); }
