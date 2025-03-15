package ru.nsu.odnostorontseva.pizza;

import ru.nsu.odnostorontseva.pizza.configs.Order;

import java.util.LinkedList;
import java.util.List;

public class Storage {
    private final List<Order> storage = new LinkedList<>();
    private final int capacity;

    public Storage(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void addOrder(Order order) throws InterruptedException {
        while(storage.size() >= capacity) {
            System.out.println("Склад переполнен, ждем появления свободных мест.");
            wait();
        }
        storage.add(order);
        order.statusUpdater("размещена на складе.");
        notifyAll();
    }

    public synchronized List<Order> takeOrder(int courierCapacity) throws InterruptedException {
        while (storage.isEmpty()) {
            System.out.println("Склад пуст. Ждем готовых заказов.");
            wait();
        }
        List<Order> takenOrders = new LinkedList<>();
        while (!storage.isEmpty() && takenOrders.size() < courierCapacity) {
            takenOrders.add(storage.removeFirst());
        }
        System.out.println(takenOrders.size() + " пицц забрали со склада.");
        notifyAll();
        return takenOrders;
    }

    public synchronized boolean isEmpty() {
        return storage.isEmpty();
    }
}
