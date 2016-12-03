package interpret.calculate.multiplication;

import interpret.calculate.Calculate;

/**
 * MultiplyString class is used to repeat a String value a number of times.
 * 
 * @author Sophia
 *
 */
public class MultiplyString implements Calculate {

	private static final String CALCULATEANDTYPE_NAME = "[string]*[number]";
	
	private StringBuffer conString;
	private int parsedValue;
	

	@Override
	public String getOperatorType() {
		return CALCULATEANDTYPE_NAME;
	}

	/**
	 * <br>
	 * The method takes a string and a number. 
	 * It repeats the string a number of times.</br>
	 * 
	 * @param string
	 *            : the String value that need to be repeated
	 * @param number
	 *            : indicates how many time string needs to be repeated
	 */
	@Override
	public String calc(String string, String number) {

		conString = new StringBuffer();
		parsedValue = Integer.parseInt(number);

		for (int i = parsedValue; i > 0; i--) {
			conString.append(string);
		}

		return conString.toString();
	}

}
