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
	
	/**
	 * Get elapsed time between a and b.
	 * @param a	Start time
	 * @param b	End time
	 * @return	String elapsed time between a and b.
	 */
	public static String elapsedTime(Date a, Date b) {
		ArrayList<String> result = new ArrayList<String>();
		int[]	elapsed = {DateDiff.getDateDiff(Calendar.HOUR, a, b),
							DateDiff.getDateDiff(Calendar.MINUTE, a, b),
							DateDiff.getDateDiff(Calendar.SECOND, a, b)};
		String[] sing = {"hora",  "minuto",  "segundo"};
		String[] plur = {"horas", "minutos", "segundos"};
		
		elapsed[1] -= elapsed[0] * 60;
		elapsed[2] -= elapsed[0] * 120 + elapsed[1] * 60;		
		for (int i = 0; i < 3; i++)
			if (elapsed[i] > 0)
				if (elapsed[i] == 1)
					result.add(elapsed[i] + " " + sing[i]);
				else
					result.add(elapsed[i] + " " + plur[i]);
		return StringUtils.joinList(result, " ");
	}
}
