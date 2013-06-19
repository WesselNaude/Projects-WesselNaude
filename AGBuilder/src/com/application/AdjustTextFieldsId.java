package com.application;

import java.util.ArrayList;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

import com.activities.Home;

public class AdjustTextFieldsId {

	private TextFieldsFactory textFieldsFactory;
	private ArrayList<View> Views;
	// A1. Stores the type of edit text i.e. Password.
	private String textType;
	// A2. Flags to determine whether decrementation is necessary.
	private boolean decrementPlainText;
	private boolean decrementPassword;
	private boolean decrementPasswordNumberic;
	private boolean decrementEmail;
	private boolean decrementPhoneNumber;
	private boolean decrementPostalAddress;
	private boolean decrementMultiLineText;
	private boolean decrementTime;
	private boolean decrementDate;
	private boolean decrementNumber;
	private boolean decrementNumberSigned;
	private boolean decrementNumberDecimal;
	// A3. Stores the current total of view id.
	private int countText;
	private int countPassword;
	private int countPasswordNumberic;
	private int countEmail;
	private int countPhoneNumber;
	private int countPostalAddress;
	private int countMultiLineText;
	private int countTime;
	private int countDate;
	private int countNumber;
	private int countNumberSigned;
	private int countNumberDecimal;

	public AdjustTextFieldsId() {
		// A4. Initialise variables in constructor.
		textFieldsFactory = TextFieldsFactory.getInstance();
		Views = ViewCollection.getInstance().getViews();
		decrementPlainText = false;
		decrementPassword = false;
		decrementPasswordNumberic = false;
		decrementEmail = false;
		decrementPhoneNumber = false;
		decrementPostalAddress = false;
		decrementMultiLineText = false;
		decrementTime = false;
		decrementDate = false;
		decrementNumber = false;
		decrementNumberSigned = false;
		decrementNumberDecimal = false;
		countText = 0;
		countPassword = 0;
		countPasswordNumberic = 0;
		countEmail = 0;
		countPhoneNumber = 0;
		countPostalAddress = 0;
		countMultiLineText = 0;
		countTime = 0;
		countDate = 0;
		countNumber = 0;
		countNumberSigned = 0;
		countNumberDecimal = 0;
		textType = "";
	}

	// A5. Checks the type of the view and the text type, and calls the
	// appropriate id refactoring method.
	public void refactorTextFieldsId(View view, String tType) {

		textType = tType;
		if (view.getClass().getSimpleName().equals("EditText")
				&& textType.equalsIgnoreCase("PlainText")) {
			adjustPlainTextId();
		} else if (view.getClass().getSimpleName().equals("EditText")
				&& textType.equalsIgnoreCase("Password")) {
			adjustPasswordId();
		} else if (view.getClass().getSimpleName().equals("EditText")
				&& textType.equalsIgnoreCase("PasswordNumberic")) {
			adjustPasswordNumbericId();
		} else if (view.getClass().getSimpleName().equals("EditText")
				&& textType.equalsIgnoreCase("Email")) {
			adjustEmailId();
		} else if (view.getClass().getSimpleName().equals("EditText")
				&& textType.equalsIgnoreCase("PhoneNumber")) {
			adjustPhoneNumberId();
		} else if (view.getClass().getSimpleName().equals("EditText")
				&& textType.equalsIgnoreCase("PostalAddress")) {
			adjustPostalAddressId();
		} else if (view.getClass().getSimpleName().equals("EditText")
				&& textType.equalsIgnoreCase("MultiLineText")) {
			adjustMultiLineTextId();
		} else if (view.getClass().getSimpleName().equals("EditText")
				&& textType.equalsIgnoreCase("Time")) {
			adjustTimeId();
		} else if (view.getClass().getSimpleName().equals("EditText")
				&& textType.equalsIgnoreCase("Date")) {
			adjustDateId();
		} else if (view.getClass().getSimpleName().equals("EditText")
				&& textType.equalsIgnoreCase("Number")) {
			adjustNumberId();
		} else if (view.getClass().getSimpleName().equals("EditText")
				&& textType.equalsIgnoreCase("NumberSigned")) {
			adjustNumberSignedId();
		} else if (view.getClass().getSimpleName().equals("EditText")
				&& textType.equalsIgnoreCase("NumberDecimal")) {
			adjustNumberDecimalId();
		} else if (view.getClass().getSimpleName()
				.equals("AutoCompleteTextView")) {
			adjustAutoCompleteTextViewId();
		} else if (view.getClass().getSimpleName()
				.equals("MultiAutoCompleteTextView")) {
			adjustMultiAutoCompleteTextViewId();
		}
	}

	public void adjustPlainTextId() {
		// A6. Store plain text id, so that it can be decremented and assigned
		// to the view on the root view, independently from the text fields
		// factory plain text id.
		int plainTextId = textFieldsFactory.getPlainTextId();
		// A7. Create a new edit text view, passing the context to the
		// constructor is mandatory.
		EditText editText = new EditText(Home.getHome().getContext());
		// A8. Loop through the view collection.
		for (View v : Views) {
			// A10. Only operate on the views which are of type edit text.
			if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")) {
				// A11. Cast the view to type edit text and set the new object
				// edit text = to the view.
				editText = (EditText) v;
				// A12. Ensure the edit text is of type plain text
				if (editText.getPrivateImeOptions().equals("PlainText")) {
					// A13. increment the count text variable , this will be
					// used to check for the border case 2 - 1 when the view is
					// deleted.
					countText++;
					// A14. Decrement plain text id, this takes into account the
					// fact that a view has been deleted.
					plainTextId--;
					// A15. Pass the variables to the method plain text.
					plainText(editText, plainTextId);
				}
			}
		}
		// 16. After plainText has adjusted the Id's it is necessary to check
		// the border cases.
		checkPlainTextIdBorderCase();
	}

	// Refer to comments A6 - A16
	public void adjustPasswordId() {
		int passwordId = textFieldsFactory.getPasswordId();
		EditText editText = new EditText(Home.getHome().getContext());
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")) {
				editText = (EditText) v;
				if (editText.getPrivateImeOptions().equals("Password")) {
					countPassword++;
					passwordId--;
					password(editText, passwordId);
				}
			}
		}
		checkPasswordIdBorderCase();
	}

	// Refer to comments A6 - A16.
	public void adjustPasswordNumbericId() {
		int passwordNumericId = textFieldsFactory.getPasswordNumbericId();
		EditText editText = new EditText(Home.getHome().getContext());
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")) {
				editText = (EditText) v;
				if (editText.getPrivateImeOptions().equals("PasswordNumberic")) {
					countPasswordNumberic++;
					passwordNumericId--;
					passwordNumberic(editText, passwordNumericId);
				}
			}
		}
		checkPasswordNumbericIdBorderCase();
	}

	// Refer to comments A6 - A16.
	public void adjustEmailId() {
		int emailId = textFieldsFactory.getEmailId();
		EditText editText = new EditText(Home.getHome().getContext());
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")) {
				editText = (EditText) v;
				if (editText.getPrivateImeOptions().equals("Email")) {
					countEmail++;
					emailId--;
					email(editText, emailId);
				}
			}
		}
		checkEmailIdBorderCase();
	}

	// Refer to comments A6 - A16.
	public void adjustPhoneNumberId() {
		int phoneNumberId = textFieldsFactory.getPhoneNumberId();
		EditText editText = new EditText(Home.getHome().getContext());
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")) {
				editText = (EditText) v;
				if (editText.getPrivateImeOptions().equals("PhoneNumber")) {
					countPhoneNumber++;
					phoneNumberId--;
					phoneNumber(editText, phoneNumberId);
				}
			}
		}
		checkPhoneNumberBorderCase();
	}

	// Refer to comments A6 - A16.
	public void adjustPostalAddressId() {
		int postalAddressId = textFieldsFactory.getPostalAddressId();
		EditText editText = new EditText(Home.getHome().getContext());
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")) {
				editText = (EditText) v;
				if (editText.getPrivateImeOptions().equals("PostalAddress")) {
					countPostalAddress++;
					postalAddressId--;
					postalAddress(editText, postalAddressId);
				}
			}
		}
		checkPostalAddressBorderCase();
	}

	// Refer to comments A6 - A16.
	public void adjustMultiLineTextId() {
		int multiLineTextId = textFieldsFactory.getMultiLineTextId();
		EditText editText = new EditText(Home.getHome().getContext());
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")) {
				editText = (EditText) v;
				if (editText.getPrivateImeOptions().equals("MultiLineText")) {
					countMultiLineText++;
					multiLineTextId--;
					multiLineText(editText, multiLineTextId);
				}
			}
		}
		checkMultiLineTextIdBorderCase();
	}

	// Refer to comments A6 - A16.
	public void adjustTimeId() {
		int timeId = textFieldsFactory.getTimeId();
		EditText editText = new EditText(Home.getHome().getContext());
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")) {
				editText = (EditText) v;
				if (editText.getPrivateImeOptions().equals("Time")) {
					countTime++;
					timeId--;
					time(editText, timeId);
				}
			}
		}
		checkTimeIdBorderCase();
	}

	// Refer to comments A6 - A16.
	public void adjustDateId() {
		int dateId = textFieldsFactory.getDateId();
		EditText editText = new EditText(Home.getHome().getContext());
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")) {
				editText = (EditText) v;
				if (editText.getPrivateImeOptions().equals("Date")) {
					countDate++;
					dateId--;
					date(editText, dateId);
				}
			}
		}
		checkDateIdBorderCase();
	}

	// Refer to comments A6 - A16.
	public void adjustNumberId() {
		int numberId = textFieldsFactory.getNumberId();
		EditText editText = new EditText(Home.getHome().getContext());
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")) {
				editText = (EditText) v;
				if (editText.getPrivateImeOptions().equals("Number")) {
					countNumber++;
					numberId--;
					number(editText, numberId);
				}
			}
		}
		checkNumberIdBorderCase();
	}

	// Refer to comments A6 - A16.
	public void adjustNumberSignedId() {
		int numberSignedId = textFieldsFactory.getNumberSignedId();
		EditText editText = new EditText(Home.getHome().getContext());
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")) {
				editText = (EditText) v;
				if (editText.getPrivateImeOptions().equals("NumberSigned")) {
					countNumberSigned++;
					numberSignedId--;
					numberSigned(editText, numberSignedId);
				}
			}
		}
		checkNumberSignedBorderCase();
	}

	// Refer to comments A6 - A16.
	public void adjustNumberDecimalId() {
		int numberDecimalId = textFieldsFactory.getNumberDecimalId();
		EditText editText = new EditText(Home.getHome().getContext());
		for (View v : Views) {
			if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")) {
				editText = (EditText) v;
				if (editText.getPrivateImeOptions().equals("NumberDecimal")) {
					countNumberDecimal++;
					numberDecimalId--;
					numberDecimal(editText, numberDecimalId);
				}
			}
		}
		checkNumberDecimalIdBorderCase();
	}

	public void adjustAutoCompleteTextViewId() {
		// A17. Create a new auto complete text view, and pass in the context.
		AutoCompleteTextView autoCompleteTextView = new AutoCompleteTextView(
				Home.getHome().getContext());
		// A18. Decrement auto complete text view , in the form text fields
		// factory
		textFieldsFactory.decrementAutoCompleteId();
		/*
		 * A19. Store the auto complete text view id, so that it can be
		 * decremented and assigned to the view on the root view, independently
		 * from the text fields factory auto complete text view id.
		 */
		int autoCompleteId = textFieldsFactory.getAutoCompleteId();
		// A20. Loop through all the views in the view collection.
		for (View v : Views) {
			// A21. Only operate on the views which are of type auto complete
			// text view.
			if (v.getClass().getSimpleName()
					.equalsIgnoreCase("AutoCompleteTextView")) {
				// A22. Cast the view to a auto complete text view and set auto
				// complete text view = to the view.
				autoCompleteTextView = (AutoCompleteTextView) v;
				// A23. Set the text of the auto complete text view.
				autoCompleteTextView.setText("AutoComplete" + autoCompleteId);
				// A24. Set the id of the auto complete text view.
				autoCompleteTextView.setId(autoCompleteId);
				// A25. Set the view to the auto complete text view. replacing
				// the view in the ArrayList.
				v = autoCompleteTextView;
				// A26. Decrement the auto complete text view variable so next
				// pass receives decremented id.
				autoCompleteId--;
			}
			// A27. Invalidate the view to force a redraw.
			v.invalidate();
		}
		// A28. Invalidate the main to force a redraw.
		Home.getHome().getLayout().invalidate();
	}

	// Refer to comments A17 - A28
	public void adjustMultiAutoCompleteTextViewId() {
		MultiAutoCompleteTextView multiAutoCompleteTextView = new MultiAutoCompleteTextView(
				Home.getHome().getContext());
		textFieldsFactory.decrementMultiAutoCompleteId();
		int multiAutoCompleteId = textFieldsFactory.getMultiAutoCompleteId();
		for (View v : Views) {
			if (v.getClass().getSimpleName()
					.equalsIgnoreCase("MultiAutoCompleteTextView")) {
				multiAutoCompleteTextView = (MultiAutoCompleteTextView) v;
				multiAutoCompleteTextView.setText("MultiAutoComplete"
						+ multiAutoCompleteId);
				multiAutoCompleteTextView.setId(multiAutoCompleteId);
				v = multiAutoCompleteTextView;
				multiAutoCompleteId--;
			}
			v.invalidate();
		}
		Home.getHome().getLayout().invalidate();
	}

	public void checkPlainTextIdBorderCase() {
		/*
		 * A29. If decrement plain text flag = true, decrement the plain text id
		 * in the text fields factory. this ensures that when a new view is
		 * added the Id is decremented by one, taking into effect the delete of
		 * the view
		 */
		if (decrementPlainText == true) {
			textFieldsFactory.decrementPlainTextId();
			decrementPlainText = false;
			/*
			 * A30. Count text is increment on each pass of the loop if count
			 * text is = to 1, an additional call to decrement is necessary to
			 * get text fields factory plain text id back to 0
			 */
			if (countText == 1) {
				textFieldsFactory.decrementPlainTextId();
			}
		}
	}

	// Refer to comments A29 - A30.
	public void checkPasswordIdBorderCase() {
		if (decrementPassword == true) {
			textFieldsFactory.decrementPasswordId();
			decrementPassword = false;
			if (countPassword == 1) {
				textFieldsFactory.decrementPasswordId();
			}
		}
	}

	// Refer to comments A29 - A30.
	public void checkPasswordNumbericIdBorderCase() {
		if (decrementPasswordNumberic == true) {
			textFieldsFactory.decrementPasswordNumbericId();
			decrementPasswordNumberic = false;
			if (countPasswordNumberic == 1) {
				textFieldsFactory.decrementPasswordNumbericId();
			}
		}
	}

	// Refer to comments A29 - A30.
	public void checkEmailIdBorderCase() {
		if (decrementEmail == true) {
			textFieldsFactory.decrementEmailId();
			decrementEmail = false;
			if (countEmail == 1) {
				textFieldsFactory.decrementEmailId();
			}
		}
	}

	// Refer to comments A29 - A30.
	public void checkPhoneNumberBorderCase() {
		if (decrementPhoneNumber == true) {
			textFieldsFactory.decrementPhoneNumberId();
			decrementPhoneNumber = false;
			if (countPhoneNumber == 1) {
				textFieldsFactory.decrementPhoneNumberId();
			}
		}
	}

	// Refer to comments A29 - A30.
	public void checkPostalAddressBorderCase() {
		if (decrementPostalAddress == true) {
			textFieldsFactory.decrementPostalAddressId();
			decrementPostalAddress = false;
			if (countPostalAddress == 1) {
				textFieldsFactory.decrementPostalAddressId();
			}
		}
	}

	// Refer to comments A29 - A30.
	public void checkMultiLineTextIdBorderCase() {
		if (decrementMultiLineText == true) {
			textFieldsFactory.decrementMultiLineTextId();
			decrementMultiLineText = false;
			if (countMultiLineText == 1) {
				textFieldsFactory.decrementMultiLineTextId();
			}
		}
	}

	// Refer to comments A29 - A30.
	public void checkTimeIdBorderCase() {
		if (decrementTime == true) {
			textFieldsFactory.decrementTimeId();
			decrementTime = false;
			if (countTime == 1) {
				textFieldsFactory.decrementTimeId();
			}
		}
	}

	// Refer to comments A29 - A30.
	public void checkDateIdBorderCase() {
		if (decrementDate == true) {
			textFieldsFactory.decrementDateId();
			decrementDate = false;
			if (countDate == 1) {
				textFieldsFactory.decrementDateId();
			}
		}
	}

	// Refer to comments A29 - A30.
	public void checkNumberIdBorderCase() {
		if (decrementNumber == true) {
			textFieldsFactory.decrementNumberId();
			decrementNumber = false;
			if (countNumber == 1) {
				textFieldsFactory.decrementNumberId();
			}
		}
	}

	// Refer to comments A29 - A30.
	public void checkNumberSignedBorderCase() {
		if (decrementNumberSigned == true) {
			textFieldsFactory.decrementNumberSignedId();
			decrementNumberSigned = false;
			if (countNumberSigned == 1) {
				textFieldsFactory.decrementNumberSignedId();
			}
		}
	}

	// Refer to comments A29 - A30.
	public void checkNumberDecimalIdBorderCase() {
		if (decrementNumberDecimal == true) {
			textFieldsFactory.decrementNumberDecimalId();
			decrementNumberDecimal = false;
			if (countNumberDecimal == 1) {
				textFieldsFactory.decrementNumberDecimalId();
			}
		}
	}

	public void plainText(EditText editText, int plainTextId) {
		// A31. Set the text of the view.
		editText.setText("Plain Text" + plainTextId);
		// A32. Set the id of the view.
		editText.setId(plainTextId);
		// A33. Set the decrement flag to true.
		decrementPlainText = true;
	}

	// Refer to comments A31 - A33.
	public void password(EditText editText, int passwordId) {
		editText.setText("Password" + passwordId);
		editText.setId(passwordId);
		decrementPassword = true;
	}

	// Refer to comments A31 - A33.
	public void passwordNumberic(EditText editText, int passwordNumbericId) {
		editText.setText("Password Numeric" + passwordNumbericId);
		editText.setId(passwordNumbericId);
		decrementPasswordNumberic = true;
	}

	// Refer to comments A31 - A33.
	public void email(EditText editText, int emailId) {
		editText.setText("Email" + emailId);
		editText.setId(emailId);
		decrementEmail = true;
	}

	// Refer to comments A31 - A33.
	public void phoneNumber(EditText editText, int phoneNumberId) {
		editText.setText("PhoneNumber" + phoneNumberId);
		editText.setId(phoneNumberId);
		decrementPhoneNumber = true;
	}

	// Refer to comments A31 - A33.
	public void postalAddress(EditText editText, int postalAddressId) {
		editText.setText("PostalAddress" + postalAddressId);
		editText.setId(postalAddressId);
		decrementPostalAddress = true;
	}

	// Refer to comments A31 - A33.
	public void multiLineText(EditText editText, int multiLineTextId) {
		editText.setText("MultiLineText" + multiLineTextId);
		editText.setId(multiLineTextId);
		decrementMultiLineText = true;
	}

	// Refer to comments A31 - A33.
	public void time(EditText editText, int timeId) {
		editText.setText("Time" + timeId);
		editText.setId(timeId);
		decrementTime = true;
	}

	// Refer to comments A31 - A33.
	public void date(EditText editText, int dateId) {
		editText.setText("Date" + dateId);
		editText.setId(dateId);
		decrementDate = true;
	}

	// Refer to comments A31 - A33.
	public void number(EditText editText, int numberId) {
		editText.setText("Number" + numberId);
		editText.setId(numberId);
		decrementNumber = true;
	}

	// Refer to comments A31 - A33.
	public void numberSigned(EditText editText, int numberSignedId) {
		editText.setText("NumberSigned" + numberSignedId);
		editText.setId(numberSignedId);
		decrementNumberSigned = true;
	}

	// Refer to comments A31 - A33.
	public void numberDecimal(EditText editText, int numberDecimalId) {
		editText.setText("NumberDecimal" + numberDecimalId);
		editText.setId(numberDecimalId);
		decrementNumberDecimal = true;
	}
}
