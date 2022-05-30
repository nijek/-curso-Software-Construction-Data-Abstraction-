package test;

import model.Time;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TimeTest {
    Time testTime;
    @Before
    public void setUp() {
        testTime = new Time();
    }
    @Test
    public void testConstructors() {
        Time t1 = new Time();
        Time t2 = new Time(11,30,45);
        Time t3 = new Time(11, 30, 45, "AM");

        assertEquals(t1.getTime(), "00:00:00");
        assertEquals(t2.getTime(), "11:30:45");
        assertEquals(t3.getTime(), "11:30:45 AM");

        assertEquals(t1.getRegularTime(), "00:00:00");
        assertEquals(t2.getRegularTime(), "11:30:45");
        assertEquals(t3.getRegularTime(), "11:30:45");

        assertEquals(t1.getAmPmTime(), "00:00:00 AM");
        assertEquals(t2.getAmPmTime(), "11:30:45 AM");
        assertEquals(t3.getAmPmTime(), "11:30:45 AM");

    }
    @Test
    public void testChangeAmPm() {
        testTime.set(12, 00, 00, "AM");
        testTime.changeToRegular();
        assertEquals(testTime.getTime(), "12:00:00");

        testTime.set(12, 00, 00, "PM");
        testTime.changeToRegular();
        assertEquals(testTime.getTime(), "00:00:00");

        testTime.set(11, 40, 40, "PM");
        testTime.changeToRegular();
        assertEquals(testTime.getTime(), "23:40:40");

        testTime.set(12, 00, 00);
        testTime.changeToAmPm();
        assertEquals(testTime.getTime(), "12:00:00 AM");

        testTime.set(00, 00, 00);
        testTime.changeToAmPm();
        assertEquals(testTime.getTime(), "00:00:00 AM");

        testTime.set(23,40,40);
        testTime.changeToAmPm();
        assertEquals(testTime.getTime(), "11:40:40 PM");
    }


}
