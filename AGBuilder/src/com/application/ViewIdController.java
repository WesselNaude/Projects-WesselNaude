package com.application;

import android.view.View;

public class ViewIdController {

   //V1. Declare view id adjustment classes.
   private AdjustFormWidgetId adjustFormWidgetId;
   private AdjustTimeDateId adjustTimeDateId;
   private AdjustTextFieldsId adjustTextFieldsId;
   //V2. Declare string className, will be used to store the class name and determine  correct adjustment pass. 
   private String className;
   //V3. Declare string textType, will be used to store the textType and passed to text fields adjustment class for further processing. 
   private String textType;

	public ViewIdController (){
		//V4. Initialise variables. 
	     adjustFormWidgetId = new AdjustFormWidgetId();
	     adjustTimeDateId = new AdjustTimeDateId();
	     adjustTextFieldsId = new AdjustTextFieldsId();
	     className = "";
	     textType = "";
	}
	
	public void MaintainViewId(View view){
		//V5. Initialise className to the name of the class passed to the method. 
		className = view.getClass().getSimpleName();
		//V6. Check if view is a form widget, and pass to form widget id adjustment class for further processing. 
		if(className.equalsIgnoreCase("Button") || className.equalsIgnoreCase("TextView")  || className.equalsIgnoreCase("ToggleButton") ||  
				className.equalsIgnoreCase("CheckBox") || className.equalsIgnoreCase("RadioButton") || className.equalsIgnoreCase("ProgressBar")){
			 adjustFormWidgetId.refactorFormWidgetId(view);
			
		}
		//V7. Check if view is a time date view, and pass to the  adjust time date class for further processing.  
		else if(className.equalsIgnoreCase("TimePicker") || className.equalsIgnoreCase("Chronometer")  || className.equalsIgnoreCase("AnalogClock") ||  
				className.equalsIgnoreCase("DigitalClock")){
			 adjustTimeDateId.refactorTimeDateId(view);
			
		}
		//V8. Check if view is of type edit text,  to pass to adjust text fields id class for further processing. 
		else if(className.equalsIgnoreCase("EditText") || className.equalsIgnoreCase("AutoCompleteTextView")  || className.equalsIgnoreCase("MultiAutoCompleteTextView")) {
			//V9. Additional parameter passed to adjust text fields id class, used do determine type of edit text. 
			adjustTextFieldsId.refactorTextFieldsId(view, textType);
			
		}
	}
	//V10. Setter used to set edit text type by Utility menu class. 
	public void editTextType (String tType){
		textType = tType;}
}
		
		
	
		
		
		
		
	

	
	
	

	
	
	


