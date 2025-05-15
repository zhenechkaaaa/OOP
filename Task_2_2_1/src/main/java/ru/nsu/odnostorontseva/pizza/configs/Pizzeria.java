package ru.nsu.odnostorontseva.pizza.configs;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * The Pizzeria class represents the configuration of a pizzeria.
 * It contains details such as working time, bakers, couriers, and storage capacity.
 */
@Getter
@Setter
public class Pizzeria {
    private int workingTime;
    private List<Baker> bakers;
    private List<Courier> couriers;
    private int storageCapacity;
}