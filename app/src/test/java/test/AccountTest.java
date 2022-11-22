package test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matcher.*;

import static org.mockito.Mockito.*;

public class AccountTest {

    private Account account;

    @Before public void setup() {
        account = new Account();
    }

    @Test public void testDeposit() {


        Credit creditMock = mock(Credit.class);
        Credit expectedCredit = new Credit(500);


//        assertTrue(account.deposit(500), samePropertyValuesAs(expectedCredit));

//        assertEquals(expectedCredit, account.deposit(500));
    }

    @Test public void testGetBalanceAfterDeposit() {
        account.deposit(500);
        assertEquals(Integer.valueOf(500), account.getBalance());
    }

    @Test public void testGetBalanceAfterDepositAndWithdraw() {
        account.deposit(500);
        account.withdraw(250);
        assertEquals(Integer.valueOf(250), account.getBalance());
    }

//    @Test
//    public void testWithdraw() {
//        Debit expectedDebit = new Debit(250);
//        assertEquals(expectedDebit, account.withdraw(250));
//    }

    @Test public void testPrintBalance() {
        account.deposit(500);
        account.withdraw(250);
        assertEquals(String.valueOf("Current Balance: 250"), account.printBalance());
    }

    @Test public void testPrintStatementDeposit() {
//        DateTime today = DateTime.now();
        account.deposit(500);
//        account.withdraw(250);
        String expectedOutput = """
                        date || credit || debit || balance
                        17/11/22 || 500 || || 500
                        
                        """;
        assertEquals(expectedOutput, account.printStatement());
    }

    @Test public void testPrintStatementDepositAndWithdraw() {
//        DateTime today = DateTime.now();
        account.deposit(500);
        account.withdraw(250);
//        account.withdraw(250);
        String expectedOutput = """
                        date || credit || debit || balance
                        17/11/22 || 500 || || 500
                        17/11/22 || || 250 || 250
                        
                        """;
        assertEquals(expectedOutput, account.printStatement());
    }
}
