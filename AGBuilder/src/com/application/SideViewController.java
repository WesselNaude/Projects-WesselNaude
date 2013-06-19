package com.application;

import android.content.Intent;

import com.activities.Home;


public class SideViewController  {
	//S1. Declare object references. 
	FormWidgetModel formWidgetModel;
	TextFieldsModel textViewModel;
    TimeDateModel timeDateModel;
    XmlParser xmlParser;
    LoadXml loadXml;
    boolean flag = false;
	public SideViewController() {}

    /*S2. Method arguments takes integer choice and directs to the desired model/ class. 
     Adhering to model view controller pattern. */
	public void Controller(int choice) {
		if (choice == 0) {
			formWidgetModel = new FormWidgetModel();
			formWidgetModel.model();
		}

		if (choice == 1) {
			textViewModel = new TextFieldsModel();
			textViewModel.model();
			
			timeDateModel = new TimeDateModel();
			timeDateModel.model();
		}
		
		if (choice == 2) {
			textViewModel = new TextFieldsModel();
			textViewModel.model();
		}
		
		if (choice == 3) {
		    xmlParser = new XmlParser();
			 xmlParser.ParseXml();
			 
			
		}
		
		if (choice == 4) {
			LoadFormWidget.getInstance().uninitializeIds();
			LoadTextFields.getInstance().uninitializeIds();
			LoadTimeDate.getInstance().uninitializeIds();
			TextFieldsFactory.getInstance().uninitializeIds();
			FormWidgetFactory.getInstance().uninitializeIds();
			TimeDateFactory.getInstance().uninitializeIds();
			ViewCollection.getInstance().DeleteAllViews();
		    loadXml = new LoadXml();
			loadXml.Load();
		}
		
		
		if (choice == 5) {
			// E2. If flag equal false, direct to home,
			if (flag == false) {
				flag = true;
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				Home.getActivity().startActivity(intent);
			}
			// E3. flag is is true, direct to com.activities.Menu
			try {
				Class<?> aClass = Class.forName("com.activities.Home");
				Intent intent = new Intent(Home.getContext(), aClass);
				Home.getActivity().startActivity(intent);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		}
	}


