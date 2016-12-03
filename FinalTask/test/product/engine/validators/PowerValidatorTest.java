package product.engine.validators;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PowerValidatorTest {

	PowerValidator validator;
	int output;

	@Before
	public void test() {
		validator = new PowerValidator();
	}

	// test standard input
	@Test
	public void testValidationWithLInput() {
		output = validator.validatePower("P-6L-T-euro5");
		Assert.assertEquals(510, output);
	}

	@Test
	public void testValidationWithLBiggestInput() {
		output = validator.validatePower("P-8L-T-euro5");
		Assert.assertEquals(736, output);
	}

	@Test
	public void testValidationWithHPInput() {
		output = validator.validatePower("P-180hp-T-euro5");
		Assert.assertEquals(134, output);
	}

	@Test
	public void testValidationHPRoundingInput() {
		output = validator.validatePower("P-130hp-T-euro5");
		Assert.assertEquals(97, output);
	}

	@Test
	public void testValidationHPRounding2Input() {
		output = validator.validatePower("P-200hp-T-euro5");
		Assert.assertEquals(149, output);
	}

	@Test
	public void testNoInput() {
		output = validator.validatePower("");
		Assert.assertEquals(0, output);
	}

	@Test
	public void testNoPowerInput() {
		output = validator.validatePower("P-euro5");
		Assert.assertEquals(0, output);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLOutOfSupportedInput() {
		validator.validatePower("P-7L-T-euro5");
	}

}
