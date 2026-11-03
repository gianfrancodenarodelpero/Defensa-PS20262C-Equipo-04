package com.spotifyclone.catalog.repository;
import com.spotifyclone.catalog.model.Album; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface AlbumRepository extends JpaRepository<Album,Long> { List<Album> findByTitleContainingIgnoreCase(String query); List<Album> findByArtistId(Long artistId); }
