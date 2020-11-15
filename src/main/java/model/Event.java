package model;

import java.util.Date;

public class Event {
    private int eventId;
    private String eventName;
    private Date eventDate;
    private int eventCost;

    public Event() {

    }

    public Event(int eventId, String eventName, Date eventDate, int eventCost) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventCost = eventCost;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getEventCost() {
        return eventCost;
    }

    public void setEventCost(int eventCost) {
        this.eventCost = eventCost;
    }
}

