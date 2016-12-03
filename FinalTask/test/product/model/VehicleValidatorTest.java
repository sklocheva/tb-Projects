package product.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class VehicleValidatorTest {

	VehicleValidator validator;
	String[] output;
	
	@Before
	public void test() {
		validator = new VehicleValidator();
		
	}
	//test standard input
	@Test
	public void testStandardValidationInput() {
		String[] expected = {"car","A1", "hatchback"}; 
		output = validator.validateModel("car", "A1", "-hatchback");
		Assert.assertArrayEquals(expected, output);
	}
	
	@Test
	public void testStandardValidation2Input() {

		String[] expected = {"car","A1", "sedan"}; 
		output = validator.validateModel("car", "A1", "-sedan");
		Assert.assertArrayEquals(expected, output);
	}
	
	@Test
	public void testValidationWithoutTypeInput() {
		String[] expected = {"car","A1", "sedan"}; 
		output = validator.validateModel("car", "A1", null);
		Assert.assertArrayEquals(expected, output);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullModelInput() {
		output = validator.validateModel("car", null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWrongModelInput() {
		output = validator.validateModel("car", "cabrio", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWrongLabelInput() {
		output = validator.validateModel("truck", "sedan", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNoLabelInput() {
		output = validator.validateModel(null, null, null);
	}


}
