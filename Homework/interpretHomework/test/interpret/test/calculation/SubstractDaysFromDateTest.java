package interpret.test.calculation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.calculate.subtraction.SubtractDaysFromDate;

public class SubstractDaysFromDateTest {

	private SubtractDaysFromDate subtract;
	private String result;

	@Before
	public void test() {
		subtract = new SubtractDaysFromDate();
	}

	@Test
	public void testStandardParse() {
		result = subtract.calc("2016-02-12", "5");
		assertEquals("2016-02-07", result);
	}

	@Test
	public void testNegativeNumberAddition() {
		result = subtract.calc("2016-02-12", "-5");
		assertEquals("2016-02-17", result);
	}

	@Test
	public void testBigNumber() {
		result = subtract.calc("2016-02-12", "35");
		assertEquals("2016-01-08", result);
	}

	@Test
	public void testOneYear() {
		result = subtract.calc("2016-02-12", "365");
		assertEquals("2015-02-12", result);
	}
	
}
