package model;

import java.util.ArrayList;

public class Segments {
    private String id;
    private String type;
    private String startTime;
    private String endTime;
    private Object place;
    private ArrayList<Object> activities;
    private String lastUpdate;

    public Segments(String id, String type, String startTime, String endTime, Object place, ArrayList<Object> activities, String lastUpdate) {
        this.id = id;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.place = place;
        this.activities = activities;
        this.lastUpdate = lastUpdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Object getPlace() {
        return place;
    }

    public void setPlace(Object place) {
        this.place = place;
    }

    public ArrayList<Object> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Object> activities) {
        this.activities = activities;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
