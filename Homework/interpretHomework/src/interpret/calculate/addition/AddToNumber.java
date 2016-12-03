package interpret.calculate.addition;

import interpret.calculate.Calculate;

/**
 * AddToNumber class is used to add two integers together and return a String result.
 * 
 * @author Sophia
 *
 */
public class AddToNumber implements Calculate {

	private static final String CALCULATEANDTYPE_NAME = "[number]+[number]";
	private int parsedNumber1;
	private int parsedNumber2;

	@Override
	public String getOperatorType() {
		return CALCULATEANDTYPE_NAME;
	}

	/**
	 * The method from AddToNumber class takes two String values, parses them,
	 * adds them together and returns the result.
	 * 
	 * @return String
	 */
	@Override
	public String calc(String number1, String number2) {
		parsedNumber1 = Integer.parseInt(number1);
		parsedNumber2 = Integer.parseInt(number2);
		
		return String.valueOf(parsedNumber1 + parsedNumber2);
	}

}
