package com.application;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.activities.Home;

public class FormWidgetFactory {
    //F1. Declare view id's
	private int buttonId;
	private int textViewId;
	private int toggleButtonId;
	private int checkBoxId;
	private int radioButtonId;
	private int progressBarId;
	//F2. Declare Context 
	private Context context;
	//F3. Declare Static form widget factory instance 
	private static FormWidgetFactory uniqueInstance;
    /*F4. Singleton design pattern, initialises form widget factory object reference, 
      return unique instance (form widget factory) if none has been initialised else returns initialised unique instance. */
	public static FormWidgetFactory getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new FormWidgetFactory();
		}
		return uniqueInstance;
	}

	private FormWidgetFactory() {
		buttonId = 0;
		textViewId = 0;
		toggleButtonId = 0;
		checkBoxId = 0;
		radioButtonId = 0;
		progressBarId = 0;
	}
      //F5. Object Factory, returns the requested view based on the integer value passed to the method. 
	public View getView(int choice) {

		if (choice == 0) {
			//F6. Increment button id.
			buttonId++;
			//F7. Set's the context to home's context. 
			context = Home.getHome().getLayout().getContext();
			//F8 View constructor requires context for instantiation. 
			Button button = new Button(context);
			//F9 Set the view id to previously incremented id. 
			button.setId(buttonId);
			/*F10. Set the text to the type of of view + the incremented id, could also be done  via button.setText(button.getClass.getSimpleName), however
			  I find this solution more visually appealing and easier to understand.*/
			button.setText("Button" + buttonId);
			//F11. Set the text colour of the view. 
			button.setTextColor(Color.WHITE);
			//F12. Return the view.
			return button;
		}
		//Refer to comments F6 - F12.
		if (choice == 1) {
			textViewId++;
			context = Home.getHome().getLayout().getContext();
			TextView textView = new TextView(context);
			textView.setId(textViewId);
			textView.setText("TextView" + textViewId);
			textView.setTextColor(Color.WHITE);
			return textView;
		}
		//Refer to comments F6 - F12.
		if (choice == 2) {
			context = Home.getHome().getLayout().getContext();
			toggleButtonId++;
			ToggleButton toggleButton = new ToggleButton(context);
			toggleButton.setId(toggleButtonId);
			toggleButton.setText("ToggleButton" + toggleButtonId);
			toggleButton.setTextColor(Color.WHITE);
			return toggleButton;
		}
		//Refer to comments F6 - F12.
		if (choice == 3) {
			context = Home.getHome().getLayout().getContext();
			checkBoxId++;
			CheckBox checkBox = new CheckBox(context);
			checkBox.setId(checkBoxId);
			checkBox.setText("CheckBox" + checkBoxId);
			checkBox.setTextColor(Color.WHITE);
			return checkBox;
		}
		//Refer to comments F6 - F12.
		if (choice == 4) {
			context = Home.getHome().getLayout().getContext();
			radioButtonId++;
			RadioButton radioButton = new RadioButton(context);
			radioButton.setId(radioButtonId);
			radioButton.setText("RadioButton" + radioButtonId);
			radioButton.setTextColor(Color.WHITE);
			return radioButton;

		}
		
		if (choice == 5) {
			//F13. Set's the context to home's context. 
			context = Home.getHome().getLayout().getContext();
			//F14. Increment Progress bar id. 
			progressBarId++;
			//F15. View constructor requires context for instantiation. 
			ProgressBar progressBar = new ProgressBar(context);
			//F16. Set the view id to previously incremented id. 
			progressBar.setId(progressBarId);
			// Return the view. 
			return progressBar;
		}
        //F17. Return null if no view matches integer choice. 
		return null;
	}
	//F18. Get View Id
	public int getButtonId(){
		return buttonId;
	}
	// Refer to comment 18. 
	public int getTextViewId(){
		return textViewId;
	}
	// Refer to comment 18. 
	public int getToggleButtonId(){
		return toggleButtonId;
	}
	// Refer to comment 18. 
	public int getCheckBoxId(){
		return checkBoxId;
	}
	// Refer to comment 18. 
	public int getRadioButtonId (){
		return radioButtonId;
	}
	// Refer to comment 18. 
	public int getProgressBarId(){
		return progressBarId;
	}
	/*F19. Decrement the view id variable,
	  used to maintain the list view and view text on root view when user deletes a view*/
	public void decrementButtonId() {
		buttonId--;
	}
    // Refer to comment 19
	public void decrementTextViewId() {
		textViewId--;
	}
	// Refer to comment 19 
	public void decrementToggleButtonId() {
		toggleButtonId--;
	}
	// Refer to comment 19 
	public void decrementCheckBoxId() {
		checkBoxId--;
	}
	// Refer to comment 19
	public void decrementRadioButtonId() {
		radioButtonId--;
	}
	// Refer to comment 19
	public void decrementProgressBarId() {
		progressBarId--;
	}
	
	public void setButtonId(int id) {
		buttonId = id;
	}
	
	public void setTextViewId(int id) {
		textViewId = id;
	}
	
	public void setToggleButtonId(int id) {
		toggleButtonId = id;
	}
	
	public void setCheckBoxId(int id) {
		checkBoxId = id;
	}
	
	public void setRadioButtonId(int id) {
		radioButtonId = id;
	}
	
	public void setProgressBarId(int id) {
		progressBarId = id;
	}
	public void uninitializeIds(){
		buttonId = 0;
		textViewId = 0;
		toggleButtonId = 0;
		checkBoxId = 0;
		radioButtonId = 0;
		progressBarId = 0;
	}
}
