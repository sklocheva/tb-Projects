package interpret.test.calculation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.calculate.multiplication.MultiplyNumber;

public class MultiplyNumberTest {

	private MultiplyNumber mulNumber;
	private String result;

	@Before
	public void test() {
		mulNumber = new MultiplyNumber();
	}

	@Test
	public void testStandardInput() {
		result = mulNumber.calc("5", "5");
		assertEquals("25", result);
	}

	@Test
	public void testNegativeNumberInput() {
		result = mulNumber.calc("-5", "5");
		assertEquals("-25", result);
	}
	
	//already validated in SetCommand
	
//	@Test(expected = NumberFormatException.class)
//	public void testWrongFirstNumberInput() {
//		mulNumber.calc("skjd", "5");
//	}
//
//	@Test(expected = NumberFormatException.class)
//	public void testWrongSecondNumberInput() {
//		mulNumber.calc("5", "kjdd");
//	}
//
//	@Test(expected = NumberFormatException.class)
//	public void testWrongInput() {
//		mulNumber.calc("dfcs", "kjdd");
//	}

}
