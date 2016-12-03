package interpret.test.calculation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.calculate.multiplication.MultiplyString;

public class MultiplyStringTest {

	private MultiplyString mulString;
	private String result;

	@Before
	public void test() {
		mulString = new MultiplyString();
	}

	@Test
	public void testStandardInput() {
		result = mulString.calc("alice", "5");
		assertEquals("alicealicealicealicealice", result);
	}

	@Test
	public void testMultipleWordInput() {
		result = mulString.calc("alice alice alice", "3");
		assertEquals("alice alice alicealice alice alicealice alice alice", result);
	}
	
	//already validated in SetCommand
	
//	@Test(expected = NumberFormatException.class)
//	public void testNotParsedNumber() {
//		mulString.calc("alice", "a");
//	}
}
