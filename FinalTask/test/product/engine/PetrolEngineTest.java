package product.engine;

import org.junit.Assert;
import org.junit.Test;

public class PetrolEngineTest {

	PetrolEngine engine;
	String[] result;

	@Test
	public void testLWithoutTurboInput() {
		engine = new PetrolEngine("-6L-euro5");
		String[] output = { "P", "510", null, "euro5" };
		result = engine.validateProduct();
		Assert.assertArrayEquals(output, result);
	}

	@Test
	public void testLWithTurboInput() {
		engine = new PetrolEngine("-6L-T-euro5");
		String[] output = { "P", "663", "T", "euro5" };
		result = engine.validateProduct();
		Assert.assertArrayEquals(output, result);
	}
	
	@Test
	public void testLWithoutAnyInput() {
		engine = new PetrolEngine(null);
		String[] output = { "P", "74", null, "euro3" };
		result = engine.validateProduct();
		Assert.assertArrayEquals(output, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLWrongLitersInput() {
		engine = new PetrolEngine("-10L-T-euro5");
		result = engine.validateProduct();
	}


}
