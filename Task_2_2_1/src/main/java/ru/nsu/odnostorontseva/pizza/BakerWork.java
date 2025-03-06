package ru.nsu.odnostorontseva.pizza;

import lombok.RequiredArgsConstructor;
import ru.nsu.odnostorontseva.pizza.configs.Order;

@RequiredArgsConstructor
public class BakerWork implements Runnable{
    private final int id;
    private final int speed;
    private final OrderQueue queue;
    private final Storage storage;
    private volatile boolean running = true;

    @Override
    public void run() {
        try {
            while (running || !queue.isEmpty()) {
                Order order = queue.takeOrder();
                order.statusUpdater("готовится пекарем №" + id);
                Thread.sleep(speed * 1000L);
                System.out.println("Пекарь №" + id + " закончил работу.");
                order.statusUpdater("готова и передана на склад.");
                storage.addOrder(order);
            }
            System.out.println("С чувством выполненного долга повар №" + id + " ушел домой.");
        } catch (InterruptedException e) {
            System.out.println("Пекарь " + id + " был прерван, завершение работы...");
            Thread.currentThread().interrupt();
        }
    }

    public void bakerBroker() {
        running = false;
    }
}
