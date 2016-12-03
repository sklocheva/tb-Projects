package interpret.test.command.simple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.command.simple.ReverseWordsCommand;

public class ReverseWordsCommandTest {

	private ReverseWordsCommand command;
	private String output;

	@Before
	public void test() {
		command = new ReverseWordsCommand();
	}

	@Test
	public void testTwoWords() {
		output = command.execute("word word2");
		assertEquals("word2 word", output);
	}

	@Test
	public void testTwoWordsTabSpacing() {
		output = command.execute("word	word2");
		assertEquals("word2 word", output);
	}

	@Test
	public void testTwoWordsMultipleSpacing() {
		output = command.execute("word   word2");
		assertEquals("word2 word", output);
	}

	@Test
	public void testSimpleSentence() {
		output = command
				.execute("Mama always said life was like a box of chocolates, you never know what youre gonna get.");
		assertEquals(".get gonna youre what know never you ,chocolates of box a like was life said always Mama",
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
				".laborum est id anim mollit deserunt officia qui culpa in sunt ,proident non cupidatat occaecat "
				+ "sint Excepteur .pariatur nulla fugiat eu dolore cillum esse velit voluptate in reprehenderit "
				+ "in dolor irure aute Duis .consequat commodo ea ex aliquip ut nisi laboris ullamco exercitation "
				+ "nostrud quis ,veniam minim ad enim Ut .aliqua magna dolore et labore ut incididunt tempor "
				+ "eiusmod do sed ,elit adipiscing consectetur ,amet sit dolor ipsum Lorem",
				output);
	}
}
