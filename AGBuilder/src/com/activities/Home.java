package com.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.application.FormWidgetFactory;
import com.application.LoadFormWidget;
import com.application.LoadTextFields;
import com.application.LoadTimeDate;
import com.application.LoadXml;
import com.application.MenuTitles;
import com.application.R;
import com.application.SideViewController;
import com.application.TextFieldsFactory;
import com.application.TimeDateFactory;
import com.application.ViewCollection;
import com.application.XmlParser;
import com.slidelayout.MenuAdapter;
import com.slidelayout.ScrollerLinearLayout;

public class Home extends Activity {
	// H1. Static variables for global scope.
	private static Context context;
	private static Activity activity;
	private static FrameLayout rootLayout;
	private static ListView listView;
	private static Home home;
	private FrameLayout layout;
	private ScrollerLinearLayout sideSlideLayout;
	private SideViewController sideViewController;
	private ArrayList<View> Views;
	private Bundle bundle;
	private LoadXml loadXml;
	private XmlParser xmlParser;
	private boolean save;
	// H2. Array holds menu titles.
	private final String[] menuTitles;


	public Home() {
		home = this;
		Views = new ArrayList<View>();
		menuTitles = MenuTitles.setTitles(this.getClass().getSimpleName());
		sideViewController = new SideViewController();
	} 

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		// H3. Bundle stores savedInstanceState.
		this.bundle = savedInstanceState;
		initialiseSideView();
		setSideBarButton();
		initialiseListView();
		listView = (ListView) findViewById(R.id.menu_content_menulist);
		layout = new FrameLayout(this);
		context = this;
		activity = this;
		layout = (FrameLayout) findViewById(R.string.home);
	
		// H4. Open side view oncreate.
		if (savedInstanceState != null){
		if (savedInstanceState.getBoolean("save") == true){
			loadXml = new LoadXml();
			loadXml.Load();
			save = false;
		}
		}
		
	
		scroll();
		scroll();

	}

	public void onSaveInstanceState(Bundle savedInstanceState) {
		xmlParser = new XmlParser();
		xmlParser.ParseXml();
       save = true;
       rootLayout.removeAllViews();
		LoadFormWidget.getInstance().uninitializeIds();
		LoadTextFields.getInstance().uninitializeIds();
		LoadTimeDate.getInstance().uninitializeIds();
		TextFieldsFactory.getInstance().uninitializeIds();
		FormWidgetFactory.getInstance().uninitializeIds();
		TimeDateFactory.getInstance().uninitializeIds();
		ViewCollection.getInstance().DeleteAllViews();
       savedInstanceState.putBoolean("save", save);
	/*	for (View v : Views) {

			String Class = "Class" + counter;
			String Id = "Id" + counter;
			String Height = "Height" + counter;
			String Width = "Width" + counter;
			String Left = "Left" + counter;
			String Top = "Top" + counter;
			String Right = "Right" + counter;
			String Bottom = "Bottom" + counter;

			savedInstanceState.putString(Class, v.getClass().getSimpleName());
			savedInstanceState.putInt(Id, v.getId());
			savedInstanceState.putInt(Height, v.getHeight());
			savedInstanceState.putInt(Width, v.getWidth());
			savedInstanceState.putInt(Left, v.getLeft());
			savedInstanceState.putInt(Top, v.getTop());
			savedInstanceState.putInt(Right, v.getRight());
			savedInstanceState.putInt(Bottom, v.getBottom());
			savedInstanceState.putInt("Counter", counter);
			counter++;
		}*/
	}

	// H5. Supply side view content identifiers.
	private void initialiseSideView() {
		this.sideSlideLayout = (ScrollerLinearLayout) findViewById(R.id.menu_content_side_slide_layout);
		this.rootLayout = (FrameLayout) findViewById(R.id.menu_content_root);
		this.rootLayout.setFocusable(true);
		this.rootLayout.requestFocus();
	}

	// H6. Supply button Identifier, set onClickListener, initialise sideBar,
	// Open side view.
	private void setSideBarButton() {
		Button menuButton = (Button) findViewById(R.id.main_tmp_button);
		menuButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				initialiseListView();
				scroll();
			}
		});
	}

	// H7. Initialise content of list view in side view.
	public void initialiseListView() {
		// H8. Declare and initialise items array list, and fill with menu
		// titles.
		ArrayList<String> items = new ArrayList<String>();
		for (int i = 0; i < menuTitles.length; i++) {
			items.add(menuTitles[i]);
		}
		// H9. Supply list view identifiers, declare and initialise menu
		// adapter.
		listView = (ListView) findViewById(R.id.menu_content_menulist);
		listView.setFadingEdgeLength(0);
		final MenuAdapter menuAdapter = new MenuAdapter(this, items, this);
		// H10. Set list view adapter to menu adapter.
		listView.setAdapter(menuAdapter);
		// H11. Set list view onItemClickListener, allowing for the integer
		// value of the item clicked,
		// to be passed to the side view controller.
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				sideViewController.Controller(arg2);

			}
		});
	}

	// H12. Open close side view.
	public void scroll() {
		sideSlideLayout.scroll(listView);
	}

	// H13. Various getters use used by other classes.
	public Bundle getBundle() {
		return bundle;
	}

	public SideViewController getController() {
		return sideViewController;
	}

	public ScrollerLinearLayout getScroller() {
		return sideSlideLayout;
	}

	public static ListView getListView() {
		return listView;
	}

	public FrameLayout getLayout() {
		return rootLayout;
	}

	public static Context getContext() {
		return context;
	}

	public static Activity getActivity() {
		return activity;
	}

	public static Home getHome() {
		return home;
	}
}
