package interpret.calculate;

/**
 * Calculate interface is used for all calculations in CalcCommand class. It has
 * a getOperatorType method which returns its type and operation it uses and a
 * calc method which gives them two values to calculate and returns the result
 * from that calculation.
 * 
 * @author Sophia
 *
 */
public interface Calculate {
	/**
	 * getOperatorType method returns its type and operation it uses.
	 * 
	 * @return final String CALCULATEANDTYPE_NAME
	 */
	String getOperatorType();

	/**
	 * calc method which gives them two values to calculate and returns the
	 * result from that calculation.
	 * 
	 * @param value1 
	 * @param value2
	 * @return String : result from the calculation of the two values
	 */
	String calc(String value1, String value2);

}
