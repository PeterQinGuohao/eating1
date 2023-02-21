package model;

public class Summary {
    private String id;
    private String activity;
    private String group;
    private double duration;
    private double distance;
    private int steps;
    private int calories;

    public Summary(String id, String activity, String group, double duration, double distance, int steps, int calories) {
        this.id = id;
        this.activity = activity;
        this.group = group;
        this.duration = duration;
        this.distance = distance;
        this.steps = steps;
        this.calories = calories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
