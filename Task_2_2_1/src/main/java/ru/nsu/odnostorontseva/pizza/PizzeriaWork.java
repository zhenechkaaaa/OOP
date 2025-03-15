package ru.nsu.odnostorontseva.pizza;

import java.util.ArrayList;
import java.util.List;
import ru.nsu.odnostorontseva.pizza.configs.Baker;
import ru.nsu.odnostorontseva.pizza.configs.Courier;
import ru.nsu.odnostorontseva.pizza.configs.Order;
import ru.nsu.odnostorontseva.pizza.configs.Pizzeria;

/**
 * The PizzeriaWork class represents the main workflow of a pizzeria.
 * It manages bakers, couriers, order generation, and the overall operation of the pizzeria.
 */
public class PizzeriaWork {
    private final int workingTime;
    private final List<BakerWork> bakers = new ArrayList<>();
    private final List<CourierWork> couriers = new ArrayList<>();
    private static final OrderQueue orderQueue = new OrderQueue();
    private final Storage storage;
    private final OrderGenerator generator;
    private final List<Thread> threads = new ArrayList<>();
    public volatile static boolean stillWorking = true;

    /**
     * Constructs a new PizzeriaWork instance.
     * Initializes the pizzeria by loading configuration data, setting up storage,
     * order generation, bakers, and couriers.
     */
    public PizzeriaWork() {
        Pizzeria data = ConfigReader.loader();

        this.storage = new Storage(data.getStorageCapacity());
        this.generator = new OrderGenerator();
        workingTime = data.getWorkingTime();

        for (Baker b : data.getBakers()) {
            bakers.add(new BakerWork(
                    b.getId(),
                    b.getSpeed(),
                    b.getName(),
                    orderQueue,
                    storage));
        }
        for (Courier c : data.getCouriers()) {
            couriers.add(new CourierWork(
                    c.getId(),
                    c.getCapacity(),
                    c.getName(),
                    storage));
        }
    }

    /**
     * Adds order into orderQueue.
     *
     * @param order - order, needs to add.
     * @throws InterruptedException if interruption occurrence.
     */
    public static void addOrderToQueue(Order order) throws InterruptedException {
        orderQueue.addOrder(order);
    }

    /**
     * Starts the pizzeria operation.
     * Initializes and starts threads for order generation, bakers, and couriers.
     */
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

    /**
     * Stops the pizzeria operation.
     * Sets the `stillWorking` flag to false and waits for all threads to complete.
     *
     * @throws InterruptedException if any thread is interrupted during the join operation.
     */
    public void stop() throws InterruptedException {
        stillWorking = false;

        System.out.println("Закрытие пиццерии...");

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Пиццерия закрыта.");
    }

    /**
     * The main method to run the pizzeria simulation.
     * Creates a `PizzeriaWork` instance, starts the pizzeria, and stops it after the specified working time.
     *
     * @param args command-line arguments (not used).
     * @throws Exception if there is an error during execution.
     */
    public static void main(String[] args) throws Exception {
        PizzeriaWork pizzeria = new PizzeriaWork();
        pizzeria.start();
        Thread.sleep(pizzeria.workingTime * 1000L);
        pizzeria.stop();
    }
}