package com.eventBooking.services;

import com.eventBooking.dtos.request.NotificationRequest;
import com.eventBooking.model.Notification;

public interface NotificationService {
    Notification sendNotification(NotificationRequest notificationRequest);
}
