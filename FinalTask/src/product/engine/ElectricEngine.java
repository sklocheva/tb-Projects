package product.engine;

import main.Constants.Const;
import product.ProductValidationPlan;

/**
 * <p>
 * The 'ElectricEngine' class is a type of engine, it takes no parameters, as it
 * does not have emission standards, turbo, and its power is always 535kW.
 * <p>
 * <p>
 * <b>note: </b> It also does not have transission, but this is validated in the
 * transmission part.
 * </p>
 * 
 * @author Sophia
 *
 */
public class ElectricEngine implements ProductValidationPlan {

	private String param;
	private String[] result = new String[4];

	public ElectricEngine(String param) {
		this.param = param;
	}

	/**
	 * <p>
	 * The method sets its default parameters and does not accept any other
	 * values than null. It doesn't have emission standards, turbo, and its
	 * power is always 535kW.
	 * </p>
	 * <p>
	 * <b>note: </b> It also does not have transission, but this is validated in
	 * the transmission part.
	 * </p>
	 */
	@Override
	public String[] validateProduct() throws IllegalArgumentException {
		result[0] = Const.ELECTRIC_ENGINE;
		result[1] = Const.DEFAULT_EL_ENGINE_POWER;
		result[2] = null;
		result[3] = null;

		if (param == null) {
			return result;
		} else {
			throw new IllegalArgumentException();
		}
	}

}
