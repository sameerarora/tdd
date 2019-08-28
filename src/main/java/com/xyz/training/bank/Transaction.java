package com.xyz.training.bank;

public class Transaction {

    private String date;

    private final int amount;

    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;

        Transaction that = (Transaction) o;

        if (amount != that.amount) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    public String date() {
        return this.date;
    }

    public int amount() {
        return this.amount;
    }
}
