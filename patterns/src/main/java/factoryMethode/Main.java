package factoryMethode;

interface Transport {
    void deliver();
}

class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Доставка вантажу автомобілем");
    }
}

class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Доставка вантажу кораблем");
    }
}

interface TransportFactory {
    Transport createTransport();
}

class TruckFactory implements TransportFactory {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

class ShipFactory implements TransportFactory {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}

class LogisticsManager {
    private TransportFactory transportFactory;

    public LogisticsManager(TransportFactory transportFactory) {
        this.transportFactory = transportFactory;
    }

    public void planDelivery() {
        Transport transport = transportFactory.createTransport();
        transport.deliver();
    }
}

public class Main {
    public static void main(String[] args) {
        TransportFactory truckFactory = new TruckFactory();
        LogisticsManager truckManager = new LogisticsManager(truckFactory);
        truckManager.planDelivery();

        TransportFactory shipFactory = new ShipFactory();
        LogisticsManager shipManager = new LogisticsManager(shipFactory);
        shipManager.planDelivery();
    }
}
