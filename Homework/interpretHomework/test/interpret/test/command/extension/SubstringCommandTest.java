package interpret.test.command.extension;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.command.extension.SubstringCommand;
import interpret.main.Constants.Messages;


public class SubstringCommandTest {
	
	SubstringCommand command;
	private String output;

	@Before
	public void test() {
		command = new SubstringCommand();
	}
	
	@Test
	public void testStandartInput() {
		output = command.execute("wordwordword word");
		assertEquals(Messages.CONATAINS_YES, output);
	}
	
	@Test
	public void testDoesNotContan() {
		output = command.execute("wordwordword word2");
		assertEquals(Messages.CONATAINS_NO, output);
	}
	
	@Test
	public void testMultipleSpaceInput() {
		output = command.execute("wordwordword     word");
		assertEquals(Messages.CONATAINS_YES, output);
	}

}
