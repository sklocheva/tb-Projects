package interpret.validation;

/**
 * ValueParser class tries to parse a String to an integer.
 * 
 * @author Sophia
 *
 */
public class TryParseValue {
	/**
	 * TryParseValue class checks if a String can be parsed to integer.
	 * 
	 * @return boolean
	 * @param number
	 *            : the String that needs to be parsed.
	 */
	public boolean parseValue(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
