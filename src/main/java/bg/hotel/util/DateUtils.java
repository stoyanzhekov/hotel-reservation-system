package bg.hotel.util;

import java.util.Date;

public class DateUtils {

	private DateUtils() {
	}

	public static boolean isPeriodValid(Date from, Date to) {
		boolean result = true;
		if (from.after(to)) {
			result = false;
		}
		return result;
	}
}
