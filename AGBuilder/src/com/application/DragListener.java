package com.application;

import android.app.Activity;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.activities.Home;

public class DragListener implements OnTouchListener {
	// D1. Declare DragCollisionDetection reference.
	private DragCollisionDetection collisionDetection;
	private int LayoutHeightOffset;
	private int LayoutWidthOffset;
	private boolean handle = false;
	private static FormWidgetRebuildFactory test;
	private LayoutParams params;
	private Home home;
	private View view;

	public DragListener(View view) {
		home = Home.getHome();
		collisionDetection = new DragCollisionDetection();
		test = new FormWidgetRebuildFactory();
		/*
		 * D2. Set and create long click listener. Pass in the view and the drag
		 * listener to get access to drag listener handle.
		 */
		view.setOnLongClickListener(new LongClickListener(view, this));
	}

	public boolean onTouch(View v, MotionEvent event) {

		//if (ViewCollection.getInstance().change() == false) {
			// D3. Initialise layout parameters.
			params = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			// D4. Set the layout parameters of the view to params.
			v.setLayoutParams(params);
		//} else {
			//params = new FrameLayout.LayoutParams(
			//		(ViewCollection.getInstance().Width()),
			//		(ViewCollection.getInstance().Height()));
			//v.setTop(ViewCollection.getInstance().Top());
			//v.setLeft(ViewCollection.getInstance().Left());
			//v.setRight(ViewCollection.getInstance().Right());
			//v.setBottom(ViewCollection.getInstance().Bottom());
			//v.setLayoutParams(params);
		//}

		// D5. Initialise height offset.
		LayoutHeightOffset = getHeightOffset();
		// D6. Initialise width offset.
		LayoutWidthOffset = getWidthOffset();

		// D7. Pass initial width and height offset to DragCollision detection.
		collisionDetection.setInitialWidth(v);
		collisionDetection.setInitialHeight(v);

		// D8. ViewHeightOffset and WidthHeightOffset of view being dragged.
		// Centres the touch of the view.
		int ViewHeightOffset = v.getHeight() / 2;
		int ViewWidthOffset = v.getWidth() / 2;

		// D9. Force a redraw of the view
		v.postInvalidate();

		// D10. Force a redraw of the root layout.
		Home.getHome().getLayout().postInvalidate();

		// D11.Evaluates to true when the view has been moved.
		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			// D13. Set the handle flag to true, disabling long click so that
			// utility menu does not interfere with user.
			handle = true;
			//if (ViewCollection.getInstance().change() == true) {
			//	v.setTop(ViewCollection.getInstance().Top());
			//	v.setLeft(ViewCollection.getInstance().Left());
			//	v.setRight(ViewCollection.getInstance().Right());
			//	v.setBottom(ViewCollection.getInstance().Bottom());
			//}
			// D14. Remove the layout restrictions of the view assigned in
			// Form/Text/TimeDate view classes used to centre the view.
			params.gravity = Gravity.NO_GRAVITY;

			// D15. Ensure the view is visible.
			v.setVisibility(View.VISIBLE);
			// D16. Set pressed state to true, lighting up the view.
			v.setPressed(true);

			// D17. Update the view parameters as the user drags the view
			if (home.getScroller().isOpen() == false) {
				params.topMargin = (int) event.getRawY()
						- (LayoutHeightOffset + ViewHeightOffset);
				params.leftMargin = (int) event.getRawX()
						- (LayoutWidthOffset + ViewWidthOffset);
			}
			// D18. Update the view parameters as the user drags the view
			// subtracting the width of the side view.
			else {
				params.topMargin = (int) event.getRawY()
						- (LayoutHeightOffset + ViewHeightOffset);
				params.leftMargin = (int) event.getRawX()
						- (LayoutWidthOffset + ViewWidthOffset + home
								.getScroller().getScrollerWidth());

			}

			// D19. Maintain initial width and height of the view to disable re
			// adjusting when encountering a border.
			params.width = collisionDetection.getInitialWidth();
			params.height = collisionDetection.getInitialHeight();

			// D20. Create borders for the view.
			collisionDetection.createTopBorder(v, params);
			collisionDetection.createLeftBorder(v, params);
			collisionDetection.createRightBorder(v, params);
			collisionDetection.createBottomBorder(v, params);
			// D21. Set the layout parameters after the view has been moved.
			v.setLayoutParams(params);
			// D22. Update the view parameters in the collection.
			ViewCollection.getInstance().update(v);
		}

		// D23. Evaluates to true when the users lifts there touch.
		if (event.getAction() == MotionEvent.ACTION_UP) {

			// D24. Set pressed state to false, un highlights the view.
			v.setPressed(false);

			// Refer to comment D17.
			if (home.getScroller().isOpen() == false) {
				params.topMargin = (int) event.getRawY()
						- (LayoutHeightOffset + ViewHeightOffset);
				params.leftMargin = (int) event.getRawX()
						- (LayoutWidthOffset + ViewWidthOffset);
			}
			// Refer to comment D18.
			else {

				params.topMargin = (int) event.getRawY()
						- (LayoutHeightOffset + ViewHeightOffset);
				params.leftMargin = (int) event.getRawX()
						- (LayoutWidthOffset + ViewWidthOffset + home
								.getScroller().getScrollerWidth());

			}

			// Refer to comment D19.
			params.width = collisionDetection.getInitialWidth();
			params.height = collisionDetection.getInitialHeight();

			// Refer to comment D20.
			collisionDetection.createTopBorder(v, params);
			collisionDetection.createLeftBorder(v, params);
			collisionDetection.createRightBorder(v, params);
			collisionDetection.createBottomBorder(v, params);
			// Refer to comment D21
			v.setLayoutParams(params);
			// Refer to comment D22
			ViewCollection.getInstance().update(v);
			// D25. Set the handle to false, re enabling long click listener.
			handle = false;
		}

		// D23. Evaluates to true when the users touches the view.
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			// Refer to comment D14.
			params.gravity = Gravity.NO_GRAVITY;
			// Refer to comment D15.
			v.setVisibility(View.VISIBLE);
			// Refer to comment D16.
			v.setPressed(true);

			// Refer to comment D17.
			if (home.getScroller().isOpen() == false) {
				params.topMargin = (int) event.getRawY()
						- (LayoutHeightOffset + ViewHeightOffset);
				params.leftMargin = (int) event.getRawX()
						- (LayoutWidthOffset + ViewWidthOffset);
			}
			// Refer to comment D18.
			else {

				params.topMargin = (int) event.getRawY()
						- (LayoutHeightOffset + ViewHeightOffset);
				params.leftMargin = (int) event.getRawX()
						- (LayoutWidthOffset + ViewWidthOffset + home
								.getScroller().getScrollerWidth());

			}

			// Refer to comment D19.
			params.width = collisionDetection.getInitialWidth();
			params.height = collisionDetection.getInitialHeight();

			// Refer to comment D20.
			collisionDetection.createTopBorder(v, params);
			collisionDetection.createLeftBorder(v, params);
			collisionDetection.createRightBorder(v, params);
			collisionDetection.createBottomBorder(v, params);
			// Refer to comment D21.
			v.setLayoutParams(params);
			// Refer to comment D22
			ViewCollection.getInstance().update(v);
		}
		// D26. Sets whether this view has been finished processing, can be used
		// by other listeners.
		return false;
	}

	public int getHeightOffset() {
		// D27. Declare and initialise an initial display height of 0.
		int displayHeight = 0;
		// D28. Declare and initialise root height with the height of the root
		// layout.
		int rootHeight = Home.getHome().getLayout().getHeight();
		// D29. Create display object, get home activity, and get default
		// display, this display returns information relevant to this activity
		// (Home).
		Display display = Home.getActivity().getWindowManager()
				.getDefaultDisplay();
		// D30. Set displayHeight to the height returned by the display object.
		displayHeight = display.getHeight();
		// D31. Declare and initialise height offset, calculated by subtracting
		// the display height from the root height.
		int heightOffset = displayHeight - rootHeight;
		// D32. Return height offset.
		return heightOffset;
	}

	public int getWidthOffset() {
		// D33. Declare and initialise an initial display width of 0.
		int displayWidth = 0;
		// D34. Declare and initialise root width with the width of the root
		// layout.
		int rootWidth = Home.getHome().getLayout().getWidth();
		// D35. Create display object, get home activity, and get default
		// display, this display returns information relevant to this activity
		// (Home).
		Display display = Home.getActivity().getWindowManager()
				.getDefaultDisplay();
		// D36. Set displayWidth to the width returned by the display object.
		displayWidth = display.getWidth();
		// D37. Declare and initialise width offset, calculated by subtracting
		// the display width from the root width.
		int widthOffset = displayWidth - rootWidth;
		// D38. Return width offset.
		return widthOffset;
	}

	// D39. Get view height.
	public int getHeight() {
		return view.getHeight();
	}

	// D40. Get the handle flag.
	public boolean getHandle() {
		return handle;
	}
};

/*
 * } else if (test.hasHappaned () == true){
 */

// FrameLayout.LayoutParams params = new
// FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
// LayoutParams.WRAP_CONTENT);
// Log.d("Params are: ", Integer.toString(params.leftMargin) +" "
// +Integer.toString(params.topMargin) +" "+
// Integer.toString(params.rightMargin) +" "+
// Integer.toString(params.bottomMargin));
// ViewCollection.getInstance().addView(v);
// for (View view: Views){
// if (view.getId() == v.getId() &&
// v.getClass().getSimpleName()==view.getClass().getSimpleName()){
// view.setLayoutParams(v.getLayoutParams());

// }
// }
// viewCollection.test();

// Log.d("Stored HeightOffset", Integer.toString(LayoutHeightOffset));
// Log.d("Stored WidthOffset", Integer.toString(LayoutWidthOffset));
// Log.d("Dynamic heightOffset", Integer.toString(getHeightOffset()));
// Log.d("Dynamic WidthOffset", Integer.toString(getWidthOffset()));

// Log.d("Up top is: ",Integer.toString(v.getTop()));
// Log.d("Up Left is: ",Integer.toString(v.getLeft()));

/*
 * } else if (test.hasHappaned() == true){
 * 
 * params.topMargin = (int) event.getRawY() - (LayoutHeightOffset +
 * ViewHeightOffset); params.leftMargin = (int) event.getRawX() -
 * (LayoutWidthOffset + ViewWidthOffset);
 */
