package com.eventBooking.serviceImplementation;

import com.eventBooking.dtos.request.NotificationRequest;
import com.eventBooking.model.Notification;
import com.eventBooking.services.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Override
    public Notification sendNotification(NotificationRequest notificationRequest) {
        return null;
    }
}
