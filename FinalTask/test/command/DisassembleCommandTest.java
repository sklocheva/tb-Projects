package command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.Constants.Const;


public class DisassembleCommandTest {

	DisassembleCommand disassembleCommand;
	String output;

	@Before
	public void test() {
		disassembleCommand = new DisassembleCommand();
	}
	//INPUT: any already generated and not disassembled VIN number
	
//	@Test
//	public void testStandardInput() {
//		output = disassembleCommand.executeCommand("BG4TTBYaVbGyKpeJl");
//		Assert.assertEquals(Const.SUCCESS_DISASSEMBLE_MESSAGE, output);
//	}
	
	@Test
	public void testAlreadyDisassembledInput() {
		output = disassembleCommand.executeCommand("BG4XJDdhhA4fs8gRJ");
		Assert.assertEquals(Const.DISASSEMBLED_ALREADY, output);
	}
	
	@Test
	public void testNotRealVINInput() {
		output = disassembleCommand.executeCommand("some_VIN");
		Assert.assertEquals(Const.VIN_NOT_FOUND_MESSAGE, output);
	}

}
