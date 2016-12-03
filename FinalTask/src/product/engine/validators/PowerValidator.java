package product.engine.validators;

import java.util.HashMap;

import main.Constants.Const;

/**
 * The 'PowerValidator' class is used to validate any engine power input and
 * convert it to kilowatts. The input could be in horsepowers (hp) and in Liters
 * (L).
 * 
 * @author Sophia
 *
 */
public class PowerValidator {

	@SuppressWarnings("serial")
	HashMap<String, Integer> lToKW = new HashMap<String, Integer>() {
		{
			put("1", 74);
			put("2", 134);
			put("3", 245);
			put("4", 253);
			put("5", 331);
			put("6", 510);
			put("8", 736);
		}
	};

	private String value;

	/**
	 * <p>
	 * The method 'validatePower' is used to validate any engine power input and
	 * convert it to kilowatts. The input could be in horsepowers (hp) and in
	 * Liters (L).
	 * </p>
	 * <p>
	 * It receives the whole information about the engine and tries to find any
	 * input for the power - <i>hp</i> or in <i>L</i>.<br>
	 * * If it finds <i>hp</i> input, it tries to parse the <i>hp</i> value and
	 * convert it to <i>kw</i>.<br>
	 * * If it finds <i>L</i> input it checks if it's from the supported
	 * conversions and if it is - it returns the corresponding. <i>kW</i> value.
	 * <br>
	 * * If it doesn't find any input for the power, it returns 0, so the
	 * default can be set later on.
	 * </p>
	 * 
	 * @param param
	 *            : the whole engine input
	 * @return : int result from calculation or 0
	 * @throws IllegalArgumentException
	 *             : if input hp value is not a number or the L value is not in
	 *             the supported range of values.
	 */
	public int validatePower(String param) throws IllegalArgumentException {

		if (param.toLowerCase().contains(Const.HP_LABEL)) {
			// hptokwConverter
			value = param.substring(param.indexOf(Const.DASH_SEPARATOR) + 1, param.indexOf(Const.HP_LABEL));
			try {
				return (int) (Math.round(Integer.valueOf(value) * 0.7457));// example
																			// 180hp
				// = 134kW
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException();
			}
		} else if (param.toUpperCase().contains(Const.LITERS_LABEL)) {
			// ltokwConverter
			value = param.substring(param.indexOf(Const.DASH_SEPARATOR) + 1, param.indexOf(Const.LITERS_LABEL));
			try {
				return lToKW.get(value);
			} catch (NullPointerException e) {
				throw new IllegalArgumentException();
			}
		} else {
			return 0;
		}
	}

}
