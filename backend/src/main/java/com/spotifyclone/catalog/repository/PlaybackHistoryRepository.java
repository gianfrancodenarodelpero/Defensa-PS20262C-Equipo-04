package com.spotifyclone.catalog.repository;
import com.spotifyclone.catalog.model.PlaybackHistory; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface PlaybackHistoryRepository extends JpaRepository<PlaybackHistory,Long>{List<PlaybackHistory> findByUserIdOrderByPlayedAtDesc(Long userId);}
