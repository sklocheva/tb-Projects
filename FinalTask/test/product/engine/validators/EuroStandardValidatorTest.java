package product.engine.validators;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EuroStandardValidatorTest {

	EuroStandardValidator validator;
	String output;

	@Before
	public void test() {
		validator = new EuroStandardValidator();
	}

	// test standard input
	@Test
	public void testStandardValidationInput() {
		output = validator.validateEuroStandard("P-100hp-T-euro5");
		Assert.assertEquals("euro5", output);
	}

	@Test
	public void testTwoInputs() {
		output = validator.validateEuroStandard("-100hp-euro5");
		Assert.assertEquals("euro5", output);
	}

	@Test
	public void testWithoutEuroInput() {
		output = validator.validateEuroStandard("-100hp");
		Assert.assertEquals("euro3", output);
	}

	@Test
	public void testWithoutAnyInput() {
		output = validator.validateEuroStandard("");
		Assert.assertEquals("euro3", output);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWrongInput() {
		validator.validateEuroStandard("-100hp-euro8");
	}
}
