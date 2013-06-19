package com.application;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.FrameLayout;

import com.activities.Home;

public class FormWidgetRebuildFactory {
/*
	private Context context;
	private static  boolean hasHappened = false;

	public FormWidgetRebuildFactory() {
		context = Home.getHome().getLayout().getContext();
	
	}

	public void getView() {

	}

	public void Rebuild(String Class, int Id, int left, int top, int right,
			int bottom, int width, int height) {

		if (Class.equalsIgnoreCase("Button")) {
			hasHappened = true;
			Button button = new Button(context);
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, height);
			
			
			button.setRight(right);
			button.setLeft(left);
			button.setTop(top);
			button.setBottom(bottom);
		    
			button.setId(Id);
			button.setText("Button" + Id);
			button.setTextColor(Color.WHITE);
			button.setLayoutParams(params);
			Home.getHome().getLayout().addView(button);
			button.setOnTouchListener(new DragListener(button));
			
			//Log.d("Top : ",Integer.toString(top));
			//Log.d("Left is : ",Integer.toString(left));
			//Log.d("Bottom bottom is : ",Integer.toString(bottom));
			//Log.d("Right is : ",Integer.toString(right));
			//Log.d("Width is : ",Integer.toString(width));
			//Log.d("Height is : ",Integer.toString(height));
			//Log.d("Button top is : ",Integer.toString(button.getTop()));
			//Log.d("Button left is : ",Integer.toString(button.getLeft()));
			//Log.d("Button bottom is : ",Integer.toString(button.getBottom()));
			//Log.d("Button right is : ",Integer.toString(button.getRight()));
			//Log.d("Button with is : ",Integer.toString(button.getWidth()));
			//Log.d("Button heigh is : ",Integer.toString(button.getHeight()));
			/*Button c = new Button(context);
			FrameLayout.LayoutParams test = new FrameLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			test.gravity = Gravity.CENTER;
			c.setId(145);
			c.setText("Test" + Id);
			c.setTextColor(Color.WHITE);
			c.setLayoutParams(test);
			c.setVisibility(View.VISIBLE);
			Home.getLayout().addView(c);
			c.setOnTouchListener(new MyDragListener(c));

			// ViewCollection.getInstance().displayDetails();

			// button.setLeft(left);
			// button.setTop(top);
			// button.setRight(right);
			// button.setBottom(bottom);

			// button.setHeight(height);
			// button.setWidth(height);
 *//*
		}
	}
	
	
public boolean hasHappaned (){
	return hasHappened;
}
	
	*/
	
	
	
}

/*
 * getView(); while (ViewCollection.getInstance().iterator().hasNext()) { View v
 * = ViewCollection.getInstance().iterator().next(); if ( v.getId() ==
 * button.getId()&&
 * v.getClass().getSimpleName().equalsIgnoreCase(button.getClass
 * ().getSimpleName()) && v.hashCode() != button.hashCode()) {
 * button.setLayoutParams(v.getLayoutParams());
 * 
 * params = v.getLayoutParams(); button.setLayoutParams(params);
 * //ViewCollection.getInstance().removeView(v);
 * ViewCollection.getInstance().addView(button);
 * 
 * 
 * //Home.getLayout().removeView(v); //Home.getLayout().addView(button);
 * Home.getLayout().postInvalidate();
 * ViewCollection.getInstance().removeView(v);
 * Log.d("There are his many views in the array",
 * v.getClass().getSimpleName().toString() +
 * button.getClass().getSimpleName().toString() );
 * 
 * Log.d("There are his many views", v.getClass().getSimpleName().toString() );
 * Log.d("Rebuilt Top is: ",Integer.toString(button.getTop()));
 * 
 * //Home.getLayout().invalidate(); /* Log.d("Params are: ",
 * Integer.toString(params.leftMargin) +" " +Integer.toString(params.topMargin)
 * +" "+ Integer.toString(params.rightMargin) +" "+
 * Integer.toString(params.bottomMargin));
 */
// } */
// }

// for (View v: Views) {
// if (v.getId() == button.getId() &&
// v.getClass().getSimpleName().equalsIgnoreCase(button.getClass().getSimpleName())
// &&
// v.hashCode() != button.hashCode() ){
// ViewCollection.getInstance().removeView(v);
// }}
// ViewCollection.getInstance().displayDetails();

// button.setOnTouchListener(new MyDragListener(button));
// ViewCollection.getInstance().test();
// return button;
// }

// return null;
// }
/*
 * public LayoutParams setParams(int width, int height) { frameLayout = new
 * FrameLayout.LayoutParams(width, height); return frameLayout; }
 */

// }
