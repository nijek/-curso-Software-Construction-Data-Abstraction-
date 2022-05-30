package test;
import model.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateTest {
    Date testDate;
    @Before
    public void setUp() {
        testDate = new Date();
    }

    @Test
    public void testGetShortDates() {
        assertEquals(testDate.getDateShortForm(),"01/01/1970");
    }
    @Test
    public void testGetLongDate() {
        assertEquals(testDate.getDateLongForm(),"01 de janeiro de 1970");
    }
}
