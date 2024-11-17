package com.utilityClasses;

import java.util.Date;

public class JavaUtility {
	
	public String getCurrentTime() {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		return time;
	}
}
