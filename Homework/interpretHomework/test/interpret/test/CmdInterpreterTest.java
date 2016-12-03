package interpret.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interpret.main.CmdInterpreter;
import interpret.main.Constants.Messages;

public class CmdInterpreterTest {

	// NOT valid after refactoring, doesn't print-out anymore

	// private final ByteArrayOutputStream outContent = new
	// ByteArrayOutputStream();

	// private final String okOutput = Messages.OK_MESSAGE + "\r\n";
	// private final String errNoOperOutput = Messages.NO_OPER + "\r\n";
	// private final String errWrongInputOutput = Messages.WRONG_INPUT + "\r\n";

	private final String setStringInput = "set humpty string alice";
	private final String setNumberInput = "set temp number 5";
	private final String setDateInput = "set someDate date 2016-02-12";

	private final String getStringInput = "get humpty";
	private final String getNumberInput = "get temp";
	private final String getDateInput = "get someDate";

	private final String calcStringPlusNumberInput = "calc humpty humpty + temp";
	private final String calcDatePlusNumberInput = "calc someDate someDate + temp";

	private final String calcWrongDatePlusStringInput = "calc someDate someDate + humpty";

	private final String calcStringPlusNumberOutput = "[string] alice5";
	private final String calcDatePlusNumberOutput = "[date] 2016-02-17";

	private final String getStringOutput = "[string] alice";
	private final String getNumberOutput = "[number] 5";
	private final String getDateOutput = "[date] 2016-02-12";

	private final String noOperInput = "humpty number alice";
	private final String wrongTypeInputNumber = "set humpty number alice";
	private final String wrongTypeInputDate = "set humpty date 12-02-2016";

	CmdInterpreter cmdInterpreter;
	String result;

	@Before
	public void test() {
		// System.setOut(new PrintStream(outContent));
		cmdInterpreter = new CmdInterpreter();
	}

	// @After
	// public void cleanUpStreams() {
	// System.setOut(null);
	// }

	// set
	@Test
	public void testStringSetInput() {
		result = cmdInterpreter.processLine(setStringInput);
		Assert.assertEquals(Messages.OK_MESSAGE, result);
	}

	@Test
	public void testNumberSetInput() {
		result = cmdInterpreter.processLine(setNumberInput);
		Assert.assertEquals(Messages.OK_MESSAGE, result);
	}

	@Test
	public void testDateSetInput() {
		result = cmdInterpreter.processLine(setDateInput);
		Assert.assertEquals(Messages.OK_MESSAGE, result);
	}

	// get
	@Test
	public void testStringGetInput() {
		result = cmdInterpreter.processLine(getStringInput);
		Assert.assertEquals(getStringOutput, result);
	}

	@Test
	public void testNumberGetInput() {
		result = cmdInterpreter.processLine(getNumberInput);
		Assert.assertEquals(getNumberOutput, result);
	}

	@Test
	public void testDateGetInput() {
		result = cmdInterpreter.processLine(getDateInput);
		Assert.assertEquals(getDateOutput, result);
	}

	// calculations
	// calc
	@Test
	public void testCalcStringPlusNumber() {
		result = cmdInterpreter.processLine(calcStringPlusNumberInput);
		Assert.assertEquals(Messages.OK_MESSAGE, result);
		result = cmdInterpreter.processLine(getStringInput);
		Assert.assertEquals(calcStringPlusNumberOutput, result);
	}

	@Test
	public void testCalcDatePlusNumber() {
		result = cmdInterpreter.processLine(calcDatePlusNumberInput);
		// Assert.assertEquals(okOutput, outContent.toString());
		result = cmdInterpreter.processLine(getDateInput);
		Assert.assertEquals(calcDatePlusNumberOutput, result);
	}

	// wrong calculations
	@Test
	public void testWrongCalcDatePlusString() {
		result = cmdInterpreter.processLine(calcWrongDatePlusStringInput);
		Assert.assertEquals(Messages.NO_OPER, result);
	}

	// wrong inputs
	@Test
	public void testWrongOperation() {
		result = cmdInterpreter.processLine(noOperInput);
		Assert.assertEquals(Messages.NO_OPER, result);
	}

	// wrong types
	@Test
	public void testSetWrongTypeNumber() {
		result = cmdInterpreter.processLine(wrongTypeInputNumber);
		Assert.assertEquals(Messages.WRONG_INPUT, result);
	}

	@Test
	public void testSetWrongTypeDate() {
		result = cmdInterpreter.processLine(wrongTypeInputDate);
		Assert.assertEquals(Messages.WRONG_INPUT, result);
	}

}
