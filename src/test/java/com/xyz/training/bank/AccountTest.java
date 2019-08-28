package com.xyz.training.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private StatementPrinter statementPrinter;

    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void shouldStoreDepositTransactions() throws Exception {
        account.deposit(1000);
        Mockito.verify(transactionRepository).saveDeposit(1000);
    }

    @Test
    public void shouldStoreWithdrawalTransactions() throws Exception {
        account.withdraw(100);
        Mockito.verify(transactionRepository).saveWithdrawal(100);
    }

    @Test
    public void shouldCallStatementPrinterWithAllTransactions() throws Exception {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Mockito.when(transactionRepository.all()).thenReturn(transactions);

        account.printStatement();

        Mockito.verify(statementPrinter).print(transactions);
    }
}
