package test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TransactionTest {

    private Transaction transaction;

    private Clock clock;

    private static final ZonedDateTime NOW = ZonedDateTime.of(
           2022,
            6,
            15,
            12,
            30,
            30,
            0,
            ZoneId.of("GMT")
    );

    @Before public void setup() {
        Clock clock = mock(Clock.class);
        when(clock.getZone()).thenReturn(NOW.getZone());
        when(clock.instant()).thenReturn(NOW.toInstant());

//        transaction = new Transaction(500, clock);
    }

    @Test
    public void testGetAmount() {
        assertEquals(Integer.valueOf(500), transaction.getAmount());
    }

    @Test
    public void testGetDate() {
        assertEquals(LocalDate.now(), transaction.getDate());
    }

    @Test
    public void testCredit() {
        assertEquals(LocalDate.now(), transaction.getDate());
    }
}