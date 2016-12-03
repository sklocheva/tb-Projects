package product;

public interface ProductPlan {

	/**
	 * 'setVehicleType' method stores the type of vehicle.<br>
	 * <b>example:</b> SUV, Car
	 * 
	 * @param vehicleType
	 */
	public void setVehicleType(String vehicleType);

	/**
	 * 'setVehicleModel' method stores the model of the vehicle.<br>
	 * <b>example:</b> A1, A2, Q1
	 * 
	 * @param vehicleModel
	 */
	public void setVehicleModel(String vehicleModel);

	/**
	 * 'setVehicleBody' method stores the type of the body of the vehicle.<br>
	 * <b>example:</b> sedan
	 * 
	 * @param vehicleBody
	 */
	public void setVehicleBody(String vehicleBody);

	/**
	 * 'setVehicleEngineType' method stores the type of engine of the vehicle.<br>
	 * <b>example:</b> Petrol
	 * 
	 * @param engineType
	 *            : type of engine the vehicle has in one letter, for example
	 *            'P'.
	 */
	public void setVehicleEngineType(String engineType);

	/**
	 * 'setVehicleEnginePower' method stores the engine power in kilowatts.
	 * Stores only the rounded value.
	 * 
	 * @param enginePower
	 */
	public void setVehicleEnginePower(String enginePower);

	/**
	 * 'setVehicleEngineTurbo' method stores whether the vehicle has a turbo or
	 * not.<br>If it has it stores 'T', if it doesn't it stores <i>null<i>.
	 * 
	 * @param turbo
	 */
	public void setVehicleEngineTurbo(String turbo);

	/**
	 * 'setVehicleEngineEmissionStandard' method stores the type of emission
	 * standard of the vehicle.<br> <b>example:</b> euro3
	 * 
	 * @param emissionStandard
	 *            : stores only the number number, for example: 3.
	 */
	public void setVehicleEngineEmissionStandard(String emissionStandard);

	/**
	 * 'setVehicleTransmissionType' method stores the type of transmission.<br>
	 * <b>example:</b> Manual
	 * 
	 * @param transType
	 */
	public void setVehicleTransmissionType(String transType);

	/**
	 * 'setVehicleTransmissionGears' method stores the number of gears the
	 * vehicle has.
	 * 
	 * @param transGears : stored as a number value, for example: 5
	 */
	public void setVehicleTransmissionGears(String transGears);

}
