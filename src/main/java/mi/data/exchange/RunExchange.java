package mi.data.exchange;

import java.util.concurrent.Exchanger;

public class RunExchange {

    public static void main(String[] args) throws Exception {
        Exchanger<String> exchanger = new Exchanger<>();
        MyCar car = new MyCar(exchanger);
        Bike bike = new Bike(exchanger);
        car.start();
        Thread.sleep(1000);
        bike.start();
        Thread.sleep(1000);
        System.out.println("Main end!");
    }
}
