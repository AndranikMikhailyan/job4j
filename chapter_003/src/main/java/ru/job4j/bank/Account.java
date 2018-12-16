package ru.job4j.bank;

public class Account {

    private int value;
    private String requisites;

    public Account(String requisites) {
        this.requisites = requisites;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }
}
