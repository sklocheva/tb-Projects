package command.print;

import main.Constants.Const;

/**
 * The 'FormatPrint' class converts kW to hp and formats the whole output.s
 * 
 * @author Sophia
 */
public class FormatPrint {
	/**
	 * The method 'formatInput' takes the line of text, splits and converts the
	 * element that holds the engine power information and converts it to hp.
	 * Then it formats tha whole output and send it back.
	 * 
	 * @param param
	 * @return
	 */
	public String formatInput(String param) {

		String[] results = param.split(Const.DASH_SEPARATOR);
		for (int i = 0; i < results.length; i++) {
			if (results[i].equals(Const.CHECK_NULL_RECORDED)) {
				results[i] = "";
			}
		}
		int engineKw = Integer.valueOf(results[5]);
		String engineHp = String.valueOf((Math.round(engineKw * 1.34102)));
		String formatted = String.format(Const.OUTPUT_FORMATTING, results[0].trim(), results[2].trim(),
				results[3].trim(), results[4].trim(), engineHp, results[6].trim(), results[7].trim(), results[8].trim(),
				results[9].trim(), results[10].trim());
		return formatted;
	}
}