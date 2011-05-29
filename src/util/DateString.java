package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Convert a Date to pre-formatted string.
 */
public class DateString {
	public static String DateToString(Date a) {
		DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return dfm.format(a);
	}
	
}
