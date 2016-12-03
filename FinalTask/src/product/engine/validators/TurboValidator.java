package product.engine.validators;

import main.Constants.Const;

public class TurboValidator {

	String[] returnValues = new String[2];

	public String[] validateTurbo(String param) {

		if (param.toUpperCase().contains(Const.TURBO_LABEL)) {

			returnValues[0] = Const.TURBO_LABEL;
			returnValues[1] = Const.HAS_TURBO_MULTIPLIER;
		} else {
			returnValues[0] = null;
			returnValues[1] = Const.NO_TURBO_MULTIPLIER;
		}
		return returnValues;
	}

}
