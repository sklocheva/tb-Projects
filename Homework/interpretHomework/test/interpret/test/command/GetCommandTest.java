package interpret.test.command;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interpret.command.access.CompoundValue;
import interpret.command.access.GetCommand;
import interpret.main.Constants.Messages;

public class GetCommandTest {

	private GetCommand get;
	private String result;
	private Map<String, CompoundValue> varmap;
	CompoundValue val;

	@Before
	public void test() {
		varmap = new HashMap<String, CompoundValue>();
		get = new GetCommand(varmap);
	}

	@Test
	public void testStandardInput() {
		val = new CompoundValue("string", "alice");
		varmap.put("humpty", val);
		result = get.execute("humpty");
		Assert.assertEquals("[string] alice", result);
	}

	@Test
	public void testWrongInput() {
		val = new CompoundValue("string", "alice");
		varmap.put("humpty", val);
		result = get.execute("test");
		Assert.assertEquals(Messages.WRONG_INPUT, result);
	}

	@Test
	public void testCapitalLetterInput() {
		val = new CompoundValue("string", "alice");
		varmap.put("humpty", val);
		result = get.execute("Humpty");
		Assert.assertEquals("[string] alice", result);
	}

}
