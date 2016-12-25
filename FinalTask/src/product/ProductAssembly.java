package product;

import main.Constants.Const;
import product.engine.EngineFactory;
import product.model.VehicleValidator;
import product.transmission.TransmissionFactory;

public class ProductAssembly implements ProductAssemblyPlan {

	SplitValues splitValues = new SplitValues();
	TransmissionFactory transFactory = new TransmissionFactory();
	EngineFactory engineFactory = new EngineFactory();

	String[] splittedModel;
	String[] splittedEngine;
	String[] splittedTrans;

	String[] resultsModel;
	String[] resultsEngine;
	String[] resultsTrans;

	private String engineType;

	private Product product;

	public ProductAssembly() {
		this.product = new Product();
	}

	public Product getProduct() {
		return this.product;
	}
	
	public String getEngineType(){
		return engineType;
	}

	
	@Override
	public void buildVehicleModel(String vehicleType, String modelParam) throws IllegalArgumentException {

		VehicleValidator vehicleValidator = new VehicleValidator();

		// splits the parameters into two var and removes 'model='
		splittedModel = splitValues.splitString(modelParam);
		// validates all inputs and returns values
		resultsModel = vehicleValidator.validateModel(vehicleType, splittedModel[0], splittedModel[1]);

		this.product.setVehicleType(resultsModel[0]);
		this.product.setVehicleModel(resultsModel[1]);
		this.product.setVehicleBody(resultsModel[2]);

	}

	@Override
	public void buildVehicleEngine(String engineParam) throws IllegalArgumentException {

		splittedEngine = splitValues.splitString(engineParam);
		ProductValidationPlan engine = engineFactory.makeEngine(splittedEngine[0], splittedEngine[1]);
		resultsEngine = engine.validateProduct();
		
			engineType = resultsEngine[0];
		
		this.product.setVehicleEngineType(resultsEngine[0]);
		this.product.setVehicleEnginePower(resultsEngine[1]);
		this.product.setVehicleEngineTurbo(resultsEngine[2]);
		this.product.setVehicleEngineEmissionStandard(resultsEngine[3]);
	}

	@Override
	public void buildVehicleTransmission(String transParam, String engineType) throws IllegalArgumentException {
		// threads get mixed up here, fixed with synchronized
		// if the engine is electric, then we don't have transmission
		if (this.engineType.equals("E")) {
			// don't have transmission
			if (transParam == null || transParam.equals("transmission=")) {

				this.product.setVehicleTransmissionType(null);
				this.product.setVehicleTransmissionGears(null);

			} else {
				throw new IllegalArgumentException();
			}

		} else {
			// if no parameters are inputed
			if (transParam == null || transParam.equals("transmission=")) {

				this.product.setVehicleTransmissionType(Const.DEFAULT_TRANSMISSION_TYPE);// default
				this.product.setVehicleTransmissionGears(Const.DEFAULT_TRANSMISSION_GEARS);// default

			} else {
				// splits the parameters into two var
				splittedTrans = splitValues.splitString(transParam);

				// checks for auto or manual in factory
				ProductValidationPlan transmission = transFactory.makeTrans(splittedTrans[0], splittedTrans[1]);

				// calls transmission classes to validate gears
				resultsTrans = transmission.validateProduct();

				this.product.setVehicleTransmissionType(resultsTrans[0]);
				this.product.setVehicleTransmissionGears(resultsTrans[1]);
			}
		}
	}
}
