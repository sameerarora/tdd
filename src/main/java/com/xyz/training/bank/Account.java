package com.xyz.training.bank;

public class Account {

    private final TransactionRepository transactionRepository;

    private final StatementPrinter statementPrinter;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactionRepository.saveDeposit(amount);
    }

    public void withdraw(int amount) {
        transactionRepository.saveWithdrawal(amount);
    }

    public void printStatement() {
        statementPrinter.print(transactionRepository.all());
    }
}
