package com.application;

import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.activities.Home;

public class FormWidgetView {
	//F1. Declare form widget factory. 
	private  FormWidgetFactory formWidgetFactory;  
	//F2. Declare Frame layout parameters 
    private FrameLayout.LayoutParams frameLayout; 
    /*F3 Declare a view, named dynamic because it's type will be 
         assigned dynamically using a factory and through inheritance. */
	private View dynamic;

	public FormWidgetView() {
		/*F4. Initialise the form widget factory object 
		      reference by getting the singleton instance of form widget factory. */
		formWidgetFactory  =  FormWidgetFactory.getInstance();
	}

	public void updateView(int choice) {
		//F5. Initialise frame layout parameters. 
	    frameLayout = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	    //F6. Centre the view. 
	    frameLayout.gravity = Gravity.CENTER;
	    //F7. Initialise dynamic to the view based on choice selected by user. 
		dynamic = formWidgetFactory.getView(choice);
		//F8. set the views layout parameters to the previously initialised frame layout parameters. 
		dynamic.setLayoutParams(frameLayout);
		//F9. Add the view to the root layout. 
		Home.getHome().getLayout().addView(dynamic);
		/*F10. Set an on touch listener on the view and pass the view to the listener, 
		       in order to capture the views dimensions. */
		dynamic.setOnTouchListener(new DragListener(dynamic));
		//F11. Ensure the view is long clickable.
		dynamic.setLongClickable(true);
		//F12. Add the view to the view collection. 
	    ViewCollection.getInstance().addView(dynamic);
	}
	
	//F13. Get frame layout. 
	public LayoutParams getParams(){
		return frameLayout;
	}
	
}
