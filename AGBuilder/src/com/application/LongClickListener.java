package com.application;

import android.view.View;
import android.view.View.OnLongClickListener;

public class LongClickListener implements OnLongClickListener {
	//L1. Drag Listener object reference. 
	private DragListener myDragListener;
	//L2. Initialise handle. 
	private boolean handle;
	//L3. Initialise utility menu object reference. 
	private UtilityMenu utilityMenu;
    /*L4. Long click listener constructor arguments require a view, so that the type  can be 
	   determined view collection for deletion and ID refactoring/maintenance. */
	public LongClickListener(View v, DragListener thisDragListener) {
		//L5. Initialise drag listener. 
		myDragListener = thisDragListener;
		//L6 Initialise utility menu and pass in the view supplied in the arguments.
		utilityMenu = new UtilityMenu(v);
	}

	public boolean onLongClick(View v) {
		//L7. Get the handle from the initialised drag listener. 
		handle = myDragListener.getHandle();
		/*L8. If the handle is false, long click will not 
		      react allowing the utility menu to behave in the desired way. */ 
		if (handle == false) {
			utilityMenu.showMenu();
			return true;
		}
		return true;
	}
}
