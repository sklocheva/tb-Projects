package command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindCommandTest {

	FindCommand findCommand;
	String output;

	@Before
	public void test() {
		findCommand = new FindCommand();
	}

	@Test
	public void testStandardInput() {
		output = findCommand.executeCommand("BG4TTBYaVbGyKpeJl");
		Assert.assertEquals(
				"vin               | model | type       | engine           | transmission | isDisas   \r\n"
						+ "BG4TTBYaVbGyKpeJl | Q5    | sedan      | P-1282hpT-euro5  | Auto-5       | true      \r\n",
				output);
	}
}
