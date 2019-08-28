package com.xyz.training.bank.feature;

import com.xyz.training.bank.Account;
import com.xyz.training.bank.Console;
import com.xyz.training.bank.StatementPrinter;
import com.xyz.training.bank.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.function.Supplier;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    @Mock
    private Console console;

    @Mock
    private Supplier<String> clock;

    private TransactionRepository transactionRepository;

    private StatementPrinter statementPrinter;

    @Test
    public void shouldPrintAllTransactionsOfAccount() throws Exception {
        Mockito.when(clock.get()).thenReturn("01/01/2019", "12/02/2019", "10/04/2019");
        transactionRepository = new TransactionRepository(clock);
        statementPrinter = new StatementPrinter(console);

        Account account = new Account(transactionRepository, statementPrinter);

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        Mockito.verify(console).print("DATE | AMOUNT | BALANCE");
        Mockito.verify(console).print("01/01/2019 | 1000.00 | 1000.00");
        Mockito.verify(console).print("12/02/2019 | -100.00 | 900.00");
        Mockito.verify(console).print("10/04/2019 | 500.00 | 1400.00");
    }
}
