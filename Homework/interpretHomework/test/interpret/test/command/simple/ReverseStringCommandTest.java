package interpret.test.command.simple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.command.simple.ReverseStringCommand;

public class ReverseStringCommandTest {

	private ReverseStringCommand command;
	private String output;

	@Before
	public void test() {
		command = new ReverseStringCommand();
	}

	@Test
	public void testOneWord() {
		output = command.execute("word");
		assertEquals("drow", output);
	}

	@Test
	public void testTwoWord() {
		output = command.execute("word word");
		assertEquals("drow drow", output);
	}
	
	@Test
	public void testNumbersInput() {
		output = command.execute("123456");
		assertEquals("654321", output);
	}

	@Test
	public void testSimpleSentence() {
		output = command
				.execute("Mama always said life was like a box of chocolates, you never know what youre gonna get.");
		assertEquals(".teg annog eruoy tahw wonk reven uoy ,setalocohc fo xob a ekil saw efil dias syawla amaM",
				output);
	}

	@Test
	public void testBigText() {
		output = command.execute("Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, "
				+ "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute "
				+ "irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
				+ "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit "
				+ "anim id est laborum.");
		assertEquals(
				".murobal tse di mina tillom tnuresed aiciffo iuq apluc ni tnus ,tnediorp non tatadipuc "
						+ "taceacco tnis ruetpecxE .rutairap allun taiguf ue erolod mullic esse tilev etatpulov ni "
						+ "tiredneherper ni rolod eruri etua siuD .tauqesnoc odommoc ae xe piuqila tu isin sirobal "
						+ "ocmallu noitaticrexe durtson siuq ,mainev minim da mine tU .auqila angam erolod te erobal "
						+ "tu tnudidicni ropmet domsuie od des ,tile gnicsipida rutetcesnoc ,tema tis rolod muspi meroL",
				output);
	}
}
