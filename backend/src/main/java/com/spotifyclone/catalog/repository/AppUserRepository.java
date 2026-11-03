package com.spotifyclone.catalog.repository;
import com.spotifyclone.catalog.model.AppUser; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface AppUserRepository extends JpaRepository<AppUser,Long>{Optional<AppUser> findByEmailIgnoreCase(String email);}
