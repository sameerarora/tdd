package com.xyz.training.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.Arrays.asList;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {

    @Mock
    private Console console;

    private StatementPrinter statementPrinter;

    @Before
    public void setUp() throws Exception {
        statementPrinter = new StatementPrinter(console);
    }

    @Test
    public void shouldPrintHeaderRegardlessOfNumberOfTransactions() throws Exception {
        statementPrinter.print(null);

        Mockito.verify(console).print("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void shouldPrintHeaderAndTransactions() throws Exception {
        statementPrinter.print(asList(new Transaction("01/01/2019", 1000), new Transaction("03/02/2019", -200)));

        Mockito.verify(console).print("DATE | AMOUNT | BALANCE");
        Mockito.verify(console).print("01/01/2019 | 1000.00 | 1000.00");
        Mockito.verify(console).print("03/02/2019 | -200.00 | 800.00");
    }
}