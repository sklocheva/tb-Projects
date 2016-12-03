package product.model;

import java.util.ArrayList;
import java.util.Arrays;

import main.Constants.Const;

/**
 * The 'VehicleValidator' class checks if mandatory values are inputed, and
 * validates them.
 * 
 * @author Sophia
 *
 */
public class VehicleValidator {

	ArrayList<String> modelArray;
	ArrayList<String> typeArray;
	private String[] result = new String[3];

	/**
	 * The method 'validateModel' receives the models parameters and validates
	 * each one of them. Also checks if the mandatory ones - vehicle type (ex.
	 * car, suv) and vehicle model (ex. A1,Q1) are present.
	 * 
	 * @param label
	 *            : vehicles type (ex. car)
	 * @param model
	 *            : vehicle model (ex. A1)
	 * @param body
	 *            : vehicle's body (ex. sedan)
	 * @return : a String array of all inputs
	 * @throws IllegalArgumentException
	 */
	public String[] validateModel(String label, String model, String body) throws IllegalArgumentException {

		typeArray = new ArrayList<>(Arrays.asList("sedan", "hatchback", "kombi"));
		try {
			label = label.toLowerCase();

			if (label.equals(Const.CAR_LABEL)) {

				modelArray = new ArrayList<>(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8"));

			} else if (label.equals(Const.SUV_LABEL)) {

				modelArray = new ArrayList<>(Arrays.asList("Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8"));

			} else {
				// if the Type is not valid, throw exception which will be
				// caught in the createCommand
				throw new IllegalArgumentException();
			}
			
			result[0] = label;
			model = model.toUpperCase();

			if (modelArray.contains(model)) {

				result[1] = model.toUpperCase();
				if (body == null) {
					result[2] = typeArray.get(0);
				} else {

					body = (body.replaceAll(Const.DASH_SEPARATOR, "")).toLowerCase();
					if (typeArray.contains(body)) {
						result[2] = body;
					} else {
						throw new IllegalArgumentException();
					}
				}
			} else {
				throw new IllegalArgumentException();
			}
		} catch (NullPointerException e) {
			throw new IllegalArgumentException();
		}
		return result;

	}

}
