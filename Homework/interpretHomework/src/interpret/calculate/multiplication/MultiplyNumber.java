package interpret.calculate.multiplication;

import interpret.calculate.Calculate;

/**
 * MultiplyNumber class is used to multiply two integers and to return a String
 * result.
 * 
 * @author Sophia
 *
 */
public class MultiplyNumber implements Calculate {

	private static final String CALCULATEANDTYPE_NAME = "[number]*[number]";
	
	private int parsedValue1;
	private int parsedValue2;

	@Override
	public String getOperatorType() {

		return CALCULATEANDTYPE_NAME;
	}

	/**
	 * The method from AddToNumber class takes two String values, parses them,
	 * multiplies them and returns the result.
	 * 
	 * @return String
	 */
	@Override
	public String calc(String number1, String number2) {
		parsedValue1 = Integer.parseInt(number1);
		parsedValue2 = Integer.parseInt(number2);

		return String.valueOf(parsedValue1 * parsedValue2);
	}

}
