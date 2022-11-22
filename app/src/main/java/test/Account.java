package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class Account {

    private ArrayList<Transaction> transactions = new ArrayList<>();
    private Integer balance = 0;

//    private Credit creditClass;
//    private Debit debitClass;

//    public Account(Credit creditClass, Debit debitClass) {
//        this.creditClass = creditClass;
//        this.debitClass = debitClass;
//    }
    public Credit deposit(Integer amount) {
        Credit credit = new Credit(amount);
        transactions.add(credit);
        return credit;
    }

    public Debit withdraw(Integer amount) {
        Debit debit = new Debit(amount);
        transactions.add(debit);
        return debit;
    }

    public Integer getBalance() {
        Integer balance = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getClass() == Credit.class) {
                balance += transaction.getAmount();
            } else {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }

    public String printBalance() {
        return String.format("Current Balance: %d", getBalance());
    }

    public String printStatement() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

        StringBuilder output = new StringBuilder("date || credit || debit || balance\n");

        // need to reverse transactions array to show most recent transaction first

        for (Transaction transaction : transactions) {
            String date = formatter.format(transaction.getDate());

            if (transaction.getClass() == Credit.class) {
                output.append(String.format("%s || %d || || %d%n", date, transaction.getAmount(), getBalance()));
            } else {
                output.append(String.format("%s || || %d || %d%n", date, transaction.getAmount(), getBalance()));
            }


        }

        return output.toString();
    }

}
