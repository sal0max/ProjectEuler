package de.msal.euler;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * How many Sundays fell on the first of the month during the twentieth century?
 * 
 * 
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 * 
 * 1 Jan 1900 was a Monday. Thirty days has September, April, June and November.
 * All the rest have thirty-one, Saving February alone, Which has twenty-eight,
 * rain or shine. And on leap years, twenty-nine. A leap year occurs on any year
 * evenly divisible by 4, but not on a century unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 */

public class Prob019 {

	public static void main(String[] args) {
		GregorianCalendar calStart = new GregorianCalendar(1901, 0, 1);
		GregorianCalendar calEnd = new GregorianCalendar(2000, 11, 31);

		int count = 0;

		while (calStart.getTime().before(calEnd.getTime())) {
			if (calStart.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY) {
				count++;
				System.out.println(new SimpleDateFormat("EEEE, dd.MM.yyyy")
						.format(calStart.getTime()));
			}
			calStart.add(GregorianCalendar.MONTH, 1);
		}

		System.out.println("-> " + count);

	}

}
