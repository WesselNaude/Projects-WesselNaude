package com.application;

import android.app.Activity;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

import com.activities.Home;

public class DragCollisionDetection {
	private int rootBottom;
	private int HeighOffset;
	private int initialWidth;
	private int initialHeight;
	private boolean isWidthChanged;
	private boolean isHeightChanged;

	public DragCollisionDetection() {
	//D1. Root bottom initialised to bottom of home layout
		rootBottom = Home.getHome().getLayout().getBottom();
	/*D2. Height offset initialised to the height of the display - the root bottom, this 
	is necessary to create a border that takes into account the distance between the root layout and the entire height of the screen*/
		HeighOffset = getDisplayHeight() - rootBottom;
	//D3. Flag to check if the views width has already been initialised 
		isWidthChanged = false;
	//D4. Flag to check if the views height has already been initialised 
		isHeightChanged = false;
	}
   
	public void createTopBorder(View v, LayoutParams params) {
	//D5. Checks views top Co-ordinates relative to the root view.    
		if (v.getTop() < 0) {
		//D6. If top is less then 0 set it to 0	creating a top border. 
			v.setTop(0);	
    //D7. Set the top margin of the views parameters to the new top 0.  		
			params.topMargin = v.getTop();
	//D8. Set the views parameters to the updated parameters. 
			v.setLayoutParams(params);
		}
	}
	// Refer to comments D5 - D8
	public void createBottomBorder(View v, LayoutParams params) {
		if (v.getTop() > (rootBottom - HeighOffset)) {
			v.setTop(rootBottom - HeighOffset);
			params.topMargin = v.getTop();
			v.setLayoutParams(params);
		}
	}
	
	public void createLeftBorder(View v, LayoutParams params) {
	//D9. Checks views top Co-ordinates relative to the root view. 
		if (v.getLeft() < 0) {
		//D10. If left is less then 0 set it to 0 creating a left border	
			v.setLeft(0);
	//D11. Set the left margin of the views parameters to the new left 0 
			params.leftMargin = v.getLeft();
	//D12. Set the views parameters to the updated parameters. 
			v.setLayoutParams(params);
		}
	}
	//Refer to comments D9 - D12
	public void createRightBorder(View v, LayoutParams params) {
		int RightBorder = Home.getHome().getLayout().getRight() - getInitialWidth();
		if (v.getLeft() > RightBorder) {
			v.setLeft(RightBorder);
			params.leftMargin = v.getLeft();
			v.setLayoutParams(params);
		}
	}
	
    //D13. Get the height of the display 
	public int getDisplayHeight() {
	//D14. Declare and initialise an initial display height of 0. 	
		int displayHeight = 0;
	//D15. Create display object, get home activity, and get default display, this display returns information relevant to this activity (Home)
		Display display = Home.getActivity().getWindowManager().getDefaultDisplay();
	//D16. Set displayHeight to the height returned by the display object. 
		displayHeight = display.getHeight();
	//D17. Return the updated display height. 	
		return displayHeight;
	}
    
	/*D18. Flag method necessary to ensure view doesn't re-adjust it's width against borders. 
	 This method is called by DragListener, this ensures every view has it's own initial width*/
	public int setInitialWidth(View v) {
		if (isWidthChanged == false) {
	//D19. Set initialWidth to the width of the view
			this.initialWidth = v.getWidth();
    //D20. Set the flag to true
			isWidthChanged = true;
	//D21. Return the updated initial width of the view.  		
			return initialWidth;
		} else
	//D22. Return the original width of the view, initialised on the initial call to this method. 		
			return initialWidth;
	}
	
	//Refer to comments D18 - D22
	public int setInitialHeight(View v) {
		if (isHeightChanged == false) {
			this.initialHeight = v.getHeight();

			isHeightChanged = true;
			return initialHeight;
		} else
			return initialHeight;
	}
    //D23. Get initial width. 
	public int getInitialWidth() {
		return initialWidth;
	}
   //D24. Get initial height. 
	public int getInitialHeight() {
		return initialHeight;
	}
}
