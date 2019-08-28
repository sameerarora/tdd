package com.xyz.training.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TransactionRepository {

    private final ArrayList<Transaction> transactions = new ArrayList<>();

    private Supplier<String> clock;

    public TransactionRepository(Supplier<String> clock) {
        this.clock = clock;
    }

    public void saveDeposit(int amount) {
        transactions.add(new Transaction(clock.get(), amount));
    }

    public void saveWithdrawal(int amount) {
        transactions.add(new Transaction(clock.get(), -amount));
    }

    public List<Transaction> all() {
        return transactions;
    }
}
