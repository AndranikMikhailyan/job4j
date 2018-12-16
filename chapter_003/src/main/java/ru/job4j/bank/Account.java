package ru.job4j.bank;

public class Account {

    private double value;
    private String requisites;

    public Account(String requisites) {
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public boolean transfer(Account account, double amount) {
        boolean result = false;
        if (amount <= this.value) {
            result = true;
        }
        return result;
    }
}
