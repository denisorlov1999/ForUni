package prototype;

import java.util.ArrayList;
import java.util.List;

class Truck {
    private String id;
    private String destination;

    public Truck(String id, String destination) {
        this.id = id;
        this.destination = destination;
    }

    public Truck copy() {
        return new Truck(this.id, this.destination);
    }

    public String getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Truck{id='" + id + "', destination='" + destination + "'}";
    }
}

class LogisticsSystem {
    private List<Truck> trucks;

    public LogisticsSystem() {
        this.trucks = new ArrayList<>();
    }

    public void addTruck(Truck truck) {
        trucks.add(truck);
    }

    public LogisticsSystem copy() {
        LogisticsSystem copy = new LogisticsSystem();
        for (Truck truck : trucks) {
            copy.addTruck(truck.copy());
        }
        return copy;
    }

    public List<Truck> getTrucks() {
        return trucks;
    }
}

public class Main {
    public static void main(String[] args) {
        LogisticsSystem originalSystem = new LogisticsSystem();
        originalSystem.addTruck(new Truck("T1", "Destination1"));
        originalSystem.addTruck(new Truck("T2", "Destination2"));

        LogisticsSystem copiedSystem = originalSystem.copy();

        List<Truck> copiedTrucks = copiedSystem.getTrucks();
        if (!copiedTrucks.isEmpty()) {
            Truck firstTruck = copiedTrucks.get(0);
            firstTruck.setDestination("ModifiedDestination");
        }

        System.out.println("Original System: " + originalSystem.getTrucks());
        System.out.println("Copied System: " + copiedSystem.getTrucks());
    }
}
