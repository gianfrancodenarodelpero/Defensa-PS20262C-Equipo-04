package com.spotifyclone.catalog.repository;
import com.spotifyclone.catalog.model.FavoriteSong; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List; import java.util.Optional;
public interface FavoriteSongRepository extends JpaRepository<FavoriteSong,Long>{List<FavoriteSong> findByUserIdOrderByIdDesc(Long userId);Optional<FavoriteSong> findByUserIdAndSongId(Long userId,Long songId);}
