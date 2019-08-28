package com.xyz.training.bank;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

public class BankApp {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Supplier<String> clock = () -> simpleDateFormat.format(new Date());

        TransactionRepository transactionRepository = new TransactionRepository(clock);
        StatementPrinter statementPrinter = new StatementPrinter(new Console());

        Account account = new Account(transactionRepository, statementPrinter);

        account.deposit(1000);
        account.withdraw(500);
        account.deposit(200);

        account.printStatement();
    }
}
