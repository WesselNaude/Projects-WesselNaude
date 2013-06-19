package com.application;

import java.util.ArrayList;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.activities.Home;

public class AdjustFormWidgetId {
	private FormWidgetFactory formWidgetFactory;
	private ArrayList<View> Views;

	public AdjustFormWidgetId() {
		formWidgetFactory = FormWidgetFactory.getInstance();
		Views = ViewCollection.getInstance().getViews();
	}

	// A1. Checks the type of the view, and calls the appropriate refactoring
	// method
	public void refactorFormWidgetId(View view) {

		if (view.getClass().getSimpleName().equals("Button")) {
			refactorButtonId();
		} else if (view.getClass().getSimpleName().equals("TextView")) {
			refactorTextViewId();
		} else if (view.getClass().getSimpleName().equals("ToggleButton")) {
			refactorToggleButtonId();
		} else if (view.getClass().getSimpleName().equals("CheckBox")) {
			refactorCheckBoxId();
		} else if (view.getClass().getSimpleName().equals("RadioButton")) {
			refactorRadioButtonId();
		} else if (view.getClass().getSimpleName().equals("ProgressBar")) {
			refactorProgressBarId();
		}
	}

	public void refactorButtonId() {
		// A2. Create a new button, and pass in the context.
		Button button = new Button(Home.getHome().getContext());
		// A3. Decrement button id, in the form widget factory.
		formWidgetFactory.decrementButtonId();
		// A4. Store the buttonId, so that it can be decremented and assigned to
		// the buttons on the root view, independently from the form widget
		// factory button id.
		int buttonId = formWidgetFactory.getButtonId();
		// A5. Loop through all the views in the view collection.
		for (View v : Views) {
			// A6. Only operate on the views which are of type Button.
			if (v.getClass().getSimpleName().equalsIgnoreCase("Button")) {
				// A7. Cast the view to a button and set button = to the view.
				button = (Button) v;
				// A8. Set the text of the button.
				button.setText("Button" + buttonId);
				// A9. Set the Id of the button
				button.setId(buttonId);
				// A10. Set the view to the button. replacing the view in the
				// ArrayList.
				v = button;
				// A11. Decrement the buttonId variable so next pass receives
				// decremented id.
				buttonId--;
			}
			// A12. Invalidate the view to force a redraw.
			v.invalidate();
		}
		// A13. Invalidate the main to force a redraw.
		Home.getHome().getLayout().invalidate();
	}

	// Refer to comments A2 - A13
	public void refactorTextViewId() {
		TextView textview = new TextView(Home.getHome().getContext());
		formWidgetFactory.decrementTextViewId();
		int textViewId = formWidgetFactory.getTextViewId();
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("TextView")) {
				textview = (TextView) v;
				textview.setText("TextView" + textViewId);
				textview.setId(textViewId);
				v = textview;
				textViewId--;
			}
			v.invalidate();
		}
		Home.getHome().getLayout().invalidate();

	}

	// Refer to comments A2 - A13
	public void refactorToggleButtonId() {
		ToggleButton toggleButton = new ToggleButton(Home.getHome()
				.getContext());
		formWidgetFactory.decrementToggleButtonId();
		int toggleButtonId = formWidgetFactory.getToggleButtonId();
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("ToggleButton")) {
				toggleButton = (ToggleButton) v;
				toggleButton.setText("ToggleButton" + toggleButtonId);
				toggleButton.setId(toggleButtonId);
				v = toggleButton;
				toggleButtonId--;
			}
			v.invalidate();
		}
		Home.getHome().getLayout().invalidate();
	}

	// Refer to comments A2 - A13
	public void refactorCheckBoxId() {
		CheckBox checkBox = new CheckBox(Home.getHome().getContext());
		formWidgetFactory.decrementCheckBoxId();
		int checkBoxId = formWidgetFactory.getCheckBoxId();
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("CheckBox")) {
				checkBox = (CheckBox) v;
				checkBox.setText("CheckBox" + checkBoxId);
				checkBox.setId(checkBoxId);
				v = checkBox;
				checkBoxId--;
			}
			v.invalidate();
		}
		Home.getHome().getLayout().invalidate();
	}

	// Refer to comments A2 - A13
	public void refactorRadioButtonId() {
		RadioButton radioButton = new RadioButton(Home.getHome().getContext());
		formWidgetFactory.decrementRadioButtonId();
		int radioButtonId = formWidgetFactory.getRadioButtonId();
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("RadioButton")) {
				radioButton = (RadioButton) v;
				radioButton.setText("RadioButton" + radioButtonId);
				radioButton.setId(radioButtonId);
				v = radioButton;
				radioButtonId--;
			}
			v.invalidate();
		}
		Home.getHome().getLayout().invalidate();
	}

	// Refer to comments A2 - A13
	public void refactorProgressBarId() {
		ProgressBar progressBar = new ProgressBar(Home.getHome().getContext());
		formWidgetFactory.decrementProgressBarId();
		int progressBarId = formWidgetFactory.getProgressBarId();
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("ProgressBar")) {
				progressBar = (ProgressBar) v;
				progressBar.setId(progressBarId);
				v = progressBar;
				progressBarId--;
			}
			v.invalidate();
		}
		Home.getHome().getLayout().invalidate();
	}
}
