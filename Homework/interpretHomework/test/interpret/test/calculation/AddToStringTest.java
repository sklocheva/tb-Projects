package interpret.test.calculation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.calculate.addition.AddToString;

public class AddToStringTest {

	private AddToString addString;
	private String result;

	@Before
	public void test() {
		addString = new AddToString();
	}

	@Test
	public void testStandardInput() {
		result = addString.calc("alice", "5");
		assertEquals("alice5", result);
	}

	@Test
	public void testStandardInput2() {
		result = addString.calc("10", "5");
		assertEquals("105", result);
	}

	@Test
	public void testStandardInput3() {
		result = addString.calc("humpty", "dumpty");
		assertEquals("humptydumpty", result);
	}

}
