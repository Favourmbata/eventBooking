package com.eventBooking.repository;

import com.eventBooking.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event , Long> {
    boolean existsByEventNameAndAppUserEmail(String eventName, String eventCreatorEmail);
}
