package com.application;

import java.util.ArrayList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.activities.Home;
import com.slidelayout.MenuAdapter;

public class HomeModel {
	//H1. Declare menu titles string array.
	private final String[] menuTitles;
	//H2. Declare list view object.
	private ListView listView;


	/*H3. Home Model constructor initialises the menu titles, 
    calls class MenuTitles and passes home model class name to return desired titles. */
	public HomeModel() {
		menuTitles = MenuTitles.setTitles(this.getClass().getSimpleName());
	}

	public void model() {
		 //H4. Declare and initialise a string array list, which holds the menu titles. 
		ArrayList<String> items = new ArrayList<String>();

		for (int i = 0; i < menuTitles.length; i++) {
			items.add(menuTitles[i]);
		}
		//H5. Initialises the list view by getting the list view in home. 
		listView = Home.getListView();
		/*H6. Create a new menu adapter passing in home context, 
	      the previously initialised items array list, and the home activity. */  
		MenuAdapter menuAdapter = new MenuAdapter(Home.getContext(), items,Home.getActivity());
		//H7. Set the list view adapter to the initialised menu adapter.
		listView.setAdapter(menuAdapter);
		//H8. Set on item click listener on the list view,  
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				//H9. Get home controller and pass it the integer value arg2. 
				Home.getHome().getController().Controller(arg2);
				
			}
		});
	}
}

