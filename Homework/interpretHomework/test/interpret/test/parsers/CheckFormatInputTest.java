package interpret.test.parsers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpret.validation.CheckFormatInput;

public class CheckFormatInputTest {
	private CheckFormatInput validate;
	private boolean result;
	private String[] inputString;
	private String[] inputNumber;
	private String[] inputDate;
	private String[] inputInvalid;

	@Before
	public void test() {
		validate = new CheckFormatInput();

		inputString = new String[]{"humpty", "string", "alice"};
		inputNumber = new String[]{"temp", "number", "5"};
		inputDate = new String[]{"someDate", "date", "2016-02-12"};
	}
	
	//test standard inputs
	@Test
	public void testStandardStringInput() {

		result = validate.validateInput(inputNumber);
		assertTrue(result);
	}
	
	@Test
	public void testStandardNumberInput() {

		result = validate.validateInput(inputString);
		assertTrue(result);
	}
	
	@Test
	public void testStandardDateInput() {

		result = validate.validateInput(inputDate);
		assertTrue(result);
	}
	
	//test invalid inputs
	@Test
	public void testInvalidNumberOfInputs() {
		inputInvalid = new String[]{"word", "date", "2016-02-12", "word"};
		result = validate.validateInput(inputInvalid);
		assertFalse(result);
	}
	
	@Test
	public void testNumberCannotParseInputs() {
		inputInvalid = new String[]{"temp", "number", "word"};
		result = validate.validateInput(inputInvalid);
		assertFalse(result);
	}
	
	@Test
	public void testDateCannotFormatInputs() {
		inputInvalid = new String[]{"someDate", "date", "12-02-2016"};
		result = validate.validateInput(inputInvalid);
		assertFalse(result);
	}
	
	@Test
	public void testInvalidType() {
		inputInvalid = new String[]{"someDate", "number", "12-02-2016"};
		result = validate.validateInput(inputInvalid);
		assertFalse(result);
	}
}
