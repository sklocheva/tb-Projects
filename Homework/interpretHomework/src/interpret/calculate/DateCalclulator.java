package interpret.calculate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * DateCalclulator class is used to add/subtract a number of days to/from a
 * given date.
 * 
 * @author Sophia
 *
 */
public class DateCalclulator {

	private SimpleDateFormat sdf;
	private Calendar c;
	private Date parsedDate;

	/**
	 * The calculateDate method takes a date and a number in String and tries to
	 * add/subtract the days.
	 * 
	 * @param date
	 * @param number
	 * @return String calculated date
	 */
	public String calculateDate(String date, int number) {

		sdf = new SimpleDateFormat("yyyy-MM-dd");
		c = Calendar.getInstance();
		parsedDate = null;

		try {
			parsedDate = sdf.parse(date);
			if (!date.equals(sdf.format(parsedDate))) {
				return null;
			}
			c.setTime(parsedDate);
			c.add(Calendar.DATE, number);
			return sdf.format(c.getTime());

		} catch (ParseException e) {
			return null;
		}
	}

}
