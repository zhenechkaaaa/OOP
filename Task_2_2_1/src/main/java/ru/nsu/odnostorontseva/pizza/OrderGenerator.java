package ru.nsu.odnostorontseva.pizza;

import lombok.RequiredArgsConstructor;
import ru.nsu.odnostorontseva.pizza.configs.Order;

@RequiredArgsConstructor
class OrderGenerator implements Runnable {

    public void orderAcceptance(Order order) throws InterruptedException {
        PizzeriaWork.addOrderToQueue(order);
    }

    @Override
    public void run() {
        int orderId = 1;
        try {
            while (PizzeriaWork.stillWorking) {
                Order order = new Order(orderId++, "принята.");
                orderAcceptance(order);
                Thread.sleep(2000);
            }
            System.out.println("Приём заказов завершен.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
