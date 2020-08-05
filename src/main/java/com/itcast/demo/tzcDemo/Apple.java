package com.itcast.demo.tzcDemo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Apple {
    private String name;
    private Integer weight;

    public Apple(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }
}
