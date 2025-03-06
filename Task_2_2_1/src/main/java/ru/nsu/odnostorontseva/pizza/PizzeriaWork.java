package ru.nsu.odnostorontseva.pizza;

import lombok.Getter;
import lombok.Setter;
import ru.nsu.odnostorontseva.pizza.configs.Baker;
import ru.nsu.odnostorontseva.pizza.configs.Courier;
import ru.nsu.odnostorontseva.pizza.configs.Pizzeria;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PizzeriaWork {
    private final int workingTime;
    private final List<BakerWork> bakers = new ArrayList<>();
    private final List<CourierWork> couriers = new ArrayList<>();
    private final OrderQueue orderQueue = new OrderQueue();
    private final Storage storage;
    private final OrderGenerator generator;
    private final List<Thread> threads = new ArrayList<>();

    public PizzeriaWork() throws Exception {
        Pizzeria data = ConfigReader.loader();

        this.storage = new Storage(data.getStorageCapacity());
        this.generator = new OrderGenerator(orderQueue);
        workingTime = data.getWorkingTime();

        for (Baker b : data.getBakers()) {
            bakers.add(new BakerWork(
                    b.getId(),
                    b.getSpeed(),
                    orderQueue,
                    storage));
        }
        for (Courier c : data.getCouriers()) {
            couriers.add(new CourierWork(
                    c.getId(),
                    c.getCapacity(),
                    storage));
        }
    }


    public void start() {
        System.out.println("Пиццерия открыта!");

        Thread orderGeneratorThread = new Thread(generator);
        orderGeneratorThread.start();
        threads.add(orderGeneratorThread);

        for (BakerWork baker : bakers) {
            Thread thread = new Thread(baker);
            thread.start();
            threads.add(thread);
        }

        for (CourierWork courier : couriers) {
            Thread thread = new Thread(courier);
            thread.start();
            threads.add(thread);
        }
    }

    public void stop() throws InterruptedException {
        System.out.println("Закрытие пиццерии...");

        generator.stopGenerator();
        bakers.forEach(BakerWork::bakerBroker);
        couriers.forEach(CourierWork::courierBroker);

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Пиццерия закрыта.");
    }

    public static void main(String[] args) throws Exception {
        PizzeriaWork pizzeria = new PizzeriaWork();
        pizzeria.start();
        Thread.sleep(pizzeria.workingTime * 1000L);
        pizzeria.stop();
    }
}
