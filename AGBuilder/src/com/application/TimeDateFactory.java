package com.application;

import java.util.Calendar;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Chronometer;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.TimePicker;

import com.activities.Home;

public class TimeDateFactory {
	//T1. Declare view id's
	private int timePickerId; 
	private int chronometerId;
	private int analogClockId;
	private int digitalClockId;
	//T2. Declare time variables. 
	private int hour;
	private int minute;
    //T3. Declare calendar variable. 
	private final Calendar c;
	//T4. Declare Context 
	private Context context;
	//T5. Declare Static time date factory instance. 
	private static TimeDateFactory uniqueInstance;
	 /*T6. Singleton design pattern, initialises time date factory object reference, 
    return unique instance (time date factory) if none has been initialised else returns initialised unique instance. */
	public static TimeDateFactory getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new TimeDateFactory();
		}
		return uniqueInstance;
	}
	
	private TimeDateFactory() {
		//T7. Initialise ID's to 0.
		timePickerId = 0;
		chronometerId = 0;
		analogClockId = 0;
		digitalClockId = 0;
		//T8. Initialise context to home's context.
		context = Home.getHome().getLayout().getContext();
		//T9. Initialise the calendar object to an instance of calendar.
		c = Calendar.getInstance();
		//T10. Initialise hour to the current hour of the day. 
		hour = c.get(Calendar.HOUR_OF_DAY);
		//T11. Initialise minute to the current minute of the day. 
		minute = c.get(Calendar.MINUTE);

	}
	 //T12. Object Factory, returns the requested view based on the integer value passed to the method. 
	public View getView(int choice) {

		if (choice == 0) {
			//T13. Increment view id. 
			timePickerId++;
			//T14. Pass home context to view constructor.
			TimePicker timePicker = new TimePicker(context);
			//T15 Set the view id to previously incremented id.
			timePicker.setId(timePickerId);
			//T16. Set view current hour to the previously initialised hour variable. 
			timePicker.setCurrentHour(hour);
			//T17. Set view current minute to the previously initialised minute variable. 
			timePicker.setCurrentMinute(minute);
			//T18. Set view background colour of the view. 
		    timePicker.setBackgroundColor(Color.DKGRAY);
		    //T19. Reduce the view with by half.
		    timePicker.setScaleX(0.50f);
		    //T20. Reduce the view height by half.
		    timePicker.setScaleY(0.50f);
		    //T21. Return the view
			return timePicker;
		}


		if (choice == 1) {
			//T22. Increment view id. 
			chronometerId++;
			//T23. Pass home context to view constructor.
			Chronometer chronoMeter = new Chronometer(context);
			//T24 Set the view id to previously incremented id.
			chronoMeter.setId(chronometerId);
			//T25 Set the view text to the name of the view +  the view id. 
			chronoMeter.setText("Chronometer" + chronometerId);
			//T26 Set view colour. 
			chronoMeter.setTextColor(Color.WHITE);
			//T27 Return the view. 
			return chronoMeter;
		}
     
		if (choice == 2) {
			//T28. Increment view id. 
			analogClockId++;
			//T29. Pass home context to view constructor.
			AnalogClock analogClock = new AnalogClock(context);
			//T30. Set the view id to previously incremented id.
			analogClock.setId(analogClockId);
			//T31. Return the view. 
			return analogClock;

		}
		// Refer to comments T22 - T27
		if (choice == 3) {
			digitalClockId++;
			DigitalClock digitalClock = new DigitalClock(context);
		    digitalClock.setId(digitalClockId);
		    digitalClock.setText("Digital Clock" + digitalClockId);
		    digitalClock.setTextColor(Color.WHITE);
			return digitalClock;
		}
		return null;
	}
	//T28. Get View Id.
	public int getTimePickerId(){
		return timePickerId;
	}
	// Refer to comments T28.
	public int getChronoMeterId(){
		return chronometerId;
	}
	// Refer to comments T28.
	public int getAnalogClockId(){
		return analogClockId;
	}
	// Refer to comments T28.
	public int getDigitalClockId(){
		return digitalClockId;
	}
	
	/*T29. Decrement the view id variable,
	  used to maintain the list view and view text on root view when user deletes a view*/
	public void decrementTimePickerId() {
		timePickerId--;
	}
	// Refer to comment T29.
	public void decrementChronoMeterId() {
		chronometerId--;
	}
	// Refer to comment T29.
	public void decrementAnalogClockId() {
		analogClockId--;
	}
	// Refer to comment T29.
	public void decrementDigitalClockId() {
		digitalClockId--;
	}
	
	public void setTimePickerId (int id){
		timePickerId = id;
	}
	
	public void setChronoMeterId (int id){
		chronometerId = id;
	}
	
	public void setAnalogClockId (int id){
		analogClockId = id;
	}
	
	public void setDigitalClockId(int id){
		digitalClockId = id;
	}
	
	public void uninitializeIds(){
		timePickerId = 0;
		chronometerId = 0;
		analogClockId = 0;
		digitalClockId = 0;
		}
	
}
