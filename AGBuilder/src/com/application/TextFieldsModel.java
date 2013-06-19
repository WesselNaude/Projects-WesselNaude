package com.application;

import java.util.ArrayList;

import com.activities.Home;
import com.slidelayout.MenuAdapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class TextFieldsModel {
	//T1. Declare menu titles string array.
	private final String[] menuTitles;
	//T2. Declare list view object.
	private static ListView listView;
	//T3. Declare text fields view object. 
	private TextFieldsView textFieldsView;
	//T4. Declare integer choice
	private int choice;
	/*T5.Text fields model constructor initialises the menu titles, 
    calls class MenuTitles and passes text fields model class name to return desired titles. */
	public TextFieldsModel() {
		menuTitles = MenuTitles.setTitles(this.getClass().getSimpleName());
	}

	public void model() {
		//T6. Declare and initialise a string array list, which holds the menu titles. 
		ArrayList<String> items = new ArrayList<String>();

		for (int i = 0; i < menuTitles.length; i++) {
			items.add(menuTitles[i]);
		}
		//T7. Initialises the list view by getting the list view in home. 
		listView = Home.getListView();
		 /*T8. Create a new menu adapter passing in home context, 
	      the previously initialised items array list, and the home activity. */  
		MenuAdapter menuAdapter = new MenuAdapter(Home.getContext(), items,
				Home.getActivity());
		//T9. Set the list view adapter to the initialised menu adapter.
		listView.setAdapter(menuAdapter);
		 //T10. Set on item click listener on the list view,  
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
		//T11. Initialise choice variable to arg2, the integer value selected in the list view. 	
				choice = arg2;
		//T12. If choice == 14, user selected back, return to the initial level of the list view.		
				if (choice == 14){
					HomeModel homeModel = new HomeModel();
					Home.getHome().scroll();
					homeModel.model();
				}
		/*T13. Passes the choice to text fields view, which then passes choice to, 		
			   text fields factory responsible for constructing the appropriate object. */		
				else {
				textFieldsView = new TextFieldsView();
				textFieldsView.updateView(arg2);
				}
			}
		});
	}
}
