package test;

import java.time.Clock;
import java.time.LocalDate;

abstract public class Transaction {
    private final Integer amount;
    private final LocalDate date;

    public Transaction(Integer amount, Clock clock) {
        this.amount = amount;
        this.date = LocalDate.now(clock);
    }

    public Integer getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
