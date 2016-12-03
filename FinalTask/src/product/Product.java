package product;

/**
 * Product class is used to stores all of information about the parts of the
 * vehicle in one place, before saving it.
 * 
 * @author Sophia
 *
 */
public class Product implements ProductPlan {
	private String vehicleType;
	private String vehicleModel;
	private String vehicleBody;
	private String engineType;
	private String enginePower;
	private String turbo;
	private String emissionStandard;
	private String transType;
	private String transGears;

	@Override
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * 'getVehicleType' returns the type of vehicle.<br>
	 * <b>example:</b> SUV, Car
	 * 
	 * @return vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}

	@Override
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	/**
	 * 'getVehicleModel' returns the model of the vehicle.<br>
	 * <b>example:</b> A1, A2, Q1
	 * 
	 * @return vehicleModel
	 */
	public String getVehicleModel() {
		return vehicleModel;
	}

	@Override
	public void setVehicleBody(String vehicleBody) {
		this.vehicleBody = vehicleBody;

	}

	/**
	 * 'getVehicleBody' method returns the type of the body of the vehicle.<br>
	 * <b>example:</b> sedan
	 * 
	 * @return vehicleBody
	 */
	public String getVehicleBody() {
		return vehicleBody;
	}

	@Override
	public void setVehicleEngineType(String engineType) {
		this.engineType = engineType;

	}

	/**
	 * 'getVehicleEngineType' method returns the type of engine of the vehicle.<br>
	 * <b>example:</b> Petrol
	 * 
	 * @return engineType : type of engine the vehicle has in one letter, for example 'P'.
	 */
	public String getVehicleEngineType() {
		return engineType;
	}

	@Override
	public void setVehicleEnginePower(String enginePower) {
		this.enginePower = enginePower;

	}

	/**
	 * 'getVehicleEnginePower' method returns the engine power in kilowatts.
	 * 
	 * @return enginePower
	 */
	public String getVehicleEnginePower() {
		return enginePower;
	}

	@Override
	public void setVehicleEngineTurbo(String turbo) {
		this.turbo = turbo;

	}

	/**
	 * 'getVehicleEngineTurbo' method returns whether the vehicle has a turbo or
	 * not.<br>If it has turbo stores 'T', if it doesn't it stores <i>null</i>.
	 * 
	 * @return turbo
	 */
	public String getVehicleEngineTurbo() {
		return turbo;
	}

	@Override
	public void setVehicleEngineEmissionStandard(String emissionStandard) {
		this.emissionStandard = emissionStandard;

	}

	/**
	 * 'getVehicleEngineEmissionStandard' method returns the type of emission
	 * standard of the vehicle.<br>
	 * <b>example:</b> euro3
	 * 
	 * @return emissionStandard : returns only the number number, for example: 3.
	 */
	public String getVehicleEngineEmissionStandard() {
		return emissionStandard;
	}

	@Override
	public void setVehicleTransmissionType(String transType) {
		this.transType = transType;

	}

	/**
	 * 'getVehicleTransmissionGears' method returns the type of transmission.<br>
	 * <b>example:</b> Manual
	 * 
	 * @return transType
	 */
	public String getVehicleTransmissionType() {
		return transType;
	}

	@Override
	public void setVehicleTransmissionGears(String transGears) {
		this.transGears = transGears;

	}

	/**
	 * 'getVehicleTransmissionGears' method returns the number of gears the
	 * vehicle has.
	 * 
	 * @return transGears : a number value, for example: 5
	 */
	public String getVehicleTransmissionGears() {
		return transGears;
	}

}
