package com.application;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.activities.Home;

public class UtilityMenu extends Activity {
    //U1. Declare View 
	private View view;
	//U2. Declare view id controller. 
    private ViewIdController viewIdController;
    //U3. Declare context. 
    private Context context;
	@SuppressWarnings("static-access")
	/*U4. Utility constructor arguments require a view, this view is then passed
	      to the ViewIdController, which inspects the type of the view and pass it to the appropriate adjust view id class. */
	public UtilityMenu(View v) {
		//U5. Initialise view to the view that was passed to the constructor. 
		view = v;
		viewIdController = new ViewIdController();
		//U6. Initialise context to home's context. 
		context = Home.getHome().getContext();
	}

	public void showMenu() {
		//U7. Declare and initialise a new dialog passing in the initialised context.
		final Dialog dialog = new Dialog(context);
		//U8. Set title to none, as the dialog uses a custom layout
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		//U9. Set dialog layout to the xml file containing the layout.  
		dialog.setContentView(R.layout.utility_menu);
		//10. Declare and initialise button, pointing the button to the appropriate xml identifier.  
		Button delete = (Button) dialog.findViewById(R.id.Delete);
		Button cancel = (Button) dialog.findViewById(R.id.Close);
		//U11. Set cancelable allows the user to press outside dialog to cancel. 
		dialog.setCancelable(true);
		//U12. Show the dialog on the root layout. 
		dialog.show();

		//U13. Set delete button on click listener. 
		delete.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				//U14. Remove the view supplied to the constructor from the root layout. 
				Home.getHome().getLayout().removeView(view);
				//U15. Remove the view supplied to the constructor from the view collection.
				ViewCollection.getInstance().delete(view);
			    //U16. View type confirmation required to pass appropriate arguments to view id controller. 
				if (view.getClass().getSimpleName().equalsIgnoreCase("EditText")){
					//U17. Cast the view to edit text, enabling access edit text methods. 
					EditText editText = (EditText) view;
					//U18. Set view id controller variable edit text type to casted edit text type private ime options. 
					viewIdController.editTextType(editText.getPrivateImeOptions());
					//U19. Supply view id controller method maintain view id with the view to determine  proper view id/ text adjustment. 
					viewIdController.MaintainViewId(view);	
				} else {
					//U20. If view is not edit text, only view is required. 
				viewIdController.MaintainViewId(view);
				}
				//U21. After view has been deleted from root layout, close the dialog. 
				dialog.cancel();
			
			}
		});
       //U22. Set cancel button on click listener.
		cancel.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				//U23. Close dialog.
				dialog.cancel();
			}
		});

	}
}
