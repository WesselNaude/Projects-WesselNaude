package com.application;

import java.util.Calendar;

import android.content.Context;
import android.graphics.Color;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DigitalClock;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TimePicker;

import com.activities.Home;

public class LoadTimeDate {
	private LayoutParams params;
	private Context context;
	private int timePickerId = 0;
	private int chronometerId = 0;
	private int analogClockId = 0;
	private int digitalClockId = 0;
	private Calendar c = Calendar.getInstance();
	private int hour = c.get(Calendar.HOUR_OF_DAY);
	private int minute = c.get(Calendar.MINUTE);
	private static LoadTimeDate uniqueInstance;
	

	
	public static LoadTimeDate getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new  LoadTimeDate();
		}
		return uniqueInstance;
	}
	
	private LoadTimeDate(){}
	
	public void getView(int choice, int integerId, int integerWidth, int integerHeight, int integerLayoutX, int integerLayoutY, String text ) {

		if (choice == 0) {
			params = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
			context = Home.getHome().getLayout().getContext();
			TimePicker timePicker = new TimePicker(context);
			timePicker.setId(integerId);
			timePicker.setCurrentHour(hour);
			timePicker.setCurrentMinute(minute);
			timePicker.setBackgroundColor(Color.DKGRAY);
			timePicker.setScaleX(0.50f);
			timePicker.setScaleY(0.50f);
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			timePicker.setLayoutParams(params);
			Home.getHome().getLayout().addView(timePicker, params);
			timePicker.setOnTouchListener(new DragListener(timePicker));
			if (timePickerId > integerId){
				timePickerId = timePickerId;
			}
			else {
				timePickerId = integerId;
				TimeDateFactory.getInstance().setTimePickerId(timePickerId);
			}
		     ViewCollection.getInstance().addView(timePicker);
		}
		else if (choice == 1) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			Chronometer chronometer = new Chronometer(context);
			chronometer.setId(integerId);
			chronometer.setText(text);
			chronometer.setTextColor(Color.WHITE);
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			chronometer.setLayoutParams(params);
			Home.getHome().getLayout().addView(chronometer, params);
			chronometer.setOnTouchListener(new DragListener(chronometer));
			if (chronometerId > integerId){
				chronometerId = chronometerId;
			}
			else {
				chronometerId = integerId;
				TimeDateFactory.getInstance().setChronoMeterId(chronometerId);
			}
		     ViewCollection.getInstance().addView(chronometer);
		}
		else if (choice == 2) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			AnalogClock analogClock = new AnalogClock(context);
			analogClock.setId(integerId);
			
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			analogClock.setLayoutParams(params);
			Home.getHome().getLayout().addView(analogClock, params);
			analogClock.setOnTouchListener(new DragListener(analogClock));
			if (analogClockId > integerId){
				analogClockId = analogClockId;
			}
			else {
				analogClockId = integerId;
				TimeDateFactory.getInstance().setAnalogClockId(analogClockId);
			}
		     ViewCollection.getInstance().addView(analogClock);
		}
		else if (choice == 3) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			DigitalClock digitalClock = new DigitalClock(context);
			digitalClock.setId(integerId);
			digitalClock.setText(text);
			digitalClock.setTextColor(Color.WHITE);
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			digitalClock.setLayoutParams(params);
			Home.getHome().getLayout().addView(digitalClock, params);
			digitalClock.setOnTouchListener(new DragListener(digitalClock));
			if (digitalClockId > integerId){
				digitalClockId = digitalClockId;
			}
			else {
				digitalClockId = integerId;
				TimeDateFactory.getInstance().setDigitalClockId(digitalClockId);
			}
		     ViewCollection.getInstance().addView(digitalClock);
		}
 }
	
	public void uninitializeIds(){
	timePickerId = 0;
    chronometerId = 0;
    analogClockId = 0;
    digitalClockId = 0;
	}
}
