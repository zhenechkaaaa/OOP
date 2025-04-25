package ru.nsu.odnostorontseva.autochecker.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class GradingCriteria {
    private Map<String, Integer> tresholds = new HashMap<>();

    public void addTreshold(String grade, int treshold) {
        tresholds.put(grade, treshold);
    }

    public Integer getTreshold(String grade) {
        return tresholds.get(grade);
    }

    @Override
    public String toString() {
        return "GradingCriteria [tresholds=" + tresholds + "]";
    }
}
