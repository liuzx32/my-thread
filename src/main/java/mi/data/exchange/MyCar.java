package mi.data.exchange;

import java.util.concurrent.Exchanger;

public class MyCar extends Thread {

    private Exchanger<String> exchanger;

    public MyCar(Exchanger<String> exchanger) {
        super("myCar");
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String name = Thread.currentThread().getName();
            String value = exchanger.exchange("fromCar");
            System.out.println(name + ": " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
