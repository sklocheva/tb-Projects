package product.engine;

import org.junit.Assert;
import org.junit.Test;

public class ElectricEngineTest {

	ElectricEngine engine;
	String[] result;

	@Test
	public void testNoInput() {

		String[] output = {"E", "535", null, null};
		engine = new ElectricEngine(null);
		result = engine.validateProduct();
		Assert.assertArrayEquals(output, result);
	}

	//takes no parameters for now, so the param should be null.

//	@Test
//	public void testStandardHPInput() {
//
//		String[] output = {"E", "535", null, null};
//		engine = new ElectricEngine("717hp");
//		result = engine.validateProduct();
//		Assert.assertEquals("535", result);
//	}
//
//	@Test
//	public void testStandardKwInput() {
//
//		engine = new ElectricEngine("535kW");
//		result = engine.validateProduct();
//		Assert.assertEquals("535", result);
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void testWrongKwInput() {
//
//		engine = new ElectricEngine("550kW");
//		engine.validateProduct();
//	}

}
