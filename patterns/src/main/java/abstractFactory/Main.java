package abstractFactory;


abstract class Transport {
    public abstract void deliver();
}


class Truck extends Transport {
    @Override
    public void deliver() {
        System.out.println("Грузовик везе вантаж по дорозі");
    }
}

class Ship extends Transport {
    @Override
    public void deliver() {
        System.out.println("Корабель перевозить вантаж морем");
    }
}


abstract class LogisticsFactory {
    public abstract Transport createTransport();
}

class TruckFactory extends LogisticsFactory {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

class ShipFactory extends LogisticsFactory {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}

public class Main {
    public static void main(String[] args) {
        LogisticsFactory factory = new TruckFactory();
        Transport transport = factory.createTransport();
        transport.deliver();

        LogisticsFactory shipFactory = new ShipFactory();
        Transport stransport = shipFactory.createTransport();
        stransport.deliver();

    }
}
