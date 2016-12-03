package product;

public interface ProductAssemblyPlan {
	/**
	 * <p>
	 * 'buildVehicleModel' method takes the type of the vehicle and it's
	 * information about the <i>model</i> and <i>car body</i>, and validates the
	 * inputs and stores them in an instance of the Product class.
	 * </p>
	 * <p>
	 * <i>Car body<i> is an optional parameter, so if it isn't specified in the
	 * input - the default parameters are set.
	 * </p>
	 * 
	 * @param vehicleType
	 * @param modelParam
	 *            : model, car body
	 */
	public void buildVehicleModel(String vehicleType, String modelParam);

	/**
	 * <p>
	 * 'buildVehicleEngine' method takes all information about the engine such
	 * as <i>type</i>, <i>power</i> and whether it has a <i>turbine</i>,
	 * validates the inputs and stores them in an instance of the Product class.
	 * </p>
	 * <p>
	 * Optional parameters: <i>power</i> and <i>turbo</i>. If they aren't
	 * specified in the input - the default parameters are set.
	 * </p>
	 * 
	 * @param engineParam
	 */
	public void buildVehicleEngine(String engineParam);

	/**
	 * <p>
	 * 'buildVehicleTransmission' method takes information about the
	 * transmission, if it has any, validates the inputs and stores them in an
	 * instance of the Product class.
	 * </p>
	 * <p>
	 * The whole input is optional. It takes the following parameters: <i>type
	 * of transmission</i> and <i>number of gears</i>.
	 * </p>
	 * 
	 * @param transParam
	 */
	public void buildVehicleTransmission(String transParam);

	/**
	 * The method 'getProduct' returns the whole product.
	 * 
	 * @return product
	 */
	public Product getProduct();

}
