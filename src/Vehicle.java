public class Vehicle {
    private String origin;
    private String destiny;
    private int capacity;
    private int duration; // in hours

    public Vehicle(String origin, String destiny, int capacity, int duration) {
        this.origin = origin;
        this.destiny = destiny;
        this.capacity = capacity;
        this.duration = duration;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "origin='" + origin + '\'' +
                ", destiny='" + destiny + '\'' +
                ", capacity=" + capacity +
                ", duration=" + duration +
                '}';
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
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
