package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import it.unibs.ing.fp.groupX.medicalclinic.aviability.AvailabilityPeriod;
import it.unibs.ing.fp.groupX.medicalclinic.aviability.WeekDay;
import it.unibs.ing.fp.groupX.myutil.Utilities;
import junit.framework.Test;

public class AvailabilityPeriodTest {
	
	@org.junit.Test
	public void availabilityPeriodTest() throws Exception {
		AvailabilityPeriod p = new AvailabilityPeriod(Utilities.stringToDate("22/10/2014"), Utilities.stringToDate("25/10/2014"), Utilities.stringToTime("08:00:00"), Utilities.stringToTime("18:00:00"), null);
		
		assertEquals(true, p.compatibleWith(Utilities.stringToDate("22/10/2014"), Utilities.stringToTime("08:00:00")));
		assertEquals(true, p.compatibleWith(Utilities.stringToDate("22/10/2014"), Utilities.stringToTime("18:00:00")));
		
		assertEquals(true, p.compatibleWith(Utilities.stringToDate("23/10/2014"), Utilities.stringToTime("08:00:00")));
		assertEquals(true, p.compatibleWith(Utilities.stringToDate("23/10/2014"), Utilities.stringToTime("18:00:00")));
		
		assertEquals(true, p.compatibleWith(Utilities.stringToDate("25/10/2014"), Utilities.stringToTime("08:00:00")));
		assertEquals(true, p.compatibleWith(Utilities.stringToDate("25/10/2014"), Utilities.stringToTime("18:00:00")));
		
		assertEquals(false, p.compatibleWith(Utilities.stringToDate("22/10/2014"), Utilities.stringToTime("07:59:59")));
		assertEquals(false, p.compatibleWith(Utilities.stringToDate("25/10/2014"), Utilities.stringToTime("18:00:01")));
	
		List<WeekDay> wd = new ArrayList<>();
		
		wd.add(new WeekDay(0));
		wd.add(new WeekDay(2));
		wd.add(new WeekDay(4));
		
		AvailabilityPeriod p2 = new AvailabilityPeriod(Utilities.stringToDate("21/06/2015"), Utilities.stringToDate("28/06/2015"), Utilities.stringToTime("08:00:00"), Utilities.stringToTime("18:00:00"), null, wd);
		
		assertEquals(true, p2.compatibleWith(Utilities.stringToDate("21/06/2015"), Utilities.stringToTime("8:00:00")));
		assertEquals(false, p2.compatibleWith(Utilities.stringToDate("22/06/2015"), Utilities.stringToTime("8:00:00")));
		assertEquals(true, p2.compatibleWith(Utilities.stringToDate("23/06/2015"), Utilities.stringToTime("8:00:00")));
		assertEquals(false, p2.compatibleWith(Utilities.stringToDate("24/06/2015"), Utilities.stringToTime("8:00:00")));
		assertEquals(true, p2.compatibleWith(Utilities.stringToDate("25/06/2015"), Utilities.stringToTime("8:00:00")));
	}
}
