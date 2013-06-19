package com.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.application.R;

public class Menu extends ListActivity {
	LinearLayout layout;
	String classes[] = { "Home", "Save", "Load", "Exit" };
	private static TextView v;

	protected void onCreate(Bundle savedInstanceState) {
		super.setVisible(true);
		super.onCreate(savedInstanceState);
		// M1. Supply Content view XML identifier.
		setContentView(R.layout.list);
		// M2. Supply list adapter context, XML layout identifier, and menu
		// titles, held in classes string array.
		setListAdapter(new ArrayAdapter<String>(Menu.this, R.layout.white_text,
				R.id.list_content, classes));
		// M3. Create a new text view, refer to this class, so that text size
		// can be set.
		v = new TextView(this);
		v.setTextSize(TypedValue.COMPLEX_UNIT_SP, 150);
	}

	// M4. OnItemListClick is called when an item is clicked, provides similar
	// functionality to onClickListener,
	// but allows for additional data to be captured. Google Documentation
	// Definition: The view that was clicked within the ListView position
	// The position of the view in the list id and The row id of the item that
	// was clicked.
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String option = classes[position];
		try {
			Class<?> aClass = Class.forName("com.activities." + option);
			Intent intent = new Intent(Menu.this, aClass);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// M5. Get list text size.
	public static float getTextSize() {
		return v.getTextSize();
	}

}
