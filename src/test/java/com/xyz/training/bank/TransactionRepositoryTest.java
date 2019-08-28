package com.xyz.training.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.function.Supplier;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryTest {

    @Mock
    private Supplier<String> clock;
    private TransactionRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = new TransactionRepository(clock);
    }

    @Test
    public void shouldSaveDepositTransactions() throws Exception {
        Mockito.when(clock.get()).thenReturn("01/01/2019");
        repository.saveDeposit(1000);

        assertThat(repository.all().size(), is(1));
        assertThat(repository.all().get(0), is(transaction("01/01/2019", 1000)));
    }

    @Test
    public void shouldSaveWithdrawalTransactions() throws Exception {
        Mockito.when(clock.get()).thenReturn("01/01/2019");
        repository.saveWithdrawal(100);

        assertThat(repository.all().size(), is(1));
        assertThat(repository.all().get(0), is(transaction("01/01/2019", -100)));
    }

    private Transaction transaction(String date, int amount) {
        return new Transaction(date, amount);
    }
}