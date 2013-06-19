package com.application;

import java.util.ArrayList;

import com.activities.Home;
import com.slidelayout.MenuAdapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FormWidgetModel {
	//F1. Declare menu titles string array.
	private final String[] menuTitles;
	//F2. Declare list view object.
	private  ListView listView;
	//F3. Declare form widget view object. 
	private FormWidgetView formWidgetView;
	//F4. Declare integer choice. 
	private int choice;
      
	/*F5. Form Widget Model constructor initialises the menu titles, 
	      calls class MenuTitles and passes form widget model class name to return desired titles. */
	public FormWidgetModel() {
		menuTitles = MenuTitles.setTitles(this.getClass().getSimpleName());
	}

	public void model() {
        //F6. Declare and initialise a string array list, which holds the menu titles. 
		ArrayList<String> items = new ArrayList<String>();
		for (int i = 0; i < menuTitles.length; i++) {
			items.add(menuTitles[i]);
		}
		//F7. Initialises the list view by getting the list view in home. 
		listView = Home.getListView();
        /*F8. Create a new menu adapter passing in home context, 
		      the previously initialised items array list, and the home activity. */  
		MenuAdapter menuAdapter = new MenuAdapter(Home.getContext(), items,Home.getActivity());
		//F9. Set the list view adapter to the initialised menu adapter. 
		listView.setAdapter(menuAdapter);
        //F10. Set on item click listener on the list view,  
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
		//F11. Initialise choice variable to arg2, the integer value selected in the list view. 		
				choice = arg2;
		//F12. If choice == 6, user selected back, return to the initial level of the list view. 		
				if (choice == 6){
					HomeModel homeModel = new HomeModel();
					Home.getHome().scroll();
					homeModel.model();
				}
		/*F13. Passes the choice to form widget view, which then passes choice to, 		
		       form widget factory responsible for constructing the appropriate object. */
				else {
				formWidgetView = new FormWidgetView();
				formWidgetView.updateView(choice);
				}
			}
		});
	}
}
