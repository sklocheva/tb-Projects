package product.transmission;

import java.util.ArrayList;
import java.util.Arrays;

import main.Constants.Const;
import product.ProductValidationPlan;

public class ManualTrans implements ProductValidationPlan {

	public static ArrayList<String> gearArray = new ArrayList<>(Arrays.asList("4", "5", "6"));

	private String gear;
	private String[] result = new String[2];

	public ManualTrans(String gear) {
		this.gear = gear;
	}

	/**
	 * This method gets the gear value and checks if it's from the supported
	 * types of gears. Then returns the transmission type + the gear. If the
	 * gear is unsupported then returns a message.
	 */
	@Override
	public String[] validateProduct() throws IllegalArgumentException {

		result[0] = Const.MANUAL_TRANSMISSION;
		if (gear != null) {
			gear = gear.replaceAll(Const.DASH_SEPARATOR, "");

			if (gearArray.contains(gear)) {
				result[1] = gear;
				return result;
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			result[1] = gearArray.get(0);
			return result;
		}
	}

}
