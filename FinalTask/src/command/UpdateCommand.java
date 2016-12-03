package command;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.Constants.Const;
import product.engine.validators.EuroStandardValidator;

public class UpdateCommand implements Command {

	private static final String COMMAND_NAME = "update";

	private EuroStandardValidator euroValidator;
	private TempToFile swapFiles;
	private File inputFile;
	private File tempFile;

	private BufferedReader reader;
	private BufferedWriter writer;
	private String currentLine;
	private String lineToChange = null;
	private String[] splitedArgument;
	private String newEuroStandard;

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	@Override
	public String executeCommand(String argument) {
		euroValidator = new EuroStandardValidator();
		swapFiles = new TempToFile();

		splitedArgument = argument.split(Const.SPACE_SEPARATOR);
		inputFile = new File(Const.VEHICLE_HISTORY_FILE_NAME);
		tempFile = new File(inputFile.getAbsolutePath() + ".tmp");

		try {
			reader = new BufferedReader(new FileReader(inputFile));
			writer = new BufferedWriter(new FileWriter(tempFile));
			// throws IllegalArgumentException
			newEuroStandard = euroValidator.validateEuroStandard(splitedArgument[1]);

			while ((currentLine = reader.readLine()) != null) {
				// checks if line contains the VIN
				if (currentLine.contains(splitedArgument[0].trim())) {
					String[] currentValues = currentLine.split("-");
					if (currentValues[4].equals(Const.ELECTRIC_ENGINE)) {
						return Const.ERROR_OUTPUT_MESSAGE;
					} else {
						// extracts only the euro standard
						// replaces the old euro with the new one
						lineToChange = currentLine.replaceAll(currentValues[7], newEuroStandard);
					}
				} else {
					writer.write(currentLine + System.getProperty("line.separator"));
					writer.flush();
				}
			}
			if (lineToChange != null) {
				writer.write(lineToChange + System.getProperty("line.separator"));
				writer.flush();
			} else {
				writer.close();
				reader.close();
				return Const.VIN_NOT_FOUND_MESSAGE;
			}
			writer.close();
			reader.close();
			swapFiles.swapFiles(inputFile, tempFile);

			return Const.SUCCESS_UPDATE_MESSAGE;
		} catch (IllegalArgumentException e) {
			return Const.ERROR_OUTPUT_MESSAGE;
		} catch (IOException e) {
			e.printStackTrace();
			return Const.IO_ERROR_MESSAGE;
		}
	}

}
