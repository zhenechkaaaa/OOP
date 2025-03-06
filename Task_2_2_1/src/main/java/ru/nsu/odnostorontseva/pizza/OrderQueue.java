package ru.nsu.odnostorontseva.pizza;

import ru.nsu.odnostorontseva.pizza.configs.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderQueue {
    private final List<Order> queue = new ArrayList<>();

    public synchronized void addOrder(Order order) throws InterruptedException {
        queue.add(order);
        order.statusUpdater("добавлена в очередь заказов.");
        notifyAll();
    }

    public synchronized Order takeOrder() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Очередь пустая. Ждем заказов.");
            wait();
        }
        Order order = queue.removeFirst();
        order.statusUpdater("передана пекарю.");
        notifyAll();
        return order;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
