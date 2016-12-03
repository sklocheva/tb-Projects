package interpret.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interpret.calculate.CalcCommand;
import interpret.command.access.CompoundValue;
import interpret.main.Constants;

public class CalcCommandTest {

	private CalcCommand calc;
	private String result;
	private String output;
	private Map<String, CompoundValue> varmap;

	@Before
	public void test() {
		
		varmap = new HashMap<String, CompoundValue>();
		calc = new CalcCommand(varmap);
		
		CompoundValue valString = new CompoundValue("string", "alice");
		CompoundValue valNumber = new CompoundValue("number", "5");
		CompoundValue valDate = new CompoundValue("date", "2016-02-12");

		varmap.put("humpty", valString);
		varmap.put("temp", valNumber);
		varmap.put("someDate", valDate);
	}
	
	//test standard input
	@Test
	public void testStringPlusNumberInput() {
		output = calc.execute("humpty humpty + temp");
		result = varmap.get("humpty").toString();
		Assert.assertEquals("[string] alice5", result);
		Assert.assertEquals(Constants.Messages.OK_MESSAGE, output);
	}
	
	@Test
	public void testStringPlusStringInput() {
		output = calc.execute("humpty humpty + humpty");
		result = varmap.get("humpty").toString();
		Assert.assertEquals("[string] alicealice", result);
		Assert.assertEquals(Constants.Messages.OK_MESSAGE, output);
	}
	
		
	@Test
	public void testNumberPlusNumberInput() {
		output = calc.execute("temp temp + temp");
		result = varmap.get("temp").toString();
		Assert.assertEquals("[number] 10", result);
		Assert.assertEquals(Constants.Messages.OK_MESSAGE, output);
	}	
	
	@Test
	public void testNumberMinusNumberInput() {
		output = calc.execute("temp temp - temp");
		result = varmap.get("temp").toString();
		Assert.assertEquals("[number] 0", result);
		Assert.assertEquals(Constants.Messages.OK_MESSAGE, output);
	}
	
	@Test
	public void testNumberMultiNumberInput() {
		output = calc.execute("temp temp * temp");
		result = varmap.get("temp").toString();
		Assert.assertEquals("[number] 25", result);
		Assert.assertEquals(Constants.Messages.OK_MESSAGE, output);
	}
	
	@Test
	public void testStringMultiNumberInput() {
		output = calc.execute("humpty humpty * temp");
		result = varmap.get("humpty").toString();
		Assert.assertEquals("[string] alicealicealicealicealice", result);
		Assert.assertEquals(Constants.Messages.OK_MESSAGE, output);
	}
	
	//invalid operations
	@Test
	public void testStringPlusDateInput() {
		output = calc.execute("humpty humpty + someDate");
		Assert.assertEquals(Constants.Messages.NO_OPER, output);
	}
	
	@Test
	public void testStringMinusNumberInput() {
		output = calc.execute("humpty humpty - temp");
		Assert.assertEquals(Constants.Messages.NO_OPER, output);
	}
	
	@Test
	public void testDatePlusStringInput() {
		output = calc.execute("someDate someDate + humpty");
		Assert.assertEquals(Constants.Messages.NO_OPER, output);
	}
}