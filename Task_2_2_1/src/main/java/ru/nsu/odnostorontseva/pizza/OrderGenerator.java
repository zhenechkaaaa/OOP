package ru.nsu.odnostorontseva.pizza;

import lombok.RequiredArgsConstructor;
import ru.nsu.odnostorontseva.pizza.configs.Order;

@RequiredArgsConstructor
class OrderGenerator implements Runnable {
    private final OrderQueue queue;
    private volatile boolean running = true;

    @Override
    public void run() {
        int orderId = 1;
        try {
            while (running) {
                Order order = new Order(orderId++, "принята.");
                queue.addOrder(order);
                Thread.sleep(2000);
            }
            System.out.println("Приём заказов завершен.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stopGenerator() {
        running = false;
    }
}
