package interpret.test.calculation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.calculate.subtraction.SubtractFromNumber;

public class SubtractFromNumberTest {

	private SubtractFromNumber subtractNumbers;
	private String result;

	@Before
	public void test() {
		subtractNumbers = new SubtractFromNumber();
	}

	@Test
	public void testStandardInput() {
		result = subtractNumbers.calc("5", "5");
		assertEquals("0", result);
	}

	@Test
	public void testNegativeNumberInput() {
		result = subtractNumbers.calc("-5", "5");
		assertEquals("-10", result);
	}

	@Test
	public void testNegativeNumberInput2() {
		result = subtractNumbers.calc("-5", "-5");
		assertEquals("0", result);
	}
	
	//already validated in SetCommand
	
//	@Test(expected = NumberFormatException.class)
//	public void testWrongFirstNumberInput() {
//		subtractNumbers.calc("skjd", "5");
//	}
//
//	@Test(expected = NumberFormatException.class)
//	public void testWrongSecondNumberInput() {
//		subtractNumbers.calc("5", "kjdd");
//	}
//
//	@Test(expected = NumberFormatException.class)
//	public void testWrongInput() {
//		subtractNumbers.calc("dfcs", "kjdd");
//	}
}
