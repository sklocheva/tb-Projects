package interpret.test.calculation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.calculate.addition.AddDaysToDate;

public class AddDaysToDateTest {

	private AddDaysToDate add;
	private String result;

	@Before
	public void test() {
		add = new AddDaysToDate();
	}

	@Test
	public void testStandardParse() {
		result = add.calc("2016-02-12", "5");
		assertEquals("2016-02-17", result);
	}

	@Test
	public void testNegativeNumberAddition() {
		result = add.calc("2016-02-12", "-5");
		assertEquals("2016-02-07", result);
	}

	@Test
	public void testBigNumber() {
		result = add.calc("2016-02-12", "35");
		assertEquals("2016-03-18", result);
	}

	@Test
	public void testOneYear() {
		result = add.calc("2016-02-12", "365");
		assertEquals("2017-02-11", result);
	}
	
	//already validated in SetCommand
	
//	@Test(expected = NumberFormatException.class)
//	public void testWrongNumberParse() {
//		add.calc("2016-02-12", "sdgsa");
//	}
//
//	@Test
//	public void testWrongDateParse() {
//		result = add.calc("201602-12", "5");
//		assertNull(result);
//	}
//
//	@Test
//	public void testWrongDateFormat() {
//		result = add.calc("12-02-2016", "5");
//		assertNull(result);
//	}
}
