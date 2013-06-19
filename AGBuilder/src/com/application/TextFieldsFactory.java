package com.application;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

import com.activities.Home;

public class TextFieldsFactory {
	//T1. Declare view id's.
	private int plainTextId;
	private int passwordId;
	private int passwordNumbericId;
	private int emailId;
	private int phoneNumberId;
	private int postalAddressId;
	private int multiLineTextId;
	private int timeId;
	private int dateId;
	private int numberId;
	private int numberSignedId;
	private int numberDecimalId;
	private int autoCompleteId;
	private int multiAutoCompleteId;
	//T2. Declare Context. 
	private Context context;
	//T3. Declare Static form widget factory instance. 
	private static TextFieldsFactory uniqueInstance;
	   /*T4. Singleton design pattern, initialises text fields factory object reference, 
             return unique instance (text fields factory) if none has been initialised else returns initialised unique instance. */
	public static TextFieldsFactory getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new TextFieldsFactory();
		}
		return uniqueInstance;
	}
	
	private TextFieldsFactory() {
		//T5. Initialise ID's to 0.
		plainTextId = 0;
		passwordId = 0;
		passwordNumbericId = 0;
		emailId = 0;
		phoneNumberId = 0;
		postalAddressId = 0;
		multiLineTextId = 0;
		timeId = 0;
		dateId = 0;
		numberId = 0;
		numberSignedId = 0;
		numberDecimalId = 0;
		autoCompleteId = 0;
		multiAutoCompleteId = 0;
		//T6. Initialise context to home's context.
		context = Home.getHome().getContext();
	}
	 //T7. Object Factory, returns the requested view based on the integer value passed to the method. 
	public View getView(int choice) {

		if (choice == 0) {
			//T8. Increment view id. 
			plainTextId++;
			//T9. Pass home context to view constructor. 
			EditText plainText = new EditText(context);
			//T10 Set the view id to previously incremented id. 
			plainText.setId(plainTextId);
			/*T11. Set the text to the type of of view + the incremented id, could also be done  via plainText.setText(plainText.getClass.getSimpleName), however
			  I find this solution more visually appealing and easier to understand.*/
			plainText.setText("Plain Text" + plainTextId);
			//T12. Set the text colour of the view. 
			plainText.setTextColor(Color.WHITE);
			//T13. Set private ime options, which is being used to detirmine the type of editText in the view collection, and adjustTextFieldsId classes.
		    plainText.setPrivateImeOptions("PlainText");
		    //T14. Return the view.
			return plainText;
		}

		// Refer to comment T8 - T14
		if (choice == 1) {
			EditText password = new EditText(context);
			passwordId++;
			password.setId(passwordId);
			password.setText("Password" + passwordId);
			password.setInputType(1);
			password.setTextColor(Color.WHITE);
			password.setPrivateImeOptions("Password");
			return password;

		}
		// Refer to comment T8 - T14
		if (choice == 2) {
			EditText passwordNumberic = new EditText(context);
			passwordNumbericId++;
			passwordNumberic.setId(passwordNumbericId);
			passwordNumberic.setText("Password Numeric" + passwordNumbericId);
			passwordNumberic.setInputType(2);
			passwordNumberic.setTextColor(Color.WHITE);
			passwordNumberic.setPrivateImeOptions("PasswordNumberic");
			return passwordNumberic;

		}
		// Refer to comment T8 - T14
		if (choice == 3) {
			EditText email = new EditText(context);
			emailId++;
			email.setId(emailId);
			email.setText("Email" + emailId);
			email.setInputType(3);
			email.setTextColor(Color.WHITE);
			email.setPrivateImeOptions("Email");
			return email;

		}
		// Refer to comment T8 - T14
		if (choice == 4) {
			EditText phoneNumber = new EditText(context);
			phoneNumberId++;
			phoneNumber.setId(phoneNumberId);
			phoneNumber.setText("PhoneNumber" + phoneNumberId);
			phoneNumber.setInputType(4);
			phoneNumber.setTextColor(Color.WHITE);
			phoneNumber.setPrivateImeOptions("PhoneNumber");
			return phoneNumber;
		}
		// Refer to comment T8 - T14
		if (choice == 5) {
			EditText postalAddress = new EditText(context);
			postalAddressId++;
			postalAddress.setId(postalAddressId);
			postalAddress.setText("PostalAddress" + postalAddressId);
			postalAddress.setInputType(5);
			postalAddress.setTextColor(Color.WHITE);
			postalAddress.setPrivateImeOptions("PostalAddress");
			return postalAddress;
		}
		// Refer to comment T8 - T14
		if (choice == 6) {
			EditText multiLineText = new EditText(context);
			multiLineTextId++;
			multiLineText.setId(multiLineTextId);
			multiLineText.setText("MultiLineText" + multiLineTextId);
			multiLineText.setInputType(6);
			multiLineText.setTextColor(Color.WHITE);
			multiLineText.setPrivateImeOptions("MultiLineText");
			return multiLineText;
		}
		// Refer to comment T8 - T14
		if (choice == 7) {
			EditText time = new EditText(context);
			timeId++;
			time.setId(timeId);
			time.setText("Time" + timeId);
			time.setInputType(7);
			time.setTextColor(Color.WHITE);
			time.setPrivateImeOptions("Time");
			return time;
		}
		// Refer to comment T8 - T14
		if (choice == 8) {
			EditText date = new EditText(context);
			dateId++;
			date.setId(dateId);
			date.setText("Date" + dateId);
			date.setInputType(8);
			date.setTextColor(Color.WHITE);
			date.setPrivateImeOptions("Date");
			return date;
		}
		// Refer to comment T8 - T14
		if (choice == 9) {
			EditText number = new EditText(context);
			numberId++;
			number.setId(numberId);
			number.setText("Number" + numberId);
			number.setInputType(9);
			number.setTextColor(Color.WHITE);
			number.setPrivateImeOptions("Number");	
			return number;
		}
		// Refer to comment T8 - T14
		if (choice == 10) {
			EditText numberSigned = new EditText(context);
			numberSignedId++;
			numberSigned.setId(numberSignedId);
			numberSigned.setText("NumberSigned" + numberSignedId);
			numberSigned.setInputType(10);
			numberSigned.setTextColor(Color.WHITE);
			numberSigned.setPrivateImeOptions("NumberSigned");	
			return numberSigned;
		}
		// Refer to comment T8 - T14
		if (choice == 11) {
			EditText numberDecimal = new EditText(context);
			numberDecimalId++;
			numberDecimal.setId(numberDecimalId);
			numberDecimal.setText("NumberDecimal" + numberDecimalId);
			numberDecimal.setInputType(11);
			numberDecimal.setTextColor(Color.WHITE);
			numberDecimal.setPrivateImeOptions("NumberDecimal");	
			return numberDecimal;
		}
        
		if (choice == 12) {
			//T15. Set's the context to home's context. 
			AutoCompleteTextView autoComplete = new AutoCompleteTextView(context);
			//T16. Increment VIEW id.
			autoCompleteId++;
			//T17 View constructor requires context for instantiation. 
			autoComplete.setId(autoCompleteId);
			/*T18. Set the text to the type of of view + the incremented id*/
			autoComplete.setText("AutoComplete" + autoCompleteId);
			//T19. Set the text colour of the view. 
			autoComplete.setTextColor(Color.WHITE);
			//T20. Return the view.
			return autoComplete;
		}
		// Refer to comment T15 - T20
		if (choice == 13) {
			MultiAutoCompleteTextView multiAutoComplete = new MultiAutoCompleteTextView(context);
			multiAutoCompleteId++;
			multiAutoComplete.setId(multiAutoCompleteId);
			multiAutoComplete.setText("MultiAutoComplete" + multiAutoCompleteId);
			multiAutoComplete.setTextColor(Color.WHITE);
			return multiAutoComplete;
		}
		return null;
	}
	//T21. Get View Id
	public int getPlainTextId(){
		return plainTextId;
	}
	// Refer to comment T21. 
	public int getPasswordId(){
		return passwordId;
	}
	// Refer to comment T21. 
	public int getPasswordNumbericId(){
		return passwordNumbericId;
	}
	// Refer to comment T21. 
	public int getEmailId(){
		return emailId;
	}
	// Refer to comment T21. 
	public int getPhoneNumberId(){
		return phoneNumberId;
	}
	// Refer to comment T21. 
	public int getPostalAddressId(){
		return postalAddressId;
	}
	// Refer to comment T21. 
	public int getMultiLineTextId(){
		return multiLineTextId;
	}
	// Refer to comment T21. 
	public int getTimeId(){
		return timeId;
	}
	// Refer to comment T21. 
	public int getDateId(){
		return dateId;
	}
	// Refer to comment T21. 
	public int getNumberId(){
		return numberId;
	}
	// Refer to comment T21. 
	public int getNumberSignedId(){
		return numberSignedId;
	}
	// Refer to comment T21. 
	public int getNumberDecimalId(){
		return numberDecimalId;
	}
	// Refer to comment T21. 
	public int getAutoCompleteId(){
		return autoCompleteId;
	}
	// Refer to comment T21. 
	public int getMultiAutoCompleteId(){
		return multiAutoCompleteId;
	}
	/*T22. Decrement the view id variable,
	  used to maintain the list view and view text on root view when user deletes a view*/
	public void decrementPlainTextId() {
		plainTextId--;
	}
	// Refer to comment T22. 
	public void decrementPasswordId() {
		passwordId--;
	}
	// Refer to comment T22.  
	public void decrementPasswordNumbericId() {
		passwordNumbericId--;
	}
	// Refer to comment T22. 
	public void decrementEmailId() {
		emailId--;
	}
	// Refer to comment T22. 
	public void decrementPhoneNumberId() {
		phoneNumberId--;
	}
	// Refer to comment T22. 
	public void decrementPostalAddressId() {
		postalAddressId--;
	}
	// Refer to comment T22. 
	public void decrementMultiLineTextId() {
		multiLineTextId--;
	}
	// Refer to comment T22. 
	public void decrementTimeId() {
		timeId--;
	}
	// Refer to comment T22. 
	public void decrementDateId() {
		dateId--;
	}
	// Refer to comment T22. 
	public void decrementNumberId() {
		numberId--;
	}
	// Refer to comment T22. 
	public void decrementNumberSignedId() {
		numberSignedId--;
	}
	// Refer to comment T22. 
	public void decrementNumberDecimalId() {
		numberDecimalId--;
	}
	// Refer to comment T22. 
	public void decrementAutoCompleteId() {
		autoCompleteId --;
	}
	// Refer to comment T22. 
	public void decrementMultiAutoCompleteId(){
		multiAutoCompleteId --;
	}
	
	public void setEditTextId(int id){
		plainTextId = id;
	}
	
	public void setPasswordId(int id){
		passwordId = id;
	}
	
	public void setPasswordNumbericId(int id){
			passwordNumbericId = id;
	}
	
	public void setEmailId(int id) {
		emailId = id;
	}
	
	public void setPhoneNumberId(int id) {
		phoneNumberId = id;
	}
	
	public void setPostalAddressId(int id) {
		postalAddressId = id;
	}
	
	public void setMultiLineTextId(int id) {
		multiLineTextId = id;
	}
	
	public void setTimeId(int id) {
		timeId = id;
	}
	
	public void setDateId(int id) {
		dateId = id;
	}
	
	public void setNumberId(int id) {
		numberId = id;
	}
	
	public void setNumberSignedId(int id) {
		numberSignedId = id;
	}
	
	public void setNumberDecimalId(int id) {
		numberDecimalId = id;
	}
	
	public void setAutoCompleteId(int id) {
		autoCompleteId = id;
	}
	
	public void setMultiAutoCompleteId(int id){
		multiAutoCompleteId = id;
	}
	
	public void uninitializeIds(){
		plainTextId = 0;
		passwordId = 0;
		passwordNumbericId = 0;
		emailId = 0;
		phoneNumberId = 0;
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
