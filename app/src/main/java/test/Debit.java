package test;

import java.time.Clock;

public class Debit extends Transaction {
    private static Clock clock;
    public Debit(Integer amount) {
        super(amount, clock);
    }
}
