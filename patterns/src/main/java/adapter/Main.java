package adapter;


interface Logistics {
    void transportGoods();
}


class LogisticsSystem implements Logistics {
    @Override
    public void transportGoods() {
        System.out.println("Транспортування вантажу за допомогою логістичної системи");
    }
}

class TransportDispatcherAdapter implements Logistics {
    private TransportDispatcher transportDispatcher;

    public TransportDispatcherAdapter(TransportDispatcher transportDispatcher) {
        this.transportDispatcher = transportDispatcher;
    }

    @Override
    public void transportGoods() {
        transportDispatcher.dispatchGoods();
    }
}

interface TransportDispatcher {
    void dispatchGoods();
}

class TransportSystem implements TransportDispatcher {
    @Override
    public void dispatchGoods() {
        System.out.println("Транспортування вантажу за допомогою системи перевезень");
    }
}

public class Main {
    public static void main(String[] args) {

        Logistics logisticsSystem = new LogisticsSystem();
        logisticsSystem.transportGoods();


        TransportDispatcher transportDispatcher = new TransportSystem();
        Logistics adapter = new TransportDispatcherAdapter(transportDispatcher);
        adapter.transportGoods();
    }
}
