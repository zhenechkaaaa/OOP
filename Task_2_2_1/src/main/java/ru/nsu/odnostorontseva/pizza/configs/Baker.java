package ru.nsu.odnostorontseva.pizza.configs;

import lombok.Getter;
import lombok.Setter;

/**
 * The Baker class represents the configuration of the baker.
 * It contains id, name and speed.
 */
@Getter
@Setter
public class Baker {
    private int id;
    private int speed;
    private String name;
}
