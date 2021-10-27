package com.app.components;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;

public class MyNotification {
    public static Notification set(String message) {
        Notification notification = Notification.show(message, 3000, Position.TOP_CENTER);
        return notification;
    }
}
