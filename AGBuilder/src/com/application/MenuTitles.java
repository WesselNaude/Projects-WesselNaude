package com.application;

import com.slidelayout.ScrollerLinearLayout;

public class MenuTitles {

	// M1. Declare and initialise the title arrays.
	private static final String[] homeTitles = { "Form Widgets", "Time & Date",  "Text Fields", "Save","Load","Exit" };
	private static final String[] formWidgetsTitles = { "Button", "TextView",
			"Toggle Button", "Check Box", "Radio Button", "Progress Bar",
			"Back" };
	private static final String[] textFieldsTitles = { "Plain Text",
			"Password", "Password Numeric", "Email", "Phone", "Postal Address",
			"Multiline Text", "Time", "Date", "Number", "Number Signed",
			"Number Decimal", "Auto Complete", "Multi AutoComplete", "Back" };
	private static final String[] timeAndDateTitles = { "Time Picker",
			"Chronometer", "Analog Clock", "Digital Clock", "Back" };

	// M2. Method takes class name and returns the appropriate title array.
	public static String[] setTitles(String className) {
		if (className.equals("Home") || className.equals("HomeModel")) {
			return homeTitles;
		}
		if (className.equals("FormWidgetModel")) {
			// M3 Re initialise the side view so that new titles are loaded.
			ScrollerLinearLayout.init();
			return formWidgetsTitles;
		}
		if (className.equals("TextFieldsModel")) {
			ScrollerLinearLayout.init();
			return textFieldsTitles;
		}
		if (className.equals("TimeDateModel")) {
			ScrollerLinearLayout.init();
			return timeAndDateTitles;
		}
		return null;
	}
	/*
	 * public static int setScrollerWidth(String[] titles) { largest = 0; String
	 * name = ""; for (int i = 0; i < titles.length; i++) {
	 * 
	 * if (titles[i].length() > largest) { largest = titles[i].length();
	 * 
	 * name = titles[i]; } } ScrollerLinearLayout.setScrollerWidth(largest);
	 * String somestring = Integer.toString(largest); Log.d(name +
	 * " aaaand length is", somestring); return largest; }
	 * 
	 * public static int getScrollerWidth() { return largest; }
	 */

}
