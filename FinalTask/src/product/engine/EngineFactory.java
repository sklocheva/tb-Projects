package product.engine;

import main.Constants.Const;
import product.ProductValidationPlan;

/**
 * 'EngineFactory' class checks which engine is inputed and calls it's class.
 * 
 * @author Sophia
 *
 */
public class EngineFactory {
	/**
	 * The 'makeEngine' method takes the vehicle's engine type and checks if it
	 * has a class for it. When it finds it it returns that class with it's
	 * parameters set to it.
	 * 
	 * @param label
	 *            : engine type (ex. 'P' for Petrol)
	 * @param param
	 *            : the rest of engine's parameters
	 * @return : the specific engine class
	 * @throws IllegalArgumentException
	 */
	public ProductValidationPlan makeEngine(String label, String param) throws IllegalArgumentException {

		if (label.equals(Const.PETROL_ENGINE)) {

			return new PetrolEngine(param);

		} else if (label.equals(Const.DIESEL_ENGINE)) {

			return new DieselEngine(param);

		} else if (label.equals(Const.ELECTRIC_ENGINE)) {
			// takes no parameters for now, so the param should be null.
			return new ElectricEngine(param);

		} else {
			// if the TransType is not valid, throw exception which will be
			// caught in the createCommand
			throw new IllegalArgumentException();
		}

	}

}
