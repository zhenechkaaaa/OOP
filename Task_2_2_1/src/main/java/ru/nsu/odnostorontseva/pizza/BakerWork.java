package ru.nsu.odnostorontseva.pizza;

import lombok.RequiredArgsConstructor;
import ru.nsu.odnostorontseva.pizza.configs.Order;

/**
 *
 */
@RequiredArgsConstructor
public final class BakerWork implements Runnable{
    private final int id;
    private final int speed;
    private final String name;
    private final OrderQueue queue;
    private final Storage storage;

    @Override
    public void run() {
        try {
            while (PizzeriaWork.stillWorking || !queue.isEmpty()) {
                Order order = queue.takeOrder();
                order.statusUpdater("готовится пекарем по имени " + name);
                Thread.sleep(speed * 1000L);
                System.out.println("Пекарь " + name + " закончил работу.");
                order.statusUpdater("готова и передана на склад.");
                storage.addOrder(order);
            }
            System.out.println("С чувством выполненного долга пекарь " + name + " ушел домой.");
        } catch (InterruptedException e) {
            System.out.println("Пекарь " + name + " был прерван, завершение работы...");
            Thread.currentThread().interrupt();
        }
    }
}
