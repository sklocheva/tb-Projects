package product.engine;

import java.util.ArrayList;
import java.util.Arrays;

import main.Constants.Const;
import product.ProductValidationPlan;
import product.engine.validators.EuroStandardValidator;
import product.engine.validators.PowerValidator;
import product.engine.validators.TurboValidator;

/**
 * The 'PetrolEngine' class is a specific engine class which takes the
 * parameters inputed after the engine type specification and validates/converts
 * them.
 * 
 * @author Sophia
 *
 */
public class PetrolEngine implements ProductValidationPlan {

	ArrayList<Integer> kwArray = new ArrayList<>(Arrays.asList(74, 134, 245, 253, 331, 510, 736));

	PowerValidator powerVal;
	TurboValidator turboVal;
	EuroStandardValidator euroVal;

	private String param;
	private String[] result = new String[4];

	private int power;
	String[] turboResults;
	private double addTurboToPower;

	public PetrolEngine(String param) {
		this.param = param;
		euroVal = new EuroStandardValidator();
		turboVal = new TurboValidator();
		powerVal = new PowerValidator();
	}

	/**
	 * The method takes it's parameters inputed after the engine type
	 * specification and tries to validate it's euro validation, check if
	 * there's turbo or not and convert the power value, and add turbo to it if
	 * present.
	 * 
	 * @return : a String array of all values
	 */
	@Override
	public String[] validateProduct() throws IllegalArgumentException {
		result[0] = Const.PETROL_ENGINE;

		if (param == null) {
			result[1] = kwArray.get(0).toString();
			result[2] = null; // no turbo
			result[3] = Const.DEFAULT_EURO_STANDARD;
			return result;
		} else {

			result[3] = euroVal.validateEuroStandard(param);
			// returns an array of turbo and a double value for the 30%
			turboResults = turboVal.validateTurbo(param);
			result[2] = turboResults[0]; // adds turbo, either T or null
			// parse to double - contains either 1 or 1.3
			addTurboToPower = Double.valueOf(turboResults[1]);
			// parse 'power input' to kW
			power = powerVal.validatePower(param);

			if (kwArray.contains(power)) {
				result[1] = String.valueOf((int) (power * addTurboToPower));
				return result;
			} else if (power == 0) {
				result[1] = String.valueOf((int) kwArray.get(0) * addTurboToPower);// default
				return result;
			} else {
				throw new IllegalArgumentException();
			}
		}
	}

}
