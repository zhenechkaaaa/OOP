package ru.nsu.odnostorontseva.pizza.configs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private String status;

    public void statusUpdater(String newStatus) {
        this.status = newStatus;
        System.out.println("Пицца №" + id + " " + newStatus);
    }
}
