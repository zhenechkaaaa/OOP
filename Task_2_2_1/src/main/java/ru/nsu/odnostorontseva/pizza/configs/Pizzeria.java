package ru.nsu.odnostorontseva.pizza.configs;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pizzeria {
    private int workingTime;
    private List<Baker> bakers;
    private List<Courier> couriers;
    private int storageCapacity;
}