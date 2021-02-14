package it.unibo.oop.lab.exception2;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {

	private static final int CONTO_INIZIALE = 10_000;
	
    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	final AccountHolder a1 = new AccountHolder("Carlo", "Suoli", 1);
    	final AccountHolder a2 = new AccountHolder("Anna", "Aiuia", 2);
    	
    	final StrictBankAccount s1 = new StrictBankAccount(a1.getUserID(), CONTO_INIZIALE, 10);
    	final StrictBankAccount s2 = new StrictBankAccount(a2.getUserID(), CONTO_INIZIALE, 10);
    	
    	s1.deposit(a1.getUserID(), 100);
    	s1.deposit(a2.getUserID(), 100);
    	
    	
    	
    	
    	
    }
}
