package com.xyz.training.bank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StatementPrinter {
    private static final String HEADER = "DATE | AMOUNT | BALANCE";

    private final Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.print(HEADER);
        if(transactions!=null){
            AtomicInteger runningBalance = new AtomicInteger(0);
            transactions.stream().map(t -> statementLine(runningBalance, t))
                    .forEach(s -> console.print(s));
        }
    }

    private String statementLine(AtomicInteger runningBalance, Transaction t) {
        return t.date() +
                " | " +
                formatDecimal(t.amount()) +
                " | " +
                formatDecimal(runningBalance.addAndGet(t.amount()));
    }

    private String formatDecimal(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(amount);
    }
}
