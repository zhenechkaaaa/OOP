package ru.nsu.odnostorontseva.pizza;

import ru.nsu.odnostorontseva.pizza.configs.Order;
import java.util.ArrayList;
import java.util.List;

/**
 * The `OrderQueue` class represents a thread-safe queue for managing pizza orders.
 * It allows adding orders to the queue and retrieving them for processing.
 */
public class OrderQueue {
    private final List<Order> queue = new ArrayList<>();

    /**
     * Adds an order to the queue and notifies all waiting threads.
     *
     * @param order the order to be added to the queue.
     * @throws InterruptedException if the thread is interrupted while waiting.
     */
    protected synchronized void addOrder(Order order) throws InterruptedException {
        queue.add(order);
        order.statusUpdater("добавлена в очередь заказов.");
        notifyAll();
    }

    /**
     * Retrieves and removes the first order from the queue.
     * If the queue is empty, the method waits until an order is added.
     *
     * @return the first order in the queue.
     * @throws InterruptedException if the thread is interrupted while waiting.
     */
    protected synchronized Order takeOrder() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Очередь пустая. Ждем заказов.");
            wait();
        }
        Order order = queue.removeFirst();
        order.statusUpdater("передана пекарю.");
        notifyAll();
        return order;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return `true` if the queue is empty, `false` otherwise.
     */
    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}