package com.eventBooking.repository;

import com.eventBooking.model.TicketReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketReservationRepository extends JpaRepository<TicketReservation , Long> {
    boolean existsByEventNameAndCustomerEmail(String eventName, String customerEmail);

//    boolean existsByEvent(String eventName, String customerEmail);
    
}

