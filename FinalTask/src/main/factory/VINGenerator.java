package main.factory;

/**
 * The 'VINGenerator' class is used to generate a 17 digit random VIN number.
 * 
 * @author Sophia
 *
 */
public class VINGenerator {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHJKLMNPRSTUVWXYZabcdefghjklmnprstuvwxyz0123456789";
	StringBuilder builder;
	int count = 14;

	/**
	 * The 'generateVIN' takes 
	 * @param countryCode
	 * @param factoryNumber
	 * @return
	 */
	public String generateVIN(String countryCode, int factoryNumber) {

		builder = new StringBuilder();
		builder.append(countryCode);
		builder.append(factoryNumber);

		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

}
