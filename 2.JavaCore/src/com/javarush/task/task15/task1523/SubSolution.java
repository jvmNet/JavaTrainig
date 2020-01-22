package com.javarush.task.task15.task1523;

public class SubSolution extends Solution {

    private String name;
    private int age;
    private String address;

    SubSolution() {
    }

    public SubSolution(String name) {
        super(name);
    }

    protected SubSolution(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

}
