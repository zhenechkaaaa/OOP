package ru.nsu.odnostorontseva.autochecker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Settings {
    private GradingCriteria gradingCriteria;
    private String strategy;
    //private Map<String, Object> otherSettings = new HashMap<>();

    @Override
    public String toString() {
        return "Settings [gradingCriteria=" + gradingCriteria + ", strategy=" + strategy + "]";
    }
}
