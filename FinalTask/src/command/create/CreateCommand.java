package command.create;

import command.Command;
import main.Constants.Const;
import product.Product;
import product.ProductAssembly;

/**
 * The 'CreateCommand' class is used to create a vehicle with given parameters.
 * 
 * @author Sophia
 *
 */
public class CreateCommand implements Command {

	private static final String COMMAND_NAME = "create";

	ProductAssembly vehicleAssembly;
	Product concreteProduct;
	WriteToFile writeInfo;

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * The method uses a 'ProductAssembly' class to put all different parameters
	 * separately, parse and validate them, get their defaults if the optional
	 * inputs are not provided. Then it gets the whole product and sends them to
	 * be saved in a file.
	 * 
	 * @param argument
	 *            : the output whether the operation has been successful.
	 */
	@Override
	public String executeCommand(String argument) {
		try {
			String[] parts = argument.split(Const.SPACE_SEPARATOR);

			Thread.sleep(1000);
			if (parts.length <= 4 && parts.length >= 3) {

				vehicleAssembly = new ProductAssembly();

				synchronized (vehicleAssembly) {
					vehicleAssembly.buildVehicleEngine(parts[2]);
				}
				vehicleAssembly.buildVehicleModel(parts[0], parts[1]);

				if (parts.length == 4) {
					vehicleAssembly.buildVehicleTransmission(parts[3]);
				} else {
					vehicleAssembly.buildVehicleTransmission(null);
				}
				// get the whole product
				concreteProduct = vehicleAssembly.getProduct();
				// writes in a file
				writeInfo = new WriteToFile();
				writeInfo.write(concreteProduct);

				return Const.SUCCESS_ASSEMBLE_MESSAGE;

			} else {
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException | InterruptedException e) {
			return Const.ERROR_OUTPUT_MESSAGE;
		}
	}

}
