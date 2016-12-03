package interpret.test.calculation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.calculate.addition.AddToNumber;

public class AddToNumberTest {

	private AddToNumber addNumbers;
	private String result;

	@Before
	public void test() {
		addNumbers = new AddToNumber();
	}

	@Test
	public void testStandardInput() {
		result = addNumbers.calc("5", "5");
		assertEquals("10", result);
	}

	@Test
	public void testNegativeNumberInput() {
		result = addNumbers.calc("-5", "5");
		assertEquals("0", result);
	}
	
	//already validated in SetCommand
	
//	@Test(expected = NumberFormatException.class)
//	public void testWrongFirstNumberInput() {
//		addNumbers.calc("skjd", "5");
//	}
//
//	@Test(expected = NumberFormatException.class)
//	public void testWrongSecondNumberInput() {
//		addNumbers.calc("5", "kjdd");
//	}
//
//	@Test(expected = NumberFormatException.class)
//	public void testWrongInput() {
//		addNumbers.calc("dfcs", "kjdd");
//	}

}
