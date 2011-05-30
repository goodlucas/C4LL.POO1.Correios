package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Convert a Date to pre-formatted string.
 */
public class DateString {
	public static String DateToString(Date a) {
		DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return dfm.format(a);
	}
	
	public static String elapsedTime(Date a, Date b) {
		ArrayList<String> result = new ArrayList<String>();
		int hour = DateDiff.getDateDiff(Calendar.HOUR, a, b);
		int min = DateDiff.getDateDiff(Calendar.MINUTE, a, b) - hour*60;
		int sec = DateDiff.getDateDiff(Calendar.SECOND, a, b) - hour*60*60 - min*60;
		
		if (hour > 0) {
			if (hour == 1)
				result.add(hour + " hora");
			else
				result.add(hour + " horas");
		}
		if (min > 0) {
			if (min == 1)
				result.add(min + " minuto");
			else
				result.add(min + " minutos");
		}
		if (sec > 0) {
			if (sec == 1)
				result.add(sec + " segundo");
			else
				result.add(sec + " segundos");
		}	
		return StringUtils.joinList(result, " ");
	}
	
}
