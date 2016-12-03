package product.transmission;

import org.junit.Assert;
import org.junit.Test;

public class AutoTransTest {

	AutoTrans autoTrans;
	String[] output;

	// test standard input
	@Test
	public void testStandardWithDashInput() {

		String[] expected = {"Auto", "5"};
		autoTrans = new AutoTrans("-5");
		output = autoTrans.validateProduct();
		Assert.assertArrayEquals(expected, output);
	}
	
	@Test
	public void testStandardWithoutDashInput() {

		String[] expected = {"Auto", "5"};
		autoTrans = new AutoTrans("5");
		output = autoTrans.validateProduct();
		Assert.assertArrayEquals(expected, output);
	}

	@Test
	public void testNoInput() {

		String[] expected = {"Auto", "4"};
		autoTrans = new AutoTrans(null);
		output = autoTrans.validateProduct();
		Assert.assertArrayEquals(expected, output);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInputOutOfSupported() {
		autoTrans = new AutoTrans("10");
		autoTrans.validateProduct();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWrongInput() {
		autoTrans = new AutoTrans("text");
		autoTrans.validateProduct();
	}

}
