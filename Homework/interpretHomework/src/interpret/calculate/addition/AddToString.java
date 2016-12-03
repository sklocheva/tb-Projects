package interpret.calculate.addition;

import interpret.calculate.Calculate;

/**
 * AddToString class is used to concatenate two String values.
 * 
 * @author Sophia
 *
 */
public class AddToString implements Calculate {

	private static final String CALCULATEANDTYPE_NAME = "[string]+[string]";

	@Override
	public String getOperatorType() {
		return CALCULATEANDTYPE_NAME;
	}

	/**
	 * The method takes a String and a given value, concatenates the value to
	 * the end of the String and returns the resulted String.
	 * 
	 * @return String
	 */
	@Override
	public String calc(String string, String value) {
		return string.concat(value);
	}

}
