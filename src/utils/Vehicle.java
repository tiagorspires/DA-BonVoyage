package utils;

public class Vehicle {
    private int origin;
    private int destiny;
    private int capacity;
    private int duration; // in hours

    public Vehicle(int origin, int destiny, int capacity, int duration) {
        this.origin = origin;
        this.destiny = destiny;
        this.capacity = capacity;
        this.duration = duration;
    }

    public int getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "utils.Vehicle{" +
                "origin='" + origin + '\'' +
                ", destiny='" + destiny + '\'' +
                ", capacity=" + capacity +
                ", duration=" + duration +
                '}';
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getDestiny() {
        return destiny;
    }

    public void setDestiny(int destiny) {
        this.destiny = destiny;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
