package singletone;

public class LogisticsDispatcher {

    private static LogisticsDispatcher instance;

    private LogisticsDispatcher() {
    }

    public static LogisticsDispatcher getInstance() {
        if (instance == null) {
            instance = new LogisticsDispatcher();
        }
        return instance;
    }

    public void dispatchGoods(String goods, String destination) {
        System.out.println("Відправлено товар '" + goods + "' до " + destination);
    }

    public static void main(String[] args) {
        LogisticsDispatcher dispatcher1 = LogisticsDispatcher.getInstance();
        LogisticsDispatcher dispatcher2 = LogisticsDispatcher.getInstance();

        System.out.println("dispatcher1 == dispatcher2: " + (dispatcher1 == dispatcher2));
        System.out.println("dispatcher1 equals dispatcher2: " + dispatcher1.equals(dispatcher2));
    }
}

