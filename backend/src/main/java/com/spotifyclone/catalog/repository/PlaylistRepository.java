package com.spotifyclone.catalog.repository;
import com.spotifyclone.catalog.model.Playlist; import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param; import java.util.*;
public interface PlaylistRepository extends JpaRepository<Playlist,Long>{
 @EntityGraph(attributePaths={"songs","owner"}) @Query("select p from Playlist p where p.owner.id=:ownerId order by p.id desc") List<Playlist> findByOwnerIdOrderByIdDesc(@Param("ownerId") Long ownerId);
 @EntityGraph(attributePaths={"songs","owner"}) @Query("select p from Playlist p where p.id=:id and p.owner.id=:ownerId") Optional<Playlist> findByIdAndOwnerId(@Param("id") Long id,@Param("ownerId") Long ownerId);
}
