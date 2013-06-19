package com.application;
import java.util.ArrayList;


import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.activities.Home;


public class XmlAttributeColllection {
	
	private ArrayList <XmlAttribute> xmlAttributes;
	private ArrayList<View> viewCollection;
	private XmlAttribute attribute;
	
	public XmlAttributeColllection (){
		this.xmlAttributes = new ArrayList<XmlAttribute>();
		this.viewCollection = ViewCollection.getInstance().getViews();
	}
	
	public void fillCollection (){
		for (View view: viewCollection){
			if (view.getClass().getSimpleName().equalsIgnoreCase("EditText")){
				EditText editText = (EditText) view;
				String text = editText.getText().toString();
				attribute = new XmlAttribute(
						 editText.getClass().getSimpleName() ,
						 editText.getClass().getSimpleName() + editText.getText().toString(),
				         Integer.toString(editText.getWidth()),
				         Integer.toString(editText.getHeight()),
				          text,
				          Integer.toString(editText.getLeft()),
				         Integer.toString(editText.getTop()),
				         "#FFFFFF", Integer.toString(editText.getInputType())
				         );
				
			
		xmlAttributes.add(attribute);
			}
			
			else if (view.getClass().getSimpleName().equalsIgnoreCase("TimePicker")){
				attribute = new XmlAttribute(
						 view.getClass().getSimpleName(),
						 view.getClass().getSimpleName() + Integer.toString(view.getId()),
				         Integer.toString(view.getTop()),
				         Integer.toString(view.getLeft()),
				         true);
		     	xmlAttributes.add(attribute);
				
				
			}
			
			
			else if (view.getClass().getSimpleName().equalsIgnoreCase("ProgressBar")){
				attribute = new XmlAttribute(
						 view.getClass().getSimpleName(),
						 view.getClass().getSimpleName() + Integer.toString(view.getId()),
				         Integer.toString(view.getWidth()),
				         Integer.toString(view.getHeight()),
				         Integer.toString(view.getTop()),
				         Integer.toString(view.getLeft()));
		     	xmlAttributes.add(attribute);
				
				
			}
			else {
				attribute = new XmlAttribute(
						         view.getClass().getSimpleName(),
						         view.getClass().getSimpleName() +Integer.toString(view.getId()),
						         Integer.toString(view.getWidth()),
						         Integer.toString(view.getHeight()),
						         view.getClass().getSimpleName() + Integer.toString(view.getId()),
						         Integer.toString(view.getLeft()),
						         Integer.toString(view.getTop()
						         ),
						         "#FFFFFF");
				xmlAttributes.add(attribute);
			}
		}
	} 
	
	
	public ArrayList<XmlAttribute> getAttributeCollection(){
		fillCollection();
		return xmlAttributes;
	  }
	}
	
	
	
		
	

