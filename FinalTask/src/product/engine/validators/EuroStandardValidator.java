package product.engine.validators;

import java.util.ArrayList;
import java.util.Arrays;

import main.Constants.Const;

/**
 * 'EuroStandardValidator' class is used to find the euro standard in the input
 * and validate the value.
 * 
 * @author Sophia
 *
 */
public class EuroStandardValidator {

	String euroStandard;
	ArrayList<String> euroStandardArray = new ArrayList<>(Arrays.asList("euro3", "euro4", "euro5", "euro6"));

	/**
	 * 'validateEuroStandard' method is find the euro standard in the input, if
	 * it's present and validate the value.<br>
	 * <i>Euro standard</i> is an optional input for the engine, so if it isn't
	 * inputed - the defaults are set.
	 * 
	 * @param param
	 *            : all engine parameter that are inputed
	 * @return
	 * @throws IllegalArgumentException
	 *             : if the euro standard is not in the valid ones.
	 */
	public String validateEuroStandard(String param) throws IllegalArgumentException {

		if (param.contains(Const.EURO_LABEL)) {
			euroStandard = param.substring(param.lastIndexOf("-") + 1);
			if (euroStandardArray.contains(euroStandard)) {
				return euroStandard;
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			return Const.DEFAULT_EURO_STANDARD;
		}
	}
}
