package product.engine.validators;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurboValidatorTest {


	TurboValidator validator;
	String[] output;

	@Before
	public void test() {
		validator = new TurboValidator();
	}

	// test standard input
	@Test
	public void testHasTurboWithBracketsInput() {
		String[] expected = {"T","1.3"};
		output = validator.validateTurbo("P-100hp{T}-euro5");
		Assert.assertArrayEquals(expected, output);
	}
	
	@Test
	public void testHasTurboWithDashInput() {
		String[] expected = {"T","1.3"};
		output = validator.validateTurbo("P-100hp-T-euro5");
		Assert.assertArrayEquals(expected, output);
	}
	
	@Test
	public void testHasTurboWithoutSpacerInput() {
		String[] expected = {"T","1.3"};
		output = validator.validateTurbo("P-6LT-euro5");
		Assert.assertArrayEquals(expected, output);
	}
	
	@Test
	public void testNoTurboInput() {
		String[] expected = {null,"1"};
		output = validator.validateTurbo("P-100hp-euro5");
		Assert.assertArrayEquals(expected, output);
	}
	

}
