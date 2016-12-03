package interpret.calculate.addition;

import interpret.calculate.Calculate;
import interpret.calculate.DateCalclulator;

/**
 * The AddDaysToDate class tries to add a number of days to a specific date.
 * 
 * @author Sophia
 *
 */
public class AddDaysToDate implements Calculate {

	private static final String CALCULATEANDTYPE_NAME = "[date]+[number]";
	private DateCalclulator dateParse;
	private int parsedNumber;

	@Override
	public String getOperatorType() {
		return CALCULATEANDTYPE_NAME;
	}

	/**
	 * The method takes a date and number of days both String, parses the number
	 * to integer and formats the date. Then it sends the two values to
	 * DateCalculator to add them.
	 * 
	 * @return String : the calculated date
	 */
	@Override
	public String calc(String date, String number) {
		dateParse = new DateCalclulator();
		parsedNumber = Integer.parseInt(number);

		return dateParse.calculateDate(date, parsedNumber);
	}

}
