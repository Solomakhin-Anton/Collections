package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Assignee {
    private int id;
    private String name;
    private String surname;

    public Assignee(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

}

