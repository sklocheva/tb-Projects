package interpret.test.command.simple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.command.simple.CountWordsCommand;

public class CountWordsCommandTest {

	private CountWordsCommand command;
	private String wordCount;

	@Before
	public void test() {
		command = new CountWordsCommand();
	}

	@Test
	public void testOneWord() {
		wordCount = command.execute("word");
		assertEquals("1", wordCount);
	}

	@Test
	public void testTwoWord() {
		wordCount = command.execute("word word");
		assertEquals("2", wordCount);
	}

	@Test
	public void testTabSpacing() {
		wordCount = command.execute("word	word");
		assertEquals("2", wordCount);
	}

	@Test
	public void testDoubleSpacing() {
		wordCount = command.execute("word  word");
		assertEquals("2", wordCount);
	}

	@Test
	public void testOnlySpacing() {
		wordCount = command.execute("   ");
		assertEquals("0", wordCount);
	}

	@Test
	public void testOnlyTab() {
		wordCount = command.execute("		");
		assertEquals("0", wordCount);
	}
	
	@Test
	public void testRandomPunctPosition() {
		wordCount = command.execute("word, word , word");
		assertEquals("3", wordCount);
	}
	
	@Test
	public void testBigText() {
		wordCount = command.execute("Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, "
				+ "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute "
				+ "irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
				+ "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit "
				+ "anim id est laborum.");
		assertEquals("69", wordCount);
	}

	@Test
	public void testSmallSentence() {
		wordCount = command
				.execute("Mama always said life was like a box of chocolates, you never know what youre gonna get.");
		assertEquals("17", wordCount);
	}
}
