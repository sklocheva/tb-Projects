package product.transmission;

import java.util.ArrayList;
import java.util.List;

import main.Constants.Const;
import product.ProductValidationPlan;

public class AutoTrans implements ProductValidationPlan {

	List<String> gearsAuto = new ArrayList<String>(ManualTrans.gearArray);

	private String gear;
	private String[] result = new String[2];

	public AutoTrans(String gear) {
		this.gear = gear;
	}

	/**
	 * This method gets the gear value, gets the list from ManualTrans and then
	 * copies it and adds it's new gear. Then checks if the input is from the
	 * supported types of gears. Then returns the transmission type + the gear.
	 * If the gears and returns a message.
	 */
	@Override
	public String[] validateProduct() throws IllegalArgumentException {
		result[0] = Const.AUTO_TRANSMISSION;

		if (gear != null) {
			gear = gear.replaceAll(Const.DASH_SEPARATOR, "");
			gearsAuto.add("8");

			if (gearsAuto.contains(gear)) {
				result[1] = gear;
				return result;
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			result[1] = gearsAuto.get(0);
			return result;
		}
	}

}
