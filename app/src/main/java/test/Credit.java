package test;

import java.time.Clock;

public class Credit extends Transaction {

    private static Clock clock;
    public Credit(Integer amount) {
        super(amount, clock);
    }
}
