package product.transmission;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ManualTransTest {

	ManualTrans manTrans;
	String[] output;

	@Before
	public void test() {

	}

	// test standard input
	@Test
	public void testStandardWithoutDashInput() {

		String[] expected = { "Manual", "5" };
		manTrans = new ManualTrans("5");
		output = manTrans.validateProduct();
		Assert.assertArrayEquals(expected, output);
	}

	@Test
	public void testStandardWithDashInput() {

		String[] expected = { "Manual", "5" };
		manTrans = new ManualTrans("-5");
		output = manTrans.validateProduct();
		Assert.assertArrayEquals(expected, output);
	}

	@Test
	public void testNOInput() {

		String[] expected = { "Manual", "4" };
		manTrans = new ManualTrans(null);
		output = manTrans.validateProduct();
		Assert.assertArrayEquals(expected, output); // sets defalut
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInputOutOfSupported() {
		manTrans = new ManualTrans("8");
		manTrans.validateProduct();
	}

}
