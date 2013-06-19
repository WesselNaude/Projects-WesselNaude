package com.application;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ToggleButton;
import android.widget.FrameLayout.LayoutParams;

import com.activities.Home;

public class LoadTextFields {
	private LayoutParams params;
	private Context context;
	private int editTextId = 0;
	private int passwordId = 0;
	private int passwordNumbericId = 0;
	private int emailId = 0;		
	private int phoneId = 0;
	private int postalAddressId = 0;
	private int multiLineTextId = 0;
	private int timeId = 0;
	private int dateId = 0;
	private int numberId = 0;
	private int numberSignedId =0;
	private int numberDecimalId = 0;
	private int autoCompleteId = 0;
	private int multiAutoCompleteId = 0;
	private static LoadTextFields uniqueInstance;
	

	
	public static LoadTextFields getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new  LoadTextFields();
		}
		return uniqueInstance;
	}
	
	private LoadTextFields(){}
	
	public void getView(int choice, int integerId, int integerWidth, int integerHeight, int integerLayoutX, int integerLayoutY, String text ) {

		if (choice == 0) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			EditText editText = new EditText(context);
			editText.setId(integerId);
			editText.setText(text);
			editText.setTextColor(Color.WHITE);
			editText.setLayoutParams(params);
			editText.setPrivateImeOptions("PlainText");
			editText.setOnTouchListener(new DragListener(editText));
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			if (editTextId > integerId){
				editTextId = editTextId;
			}
			else {
				editTextId = integerId;
				TextFieldsFactory.getInstance().setEditTextId(editTextId);
			}
		     ViewCollection.getInstance().addView(editText);
		     Home.getHome().getLayout().addView(editText, params);
		}
		else if (choice == 1) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			EditText password = new EditText(context);
			password.setId(integerId);
			password.setText("password" + integerId);
			password.setInputType(1);
			password.setTextColor(Color.WHITE);
			password.setPrivateImeOptions("Password");
			password.setOnTouchListener(new DragListener(password));
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			if (passwordId > integerId){
				passwordId = passwordId;
			}
			else {
				passwordId = integerId;
				TextFieldsFactory.getInstance().setPasswordId(passwordId);
			}
		     ViewCollection.getInstance().addView(password);
		     Home.getHome().getLayout().addView(password, params);
		}
		else if (choice == 2) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			EditText passwordNumberic = new EditText(context);
			passwordNumberic.setId(integerId);
			passwordNumberic.setText("Password Numeric" + integerId);
			passwordNumberic.setInputType(2);
			passwordNumberic.setTextColor(Color.WHITE);
			passwordNumberic.setPrivateImeOptions("PasswordNumberic");
			passwordNumberic.setOnTouchListener(new DragListener(passwordNumberic));
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			if (passwordNumbericId > integerId){
				passwordNumbericId = passwordNumbericId;
			}
			else {
				passwordNumbericId = integerId;
				TextFieldsFactory.getInstance().setPasswordNumbericId(passwordNumbericId);
			}
		     ViewCollection.getInstance().addView(passwordNumberic);
		     Home.getHome().getLayout().addView(passwordNumberic, params);
		}
		else if (choice == 3) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			EditText email = new EditText(context);
			email.setId(integerId);
			email.setText("Email" + integerId);
			email.setInputType(3);
			email.setTextColor(Color.WHITE);
			email.setPrivateImeOptions("Email");
			email.setOnTouchListener(new DragListener(email));
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			if (emailId > integerId){
				emailId = emailId;
			}
			else {
				emailId = integerId;
				TextFieldsFactory.getInstance().setEmailId(emailId);
			}
		     ViewCollection.getInstance().addView(email);
		     Home.getHome().getLayout().addView(email, params);
		}
		
		else if (choice == 4) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			EditText phone = new EditText(context);
			phone.setId(integerId);
			phone.setText("PhoneNumber" + integerId);
			phone.setInputType(4);
			phone.setTextColor(Color.WHITE);
			phone.setPrivateImeOptions("PhoneNumber");
			phone.setOnTouchListener(new DragListener(phone));
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			if (phoneId > integerId){
				phoneId = phoneId;
			}
			else {
				phoneId = integerId;
				TextFieldsFactory.getInstance().setPhoneNumberId(phoneId);
			}
		     ViewCollection.getInstance().addView(phone);
		     Home.getHome().getLayout().addView(phone, params);
		}
		
		else if (choice == 5) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			EditText postalAddress = new EditText(context);
			postalAddress.setId(integerId);
			postalAddress.setText("PostalAddress" + + integerId);
			postalAddress.setInputType(5);
			postalAddress.setTextColor(Color.WHITE);
			postalAddress.setPrivateImeOptions("PostalAddress");
			postalAddress.setOnTouchListener(new DragListener(postalAddress));
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			if (postalAddressId > integerId){
				postalAddressId = postalAddressId;
			}
			else {
				postalAddressId = integerId;
				TextFieldsFactory.getInstance().setPostalAddressId(postalAddressId);
			}
		     ViewCollection.getInstance().addView(postalAddress);
		     Home.getHome().getLayout().addView(postalAddress, params);
		}
		
		else if (choice == 6) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			EditText multiLineText = new EditText(context);
			multiLineText.setId(integerId);
			multiLineText.setText("MultiLineText" + + integerId);
			multiLineText.setInputType(6);
			multiLineText.setTextColor(Color.WHITE);
			multiLineText.setPrivateImeOptions("MultiLineText");
			multiLineText.setOnTouchListener(new DragListener(multiLineText));
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			if (multiLineTextId > integerId){
				multiLineTextId = multiLineTextId;
			}
			else {
				multiLineTextId = integerId;
				TextFieldsFactory.getInstance().setMultiLineTextId(multiLineTextId);
			}
		     ViewCollection.getInstance().addView(multiLineText);
		     Home.getHome().getLayout().addView(multiLineText, params);
		}
		
		else if (choice == 7) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			EditText time = new EditText(context);
			time.setId(integerId);
			time.setText("Time" + + integerId);
			time.setInputType(7);
			time.setTextColor(Color.WHITE);
			time.setPrivateImeOptions("Time");
			time.setOnTouchListener(new DragListener(time));
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			if (timeId > integerId){
				timeId = timeId;
			}
			else {
				timeId = integerId;
				TextFieldsFactory.getInstance().setTimeId(timeId);
			}
		     ViewCollection.getInstance().addView(time);
		     Home.getHome().getLayout().addView(time, params);
		}
		else if (choice == 8) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			EditText date = new EditText(context);
			date.setId(integerId);
			date.setText("Date" + + integerId);
			date.setInputType(8);
			date.setTextColor(Color.WHITE);
			date.setPrivateImeOptions("Date");
			date.setOnTouchListener(new DragListener(date));
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			if (dateId > integerId){
				dateId = dateId;
			}
			else {
				dateId = integerId;
				TextFieldsFactory.getInstance().setDateId(dateId);
			}
		     ViewCollection.getInstance().addView(date);
		     Home.getHome().getLayout().addView(date, params);
		}
		
		else if (choice == 9) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			EditText number = new EditText(context);
			number.setId(integerId);
			number.setText("Number" + + integerId);
			number.setInputType(9);
			number.setTextColor(Color.WHITE);
			number.setPrivateImeOptions("Number");
			number.setOnTouchListener(new DragListener(number));
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			if (numberId > integerId){
				numberId = numberId;
			}
			else {
				numberId = integerId;
				TextFieldsFactory.getInstance().setNumberId(numberId);
			}
		     ViewCollection.getInstance().addView(number);
		     Home.getHome().getLayout().addView(number, params);
		}
		
		else if (choice == 10) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			EditText numberSigned = new EditText(context);
			numberSigned.setId(integerId);
			numberSigned.setText("NumberSigned" + + integerId);
			numberSigned.setInputType(10);
			numberSigned.setTextColor(Color.WHITE);
			numberSigned.setPrivateImeOptions("NumberSigned");
			numberSigned.setOnTouchListener(new DragListener(numberSigned));
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			if (numberSignedId > integerId){
				numberSignedId = numberSignedId;
			}
			else {
				numberSignedId = integerId;
				TextFieldsFactory.getInstance().setNumberSignedId(numberSignedId);
			}
		     ViewCollection.getInstance().addView(numberSigned);
		     Home.getHome().getLayout().addView(numberSigned, params);
		}
		else if (choice == 11) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			EditText numberDecimal = new EditText(context);
			numberDecimal.setId(integerId);
			numberDecimal.setText("NumberDecimal" + + integerId);
			numberDecimal.setInputType(11);
			numberDecimal.setTextColor(Color.WHITE);
			numberDecimal.setPrivateImeOptions("NumberDecimal");
			numberDecimal.setOnTouchListener(new DragListener(numberDecimal));
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			if (numberDecimalId > integerId){
				numberDecimalId =numberDecimalId;
			}
			else {
				numberDecimalId = integerId;
				TextFieldsFactory.getInstance().setNumberDecimalId(numberDecimalId);
			}
		     ViewCollection.getInstance().addView(numberDecimal);
		     Home.getHome().getLayout().addView(numberDecimal, params);
		}
		else if (choice == 12) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			AutoCompleteTextView autoComplete = new AutoCompleteTextView(context);
			autoComplete.setId(integerId);
			autoComplete.setText("AutoComplete" + integerId);
			autoComplete.setTextColor(Color.WHITE);
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			autoComplete.setLayoutParams(params);
			Home.getHome().getLayout().addView(autoComplete, params);
			autoComplete.setOnTouchListener(new DragListener(autoComplete));
			if (autoCompleteId > integerId){
				autoCompleteId  = autoCompleteId ;
			}
			else {
				autoCompleteId  = integerId;
			TextFieldsFactory.getInstance().setAutoCompleteId(autoCompleteId);
			}
		     ViewCollection.getInstance().addView(autoComplete);
		}
		else if (choice == 13) {
			params = new FrameLayout.LayoutParams(integerWidth,integerHeight);
			context = Home.getHome().getLayout().getContext();
			MultiAutoCompleteTextView multiAutoComplete = new MultiAutoCompleteTextView(context);
			multiAutoComplete.setId(integerId);
			multiAutoComplete.setText("MultiAutoComplete" + integerId);
			multiAutoComplete.setTextColor(Color.WHITE);
			params.setMargins(integerLayoutX, integerLayoutY, 0, 0);
			multiAutoComplete.setLayoutParams(params);
			Home.getHome().getLayout().addView(		multiAutoComplete, params);
			multiAutoComplete.setOnTouchListener(new DragListener(multiAutoComplete));
			if (multiAutoCompleteId > integerId){
				multiAutoCompleteId  = multiAutoCompleteId ;
			}
			else {
				multiAutoCompleteId  = integerId;
			TextFieldsFactory.getInstance().setMultiAutoCompleteId(multiAutoCompleteId);
			}
		     ViewCollection.getInstance().addView(multiAutoComplete);
		}	
   }
	
	public void uninitializeIds(){
		editTextId = 0;
		passwordId = 0;
		passwordNumbericId = 0;
		emailId = 0;
		phoneId = 0;
		postalAddressId = 0;
		multiLineTextId = 0;
		timeId = 0;
		dateId = 0;
		numberId = 0;
		numberSignedId = 0;
		numberDecimalId = 0;
		autoCompleteId = 0;
		multiAutoCompleteId = 0;
	}
}
