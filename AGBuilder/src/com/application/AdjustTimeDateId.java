package com.application;

import java.util.ArrayList;

import android.view.View;
import android.widget.AnalogClock;
import android.widget.Chronometer;
import android.widget.DigitalClock;
import android.widget.TimePicker;

import com.activities.Home;

public class AdjustTimeDateId {
	private TimeDateFactory timeDateFactory;
	private ArrayList<View> Views;

	public AdjustTimeDateId() {
		timeDateFactory = TimeDateFactory.getInstance();
		Views = ViewCollection.getInstance().getViews();
	}

	// A1. Checks the type of the view, and calls the appropriate refactoring
	// method
	public void refactorTimeDateId(View view) {
		if (view.getClass().getSimpleName().equals("TimePicker")) {
			refactorTimePickerId();
		} else if (view.getClass().getSimpleName().equals("Chronometer")) {
			refactorChronoMeterId();
		} else if (view.getClass().getSimpleName().equals("AnalogClock")) {
			refactorAnalogClock();
		} else if (view.getClass().getSimpleName().equals("DigitalClock")) {
			refactorDigitalClock();
		}
	}

	public void refactorTimePickerId() {
		// A2. Create a new time picker, and pass in the context.
		TimePicker timePicker = new TimePicker(Home.getHome().getContext());
		// A3. Decrement time picker id, in the time date factory.
		timeDateFactory.decrementTimePickerId();
		/*
		 * A4. Store the time picker id, so that it can be decremented and
		 * assigned to the time picker on the root view, independently from the
		 * time date factory time picker id.
		 */
		int timePickerId = timeDateFactory.getTimePickerId();
		// A5. Loop through all the views in the view collection.
		for (View v : Views) {
			// A6. Only operate on the views which are of type Time Picker.
			if (v.getClass().getSimpleName().equalsIgnoreCase("TimePicker")) {
				// A7. Cast the view to a time picker and set timepicker = to
				// the view.
				timePicker = (TimePicker) v;
				// A8. Set the id of the time picker.
				timePicker.setId(timePickerId);
				// A9. Set the view to the time picker. replacing the view in
				// the ArrayList.
				v = timePicker;
				// A10. Decrement the buttonId variable so next pass receives
				// decremented id.
				timePickerId--;
			}
			// A11. Invalidate the view to force a redraw.
			v.invalidate();
		}
		// A12. Invalidate the main to force a redraw.
		Home.getHome().getLayout().invalidate();
	}

	// Refer to comments A2 - A12
	public void refactorChronoMeterId() {
		Chronometer chronoMeter = new Chronometer(Home.getHome().getContext());
		timeDateFactory.decrementChronoMeterId();
		int chronoMeterId = timeDateFactory.getChronoMeterId();
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("Chronometer")) {
				chronoMeter = (Chronometer) v;
				chronoMeter.setText("Chronometer" + chronoMeterId);
				chronoMeter.setId(chronoMeterId);
				v = chronoMeter;
				chronoMeterId--;
			}
			v.invalidate();
		}
		Home.getHome().getLayout().invalidate();
	}

	// Refer to comments A2 - A12
	public void refactorAnalogClock() {
		AnalogClock analogClock = new AnalogClock(Home.getHome().getContext());
		timeDateFactory.decrementAnalogClockId();
		int analogClockId = timeDateFactory.getAnalogClockId();
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("AnalogClock")) {
				analogClock = (AnalogClock) v;
				analogClock.setId(analogClockId);
				v = analogClock;
				analogClockId--;
			}
			v.invalidate();
		}
		Home.getHome().getLayout().invalidate();
	}

	// Refer to comments A2 - A12
	public void refactorDigitalClock() {
		DigitalClock digitalClock = new DigitalClock(Home.getHome()
				.getContext());
		timeDateFactory.decrementDigitalClockId();
		int digitalClockId = timeDateFactory.getDigitalClockId();
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("DigitalClock")) {
				digitalClock = (DigitalClock) v;
				digitalClock.setId(digitalClockId);
				v = digitalClock;
				digitalClockId--;
			}
			v.invalidate();
		}
		Home.getHome().getLayout().invalidate();
	}
}
