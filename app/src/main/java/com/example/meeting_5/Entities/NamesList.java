package com.example.meeting_5.Entities;

import java.util.Arrays;
import java.util.List;

public class NamesList {
    private List<NameEntity> names;

    public NamesList() {
        names = Arrays.asList(
                new NameEntity("Арсений", "30.11.2002", "Тестовое описание имени."),
                new NameEntity("Арсений2", "01.11.2002", "Тестовое описание имени."),
                new NameEntity("Арсений3", "02.11.2002", "Тестовое описание имени."),
                new NameEntity("Арсений4", "03.11.2002", "Тестовое описание имени."),
                new NameEntity("Арсений5", "04.11.2002", "Тестовое описание имени."),
                new NameEntity("Арсений6", "05.11.2002", "Тестовое описание имени."),
                new NameEntity("Арсений7", "06.11.2002", "Тестовое описание имени."),
                new NameEntity("Арсений8", "07.11.2002", "Тестовое описание имени."),
                new NameEntity("Арсений9", "08.11.2002", "Тестовое описание имени."),
                new NameEntity("Арсений10", "09.11.2002", "Тестовое описание имени."),
                new NameEntity("Арсений11", "10.11.2002", "Тестовое описание имени."),
                new NameEntity("Арсений12", "11.11.2002", "Тестовое описание имени.")
        );
    }

    public NameEntity findName(String name) {
        for(NameEntity entity : names) {
            if(entity.getName().equals(name)) {
                return entity;
            }
        }
        return null;
    }

    public List<NameEntity> getAll() {
        return names;
    }
}
