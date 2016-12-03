package interpret.test.command;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interpret.command.access.CompoundValue;
import interpret.command.access.SetCommand;
import interpret.main.Constants;

public class SetCommandTest {

	private SetCommand set;
	private String result;
	private Map<String, CompoundValue> varmap;

	@Before
	public void test() {
		varmap = new HashMap<String, CompoundValue>();
		set = new SetCommand(varmap);
	}	
		
	@Test
	public void testStandardInput() {
		String output = set.execute("humpty string alice");
		result = varmap.get("humpty").toString();
		Assert.assertEquals("[string] alice", result);
		Assert.assertEquals(Constants.Messages.OK_MESSAGE, output);
	}
	
	@Test
	public void testStandardDateInput() {
		String output = set.execute("date1 date 2016-02-12");
		result = varmap.get("date1").toString();
		Assert.assertEquals("[date] 2016-02-12", result);
		Assert.assertEquals(Constants.Messages.OK_MESSAGE, output);
	}
		
		//test spacing
	@Test
	public void testTabSpacing() {
		String output = set.execute("humpty	string	alice");
		result = varmap.get("humpty").toString();
		Assert.assertEquals("[string] alice", result);
		Assert.assertEquals(Constants.Messages.OK_MESSAGE, output);
	}

	@Test
	public void testSomeSpacing() {
		String output = set.execute("humpty  	string	  	alice	");
		result = varmap.get("humpty").toString();
		Assert.assertEquals("[string] alice", result);
		Assert.assertEquals(Constants.Messages.OK_MESSAGE, output);
	}
		
		//test more and less than 3 inputs
	@Test
	public void testTooManyValues() {
		String output = set.execute("humpty string alice t n kjb k");
		Assert.assertEquals(Constants.Messages.WRONG_INPUT, output);
	}

	@Test
	public void testEmptyValue() {
		result = set.execute("humpty");
		Assert.assertEquals(Constants.Messages.WRONG_INPUT, result);
	}

	@Test
	public void testEmptyValuePlusSpace() {
		result = set.execute("humpty ");
		Assert.assertEquals(Constants.Messages.WRONG_INPUT, result);
	}

	@Test
	public void testEmptyValuePlusMultipleSpace() {
		result = set.execute("humpty   ");
		Assert.assertEquals(Constants.Messages.WRONG_INPUT, result);
	}

	@Test
	public void testEmptyInput() {
		result = set.execute("");
		Assert.assertEquals(Constants.Messages.WRONG_INPUT, result);
	}
	
	@Test
	public void testTypeCapital() {
		result = set.execute("humpty Number 5");
		Assert.assertEquals(Constants.Messages.OK_MESSAGE, result);
	}
	
		//test invalid types: only string, number and date permitted
	@Test
	public void testInvalidType() {
		result = set.execute("humpty dasy alice");
		Assert.assertEquals(Constants.Messages.WRONG_INPUT, result);
	}
	

		//test if values correspond to the given type
	@Test
	public void testInvalidValueType() {
		result = set.execute("humpty number alice");
		Assert.assertEquals(Constants.Messages.WRONG_INPUT, result);
	}
	
	@Test
	public void testInvalidDateFormat() {
		result = set.execute("humpty date 10-12-1000");
		Assert.assertEquals(Constants.Messages.WRONG_INPUT, result);
	}
	
	@Test
	public void testInvalidDateFormat2() {
		result = set.execute("humpty date 201602-12");
		Assert.assertEquals(Constants.Messages.WRONG_INPUT, result);
	}
	
	@Test
	public void testTypeNumberValueDate() {
		result = set.execute("humpty number 2016-02-12");
		Assert.assertEquals(Constants.Messages.WRONG_INPUT, result);
	}
}
