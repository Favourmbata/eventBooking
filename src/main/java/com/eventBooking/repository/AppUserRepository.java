package com.eventBooking.repository;

import com.eventBooking.model.AppUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    boolean existsByEmail(String email);

    AppUser findByEmail(String userEmail);
}
