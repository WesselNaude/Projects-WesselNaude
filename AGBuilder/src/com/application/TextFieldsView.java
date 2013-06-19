package com.application;

import com.activities.Home;

import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class TextFieldsView {
	//T1. Declare text fields factory.  
	private  TextFieldsFactory textFieldsFactory;
	//T2. Declare Frame layout parameters 
    private FrameLayout.LayoutParams frameLayout; 
    /*T3 Declare a view, named dynamic because it's type will be 
    assigned dynamically using a factory and through inheritance. */
	private View dynamic;
	
	public TextFieldsView (){
		/*T4. Initialise the text fields factory object 
	      reference by getting the singleton instance of text fields factory. */
		 textFieldsFactory = TextFieldsFactory.getInstance();
		
	}
	
	public void updateView(int choice) {
		//T5. Initialise frame layout parameters. 
	    frameLayout = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	    //T6. Centre the view.
	    frameLayout.gravity = Gravity.CENTER;
	    //T7. Initialise dynamic to the view based on choice selected by user. 
		dynamic = textFieldsFactory.getView(choice);
		//T8. set the views layout parameters to the previously initialised frame layout parameters. 
		dynamic.setLayoutParams(frameLayout);
		//T9. Add the view to the root layout. 
		Home.getHome().getLayout().addView(dynamic);
		/*T10. Set an on touch listener on the view and pass the view to the listener, 
	       in order to capture the views dimensions. */
		dynamic.setOnTouchListener(new DragListener(dynamic));
		//T11. Ensure the view is long clickable.
				dynamic.setLongClickable(true);
		//T12. Add the view to the view collection. 
		ViewCollection.getInstance().addView(dynamic);
		
	}

}