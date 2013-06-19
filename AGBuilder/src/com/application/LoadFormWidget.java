package com.application;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.activities.Home;

public class LoadFormWidget {
	private LayoutParams params;
	private Context context;
	private int buttonId = 0;
	private int textViewId = 0;
	private int toggleButtonId = 0;
	private int checkBoxId = 0;
	private int radioButtonId = 0;
	private int progressBarId = 0;
			
	private static LoadFormWidget uniqueInstance;
	

	
	public static LoadFormWidget getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new  LoadFormWidget();
		}
		return uniqueInstance;
	}
	
	private LoadFormWidget(){}
	
	public void getView(int choice, int integerId, int integerWidth, int integerHeight, int integerLayoutX, int integerLayoutY, String text ) {

		if (choice == 0) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			Button button = new Button(context);
			button.setId(integerId);
			button.setText(text);
			button.setTextColor(Color.WHITE);
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			button.setLayoutParams(params);
			Home.getHome().getLayout().addView(button, params);
			button.setOnTouchListener(new DragListener(button));
			if (buttonId > integerId){
				buttonId = buttonId;
			}
			else {
				buttonId = integerId;
				FormWidgetFactory.getInstance().setButtonId(buttonId);
			}
		     ViewCollection.getInstance().addView(button);
		}
		else if (choice == 1) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			TextView textView = new TextView(context);
			textView.setId(integerId);
			textView.setText(text);
			textView.setTextColor(Color.WHITE);
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			textView.setLayoutParams(params);
			Home.getHome().getLayout().addView(textView, params);
			textView.setOnTouchListener(new DragListener(textView));
			if (textViewId > integerId){
				textViewId  = textViewId ;
			}
			else {
				textViewId  = integerId;
				FormWidgetFactory.getInstance().setTextViewId(textViewId);
			}
		     ViewCollection.getInstance().addView(textView);
		}
		
		
		else if (choice == 2) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			ToggleButton toggleButton = new ToggleButton(context);
			toggleButton.setId(integerId);
			toggleButton.setText(text);
			toggleButton.setTextColor(Color.WHITE);
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			toggleButton.setLayoutParams(params);
			Home.getHome().getLayout().addView(toggleButton, params);
			toggleButton.setOnTouchListener(new DragListener(toggleButton));
			if (toggleButtonId > integerId){
				toggleButtonId  = toggleButtonId ;
			}
			else {
				toggleButtonId  = integerId;
				FormWidgetFactory.getInstance().setToggleButtonId(toggleButtonId);
			}
		     ViewCollection.getInstance().addView(toggleButton);
		}
		
		else if (choice == 3) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			CheckBox checkBox = new CheckBox(context);
			checkBox.setId(integerId);
			checkBox.setText(text);
			checkBox.setTextColor(Color.WHITE);
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			checkBox.setLayoutParams(params);
			Home.getHome().getLayout().addView(checkBox, params);
			checkBox.setOnTouchListener(new DragListener(checkBox));
			if (checkBoxId > integerId){
				checkBoxId  = checkBoxId ;
			}
			else {
				checkBoxId  = integerId;
				FormWidgetFactory.getInstance().setCheckBoxId(checkBoxId);
			}
		     ViewCollection.getInstance().addView(checkBox);
		}
		
		else if (choice == 4) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			RadioButton radioButton = new RadioButton(context);
			radioButton.setId(integerId);
			radioButton.setText(text);
			radioButton.setTextColor(Color.WHITE);
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			radioButton.setLayoutParams(params);
			Home.getHome().getLayout().addView(radioButton, params);
			radioButton.setOnTouchListener(new DragListener(radioButton));
			if (radioButtonId > integerId){
				radioButtonId  = radioButtonId ;
			}
			else {
				radioButtonId  = integerId;
				FormWidgetFactory.getInstance().setRadioButtonId(radioButtonId);
			}
		     ViewCollection.getInstance().addView(radioButton);
		}
		
		else if (choice == 5) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			ProgressBar progressBar = new ProgressBar(context);
			progressBar.setId(integerId);
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			progressBar.setLayoutParams(params);
			Home.getHome().getLayout().addView(progressBar, params);
			progressBar.setOnTouchListener(new DragListener(progressBar));
			if (progressBarId > integerId){
				progressBarId  = progressBarId ;
			}
			else {
				progressBarId  = integerId;
				FormWidgetFactory.getInstance().setProgressBarId(progressBarId);
			}
		     ViewCollection.getInstance().addView(progressBar);
		}
	
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
