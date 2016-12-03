package interpret.validation;

import interpret.calculate.DateCalclulator;
import interpret.main.Constants.Types;

/**
 * The InputValidation class validates an array of three inputs.
 * 
 * @author Sophia
 *
 */
public class CheckFormatInput {
	private DateCalclulator parseDate;
	private TryParseValue parseInt;

	public CheckFormatInput() {
		parseDate = new DateCalclulator();
		parseInt = new TryParseValue();
	}

	/**
	 * <br>
	 * The method validateInput validates an array of three values of the
	 * format: key type value.</br>
	 * <br>
	 * The method checks if all three of the values are in the array and if the
	 * given type value is from the supported types. It tries to format the
	 * value to that type and returns a positive result if it's successful.</br>
	 * 
	 * @param inputArr
	 *            an array of the values: key type value
	 * @return boolean
	 */
	public boolean validateInput(String[] inputArr) {

		if (inputArr.length == 3) {
			switch (inputArr[1].toLowerCase()) {
			case Types.TYPE_DATE:
				try {
					parseDate.calculateDate(inputArr[2], 0).equals(null);
					return true;
				} catch (NullPointerException e) {
					return false;
				}
			case Types.TYPE_NUMBER:
				return parseInt.parseValue(inputArr[2]);
			case Types.TYPE_STRING:
				return true;
			default:
				return false;
			}
		} else {
			return false;
		}
	}

}
