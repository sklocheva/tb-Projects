package product;

import main.Constants.Const;

/**
 * The 'SplitValues' class is used to split values into first - mandatory -
 * value and a second one that contains the rest of the information.
 * 
 * @author Sophia
 *
 */
public class SplitValues {

	String[] returnValues;
	String transmissions;

	/**
	 * 'SplitValues' method takes a the inputs of the parts of the vehicle,
	 * separates the values from the intro part (for example: 'transmission=').
	 * Then tries to extract the first value which is mandatory. If his value
	 * doesn't exist, it stores an empty string into it to be caught as an
	 * invalid value later on.<br>
	 * If the optional values are not in the input - it set a null to it, again,
	 * to be validated later on.
	 * 
	 * @param value
	 * @return : a String array of two values
	 */
	public String[] splitString(String value) {

		returnValues = new String[2];
		transmissions = value.substring(value.indexOf(Const.EQUALS_SEPARATOR) + 1);
		try {
			returnValues[0] = transmissions.substring(0, transmissions.indexOf(Const.DASH_SEPARATOR));
			returnValues[1] = transmissions.substring(transmissions.indexOf(Const.DASH_SEPARATOR));

			return returnValues;

		} catch (StringIndexOutOfBoundsException e) {

			returnValues[0] = transmissions;
			returnValues[1] = null;
			return returnValues;
		}
	}
}
