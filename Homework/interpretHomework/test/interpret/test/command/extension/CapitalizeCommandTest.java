package interpret.test.command.extension;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.command.extension.CapitalizeCommand;

public class CapitalizeCommandTest {

	CapitalizeCommand command;
	private String output;

	@Before
	public void test() {
		command = new CapitalizeCommand();
	}
	
	@Test
	public void testStandartInput() {
		output = command.execute("word");
		assertEquals("WORD", output);
	}
}
