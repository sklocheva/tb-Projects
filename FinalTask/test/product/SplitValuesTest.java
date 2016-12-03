package product;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SplitValuesTest {

	SplitValues splitTrans;
	String[] output;
	
	@Before
	public void test() {
		splitTrans = new SplitValues();
	}
	
	//test standard input
	@Test
	public void testStandardAutoInput() {

		String[] expected = {"Auto","-4"};
		output = splitTrans.splitString("transmission=Auto-4");
		Assert.assertArrayEquals(expected, output);
	}

	@Test
	public void testStandardManInput() {

		String[] expected = {"Manual", "-6"};
		output = splitTrans.splitString("transmission=Manual-6");
		Assert.assertArrayEquals(expected, output);
	}
	
	@Test
	public void testWithoutGearInput() {

		String[] expected = {"Auto", null};
		output = splitTrans.splitString("transmission=Auto");
		Assert.assertArrayEquals(expected, output);
	}
	
	@Test
	public void testEngineStandardInput() {

		String[] expected = {"D", "-100hp-T-euro3"};
		output = splitTrans.splitString("engine=D-100hp-T-euro3");
		Assert.assertArrayEquals(expected, output);
	}
	
	@Test
	public void testEngineWithoutAllInputs() {

		String[] expected = {"D", "-100hp"};
		output = splitTrans.splitString("engine=D-100hp");
		Assert.assertArrayEquals(expected, output);
	}
	
	@Test
	public void testNoInput() {

		String[] expected = {"", null};
		output = splitTrans.splitString("engine=");
		Assert.assertArrayEquals(expected, output);
	}


}
