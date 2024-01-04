/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	static int SundaysOnFirst = 0;

	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
        int debugDaysCounter = 0;
        // int inputYear = Integer.parseInt(args[0]);
		int inputYear = 2006;

        while (year <= inputYear) {
            if (year == inputYear) {
                if (dayOfWeek == 1) {
                    System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
                } else {
                    System.out.println(dayOfMonth + "/" + month + "/" + year);
                }
            }
            advance();
            debugDaysCounter++;

            if (debugDaysCounter == 0) {
                break;
            }
        }
    }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
        if (dayOfWeek < 7) {
            dayOfWeek++;
        } else if (dayOfWeek == 7) {
            dayOfWeek = 1;
        }
        if (dayOfMonth < nDaysInMonth) {
            dayOfMonth++;
        } else if (dayOfMonth == nDaysInMonth) {
            dayOfMonth = 1;
            if (month < 12) {
                month++;
                nDaysInMonth = nDaysInMonth(month, year);
            } else if (month == 12) {
                month = 1;
                nDaysInMonth = nDaysInMonth(month, year);
                year++;
            }
        }
    }
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    // Replace the following statement with your code
		boolean isLeapYear;
		// Checks if the year is divisible by 400
		isLeapYear = ((year % 400) == 0);
		// Then checks if the year is divisible by 4 but not by 100
		isLeapYear = isLeapYear || (((year % 4) == 0) && ((year % 100) != 0));
		return isLeapYear;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		// Replace the following statement with your code
		int days = 0;
		if (month == 4 || month == 6 || month == 9 || month == 11) {
				days = 30;
			}
		else if (month == 2) {
				if(isLeapYear(year)) {
					days = 29;
				}
				else {
					days = 28;
				}
			}
		else {
			days = 31;
		}
		return days;
	}
}