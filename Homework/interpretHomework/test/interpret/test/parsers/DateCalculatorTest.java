package interpret.test.parsers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.calculate.DateCalclulator;

public class DateCalculatorTest {

	private DateCalclulator parse;

	@Before
	public void test() {
		parse = new DateCalclulator();
	}

	@Test
	public void testStandardParse() {
		String result = parse.calculateDate("2016-02-12", 5);
		assertEquals("2016-02-17", result);
	}

	@Test
	public void testWrongParse() {
		String result = parse.calculateDate("201602-12", 5);
		assertNull(result);
	}

	@Test
	public void testWrongFormat() {
		String result = parse.calculateDate("12-02-2016", 5);
		assertNull(result);
	}
}
