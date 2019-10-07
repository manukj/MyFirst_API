package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    private  final UUID uuid;
    private final String name;


    public Person(@JsonProperty("uid") UUID uuid,@JsonProperty("name") String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }
}
