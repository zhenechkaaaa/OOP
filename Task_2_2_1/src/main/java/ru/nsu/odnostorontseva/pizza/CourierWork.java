package ru.nsu.odnostorontseva.pizza;

import lombok.RequiredArgsConstructor;
import ru.nsu.odnostorontseva.pizza.configs.Order;
import java.util.List;

@RequiredArgsConstructor
public class CourierWork implements Runnable{
    private final int id;
    private final int capacity;
    private final String name;
    private final Storage storage;

    @Override
    public void run() {
        try {
            while (PizzeriaWork.stillWorking || !storage.isEmpty()) {
                List<Order> orders = storage.takeOrder(capacity);
                System.out.println("Курьер " + name + " везет " + orders.size() + " пицц клиентам.");
                orders.forEach(order -> order.statusUpdater("едет к заказчику."));
                Thread.sleep(5000);
                System.out.println("Курьер " + name + " доставил заказы.");
                orders.forEach(order -> order.statusUpdater("добралась до счастливого заказчика!"));
            }
            System.out.println("С чувством выполненного долга курьер " + name + " ушел домой.");
        } catch (InterruptedException e) {
            System.out.println("Курьер " + name + " был прерван, завершение работы...");
            Thread.currentThread().interrupt();
        }
    }
}
