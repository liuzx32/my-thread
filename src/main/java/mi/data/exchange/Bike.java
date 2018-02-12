package mi.data.exchange;

import java.util.concurrent.Exchanger;

public class Bike extends Thread {

    private Exchanger<String> exchanger;

    public Bike(Exchanger<String> exchanger) {
        super("bike");
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String name = Thread.currentThread().getName();
            String value = exchanger.exchange("fromBike");
            System.out.println(name + ": " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}