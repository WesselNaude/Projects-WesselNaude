package com.application;

import java.util.ArrayList;
import java.util.Iterator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.activities.Home;

public class ViewCollection {
	// V1. Declare view collection.
	private static ViewCollection uniqueInstance;
	// V2. Declare array list of type view.
	private ArrayList<View> Views;
	private Bundle savedData;
	private FormWidgetRebuildFactory factory;
	private boolean change;
	private int left;
	private int top;
	private int right;
	private int bottom;
	private int width;
	private int height;

	// V3. Private constructor, following singleton pattern, to ensure all
	// operations are performed on a single collection in the application.
	private ViewCollection() {

		Views = new ArrayList<View>();
		savedData = new Bundle();
		factory = new FormWidgetRebuildFactory();
	}

	// V4. Return unique instance, if not initialised initialise unique instance
	// and return.
	public static ViewCollection getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ViewCollection();
		}
		return uniqueInstance;
	}

	// V5. Add view to array list using the standard array list add method.
	public void addView(View v) {
		Views.add(v);
	}

	/*
	 * V6. Find a view by id, and class name, then update the coordinates, used
	 * by the drag listener to ensure views in the collection coordinates maintains
	 * accuracy 
	 */
	public void update(View v) {
		for (View view : Views) {
			if (v.getClass().getSimpleName()
					.equals(view.getClass().getSimpleName())
					&& v.getId() == view.getId()) {
				view.setTop(v.getTop());
				view.setLeft(v.getLeft());
			}
		}
	}

	// V7. Delete method uses list iterator to avoid the use of a for loop, and
	// as a result avoid a concurrent modification exception from being thrown.
	public void delete(View v) {
		// V8. Declare and initialise the list iterator, note it is of type view
		// as the collection stores views.
		Iterator<View> iterator = Views.iterator();
		// V9. While loop to access the collection.
		while (iterator.hasNext()) {
			// V10. If statement to check if supplied view is of type edit text.
			if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")) {
				// V11. Try catch block to catch views that are not of edit
				// text.
				try {
					// V12. Cast current element to Edit Text
					EditText a = (EditText) iterator.next();
					// V13. Cast view passed into delete to edit text.
					EditText passedView = (EditText) v;
					// V14. If statement confirms passed view and current
					// element Id's and ime information match for deletion.
					if (passedView.getId() == a.getId()
							&& passedView.getPrivateImeOptions()
									.equalsIgnoreCase(a.getPrivateImeOptions())) {
						// V15. Remove the matched view from the element.
						iterator.remove();
					}
				} catch (ClassCastException exc) {

				}
			} else {
				// V16. Iterator.next to enable remove being called without
				// exception.
				View a = iterator.next();
				// V17. View ID and View Type check to match supplied view to
				// view in list.
				if (a.getClass().getSimpleName()
						.equalsIgnoreCase(v.getClass().getSimpleName())
						&& a.getId() == v.getId()) {
					// V18. Remove the view that match the condition.
					iterator.remove();
				}
			}
		}

		/* Previous technique used, modified to above solution so that views can be
		 * edited in the update ID classes without exceptions. 
		 * if (v.getClass().getSimpleName().equalsIgnoreCase("EditText")){ for
		 * (View view: Views){ EditText passedView = (EditText) v; EditText
		 * listView = (EditText) view; if ( passedView.getId() ==
		 * listView.getId() &&
		 * passedView.getPrivateImeOptions().equalsIgnoreCase
		 * (listView.getPrivateImeOptions())) { Views.remove(listView); } } }
		 * else for (int i = 0; i < Views.size(); i ++) { if
		 * (v.getClass().getSimpleName
		 * ().equals(Views.get(i).getClass().getSimpleName())&& v.getId() ==
		 * (Views.get(i).getId())) { Views.remove(v); i--;
		 * 
		 * } }
		 */
	}
	// Remove all views
	public void DeleteAllViews() {
		if (Views.isEmpty()){
			
		}else {
		Views.removeAll(Views);
		
		}
	}

   //V19. Dislay details method, used for testing. 
	public void displayDetails() {
		for (View view : Views) {
			Log.d("I am ",
					view.getClass().getSimpleName() + " :"
							+ Integer.toString(view.getId()));
		}
	}
   //V20. Get array list method, allows other classes easy access to the collection without modifying the collection. 
	public ArrayList getViews() {
		return Views;
	}
}
