package interpret.command.access;

import interpret.main.Constants;

/**
 * CompoundValue class stores two values hashValueType and hashValue which later
 * on are used in a Map. Overrides the method toString() and uses it to return
 * those values.
 * 
 * @author Sophia
 *
 */
public class CompoundValue {

	private String hashValueType;
	private String hashValue;

	/**
	 * Inputs two values
	 * 
	 * @param hashValueType - where the type of the value is stored
	 * @param hashValue
	 */
	public CompoundValue(String hashValueType, String hashValue) {
		this.hashValueType = hashValueType;
		this.hashValue = hashValue;
	}

	/**
	 * Returns the two stored values.
	 * @return String: [hashValueType] hashValue
	 * @Example [string] alice
	 */
	@Override
	public String toString() {

		return String.format(Constants.Formattings.COMPOUND_VALUE_OUTPUT,this.hashValueType, this.hashValue);
	}

}
