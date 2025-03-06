package ru.nsu.odnostorontseva.pizza;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.nsu.odnostorontseva.pizza.configs.Pizzeria;

import java.io.IOException;
import java.io.InputStream;

public class ConfigReader {
    public static Pizzeria loader() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.json")) {
                if (inputStream == null) {
                    throw new RuntimeException("Файл не найдет в ресурсах");
                }
                return mapper.readValue(inputStream, Pizzeria.class);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка загрузки: " + e.getMessage());
        }

    }
}
