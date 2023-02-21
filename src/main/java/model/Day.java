package model;

import java.util.List;

public class Day {
    private String id;
    private String date;
    private List<Summary> summary;
    private List<Segments> segments;
    private int caloriesIdle;
    private String lastUpdate;

    public Day(String id, String date, List<Summary> summary, List<Segments> segments, int caloriesIdle, String lastUpdate) {
        this.id = id;
        this.date = date;
        this.summary = summary;
        this.segments = segments;
        this.caloriesIdle = caloriesIdle;
        this.lastUpdate = lastUpdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Summary> getSummary() {
        return summary;
    }

    public void setSummary(List<Summary> summary) {
        this.summary = summary;
    }

    public List<Segments> getSegments() {
        return segments;
    }

    public void setSegments(List<Segments> segments) {
        this.segments = segments;
    }

    public int getCaloriesIdle() {
        return caloriesIdle;
    }

    public void setCaloriesIdle(int caloriesIdle) {
        this.caloriesIdle = caloriesIdle;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}