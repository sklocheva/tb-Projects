package main.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.Constants.Const;

public class FactoryTest {

	Factory factory;
	String output;

	@Before
	public void test() {
		factory = new Factory("BG", 1);
	}

	@Test
	public void testStandardInput() {
		output = factory.goToFactory("create car model=A5-hatchback engine=P-6L-T-euro3");
		Assert.assertEquals(Const.SUCCESS_ASSEMBLE_MESSAGE, output);
	}
}
