package interpret.test.command.extension;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.command.extension.BinaryToDecimalCommand;
import interpret.main.Constants.Messages;

public class BinaryToDecimalCommandTest {

	BinaryToDecimalCommand command;
	private String output;

	@Before
	public void test() {
		command = new BinaryToDecimalCommand();
	}

	@Test
	public void testStandartInput() {
		output = command.execute("110010");
		assertEquals("50", output);
	}
	
	@Test
	public void testStringInput() {
		output = command.execute("ABC");
		assertEquals(Messages.VAL_NOT_PARSED, output);
	}
	
	@Test
	public void testNotBinaryInput() {
		output = command.execute("123568");
		assertEquals(Messages.VAL_NOT_PARSED, output);
	}
}
