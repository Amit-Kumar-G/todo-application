package com.odcem.todoapplication.utility;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * 
 * @author amitkumargupta
 *
 */

public class Utils {

	/**
	 * Takes an exception stack trace and returns it in a String format.
	 * @param ex
	 * @return
	 */
	public static String getStackTraceInStringFmt(Exception ex) {
		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		ex.printStackTrace(printWriter);
		return writer.toString();

	}
	
	/**
	 * @see Uses the epoch time uptil seconds. milliseconds is omitted.
	 * @return
	 */
	public static String getCurrentTimeInEpochString() {
		System.out.println(System.currentTimeMillis() / 1000);
		return String.valueOf(System.currentTimeMillis());
	}
}
