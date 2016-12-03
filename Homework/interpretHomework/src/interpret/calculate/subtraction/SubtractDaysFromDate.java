package interpret.calculate.subtraction;

import interpret.calculate.Calculate;
import interpret.calculate.DateCalclulator;

/**
 * The SubtractDaysFromDate class tries to subtract a number of days from a
 * specific date.
 * 
 * @author Sophia
 *
 */
public class SubtractDaysFromDate implements Calculate {

	private static final String CALCULATEANDTYPE_NAME = "[date]-[number]";
	
	private DateCalclulator dateParse;
	private int parsedNumber;

	@Override
	public String getOperatorType() {
		return CALCULATEANDTYPE_NAME;
	}

	/**
	 * The method takes a date and number of days both in String type, tries to
	 * parse the number to integer and format the date. It turns the parsed number to
	 * negative and sends the two values to DateCalculator for calculation.
	 * 
	 * @return String : the calculated date
	 */
	@Override
	public String calc(String date, String number) {

		dateParse = new DateCalclulator();
		parsedNumber = Integer.parseInt(number);

		return dateParse.calculateDate(date, parsedNumber * (-1));
	}

}
