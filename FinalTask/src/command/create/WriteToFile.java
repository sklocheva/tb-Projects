package command.create;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import main.Constants.Const;
import main.factory.Factory;
import product.Product;

/**
 * The class 'ProductToFileWriter' is used to record product parameters into a
 * text file.
 * 
 * @author Sophia
 *
 */
public class WriteToFile {

	/**
	 * The method 'write' from ProductWriter class writes the whole information
	 * of the created product in a file. It wait one second after every writing.
	 * 
	 * @param product:
	 *            the instance of Product, holds the whole information of the
	 *            new record.
	 */
	public synchronized void write(Product product) {

		try {
			File myFile = new File(Const.VEHICLE_HISTORY_FILE_NAME);
			if (!myFile.exists()) {
				myFile.createNewFile();
				FileWriter header = new FileWriter(Const.VEHICLE_HISTORY_FILE_NAME, true);
				header.flush();
				header.close();
			}
			FileWriter outputStream = new FileWriter(Const.VEHICLE_HISTORY_FILE_NAME, true);
			outputStream.write(String.format(Const.INPUT_FORMATTING, Factory.getNextVINNumber(), product.getVehicleType(),
					product.getVehicleModel(), product.getVehicleBody(), product.getVehicleEngineType(),
					product.getVehicleEnginePower(), product.getVehicleEngineTurbo(),
					product.getVehicleEngineEmissionStandard(), product.getVehicleTransmissionType(),
					product.getVehicleTransmissionGears(), Const.DEFAULT_ISDISASS_INPUT));

			
			outputStream.flush();
			outputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
