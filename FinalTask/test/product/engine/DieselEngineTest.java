package product.engine;

import org.junit.Assert;
import org.junit.Test;

public class DieselEngineTest {

	DieselEngine engine;
	String[] result;

	@Test
	public void testLWithoutTurboInput() {
		engine = new DieselEngine("-6L-euro5");
		String[] output = { "D", "510", null, "euro5" };
		result = engine.validateProduct();
		Assert.assertArrayEquals(output, result);
	}

	@Test
	public void testLWithTurboInput() {
		engine = new DieselEngine("-6L-T-euro5");
		String[] output = { "D", "663", "T", "euro5" };
		result = engine.validateProduct();
		Assert.assertArrayEquals(output, result);
	}

	@Test
	public void testLWithoutAnyInput() {
		engine = new DieselEngine(null);
		String[] output = { "D", "134", null, "euro3" };
		result = engine.validateProduct();
		Assert.assertArrayEquals(output, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLWrongLitersInput() {
		engine = new DieselEngine("-10L-T-euro5");
		result = engine.validateProduct();
	}

}
