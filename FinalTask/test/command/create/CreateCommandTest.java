package command.create;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.Constants.Const;

public class CreateCommandTest {

	CreateCommand create;
	String output;

	@Before
	public void test() {
		create = new CreateCommand();

	}

	// test standard input
	@Test
	public void testStrandardWithoutTransmInput() {
		output = create.executeCommand("car model=A5-hatchback engine=P-6L-T-euro3");
		Assert.assertEquals(Const.SUCCESS_ASSEMBLE_MESSAGE, output);
	}

	@Test
	public void testStrandardWithTransmInput() {
		output = create.executeCommand("car model=A5 engine=P-8LT-euro5 transmission=Auto-5");
		Assert.assertEquals(Const.SUCCESS_ASSEMBLE_MESSAGE, output);
	}

	@Test
	public void testTransmissionWithOneInput() {
		output = create.executeCommand("car model=A5-hatchback engine=P-180hp-T-euro5 transmission=Auto");
		Assert.assertEquals(Const.SUCCESS_ASSEMBLE_MESSAGE, output);
	}

	@Test
	public void testElectricEngineWihtoutTransmInput() {
		output = create.executeCommand("car model=A5-hatchback engine=E");
		Assert.assertEquals(Const.SUCCESS_ASSEMBLE_MESSAGE, output);
	}

	@Test
	public void testElectricEngineWihtoutTransmValuesInput() {
		output = create.executeCommand("suv model=Q3-hatchback engine=E transmission=");
		Assert.assertEquals(Const.SUCCESS_ASSEMBLE_MESSAGE, output);
	}
	
	//test wrong input
	@Test
	public void testElectricEngineWithTransInput() {
		output = create.executeCommand("car model=A5-hatchback engine=E transmission=Auto-5");
		Assert.assertEquals(Const.ERROR_OUTPUT_MESSAGE, output);
	}
	
	@Test
	public void testInvalidCarModelInput() {
		output = create.executeCommand("car model=Q1-hatchback engine=E transmission=Auto-5");
		Assert.assertEquals(Const.ERROR_OUTPUT_MESSAGE, output);
	}
	
	@Test
	public void testMissingEngineTypeInput() {
		output = create.executeCommand("car model=A1-hatchback engine=-8LT-euro5 transmission=Auto-5");
		Assert.assertEquals(Const.ERROR_OUTPUT_MESSAGE, output);
	}

}
