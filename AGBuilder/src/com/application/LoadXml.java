package com.application;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.activities.Home;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;


public class LoadXml extends DefaultHandler {

	public LoadXml (){}
	
	 public void Load(){
	        try{
	            SAXParserFactory saxParseFactory = SAXParserFactory.newInstance();
	            SAXParser saxParser = saxParseFactory.newSAXParser();
	            XMLReader xmlReader = saxParser.getXMLReader();
	            File myFile = new File("/sdcard/GuiBuilder.xml");
	            FileInputStream inputStream = new FileInputStream(myFile);
	            xmlReader.setContentHandler(this);
	            xmlReader.parse(new InputSource(inputStream));
	        } catch (Exception e) {
	        	Toast.makeText(Home.getHome().getContext(), "File not found", Toast.LENGTH_LONG).show();
	        }
	    }
	
		public void startDocument(String uri, String localName, String qName, Attributes attributes) throws SAXException {} 
		public void endDocument() throws SAXException {}
		
		public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
			 
			 
			 if (localName.equals("Button"))
			   {
				
				 int choice = 0;
			      String id = atts.getValue("android:id");
			      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
			      String layoutWidth = atts.getValue("android:layout_width");
			      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
			      String layoutHeight = atts.getValue("android:layout_height");
			      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
			      String layoutx = atts.getValue("android:layout_x");
			      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
			      String layouty = atts.getValue("android:layout_y");
			      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
			      String text = atts.getValue("android:text");
		        LoadFormWidget.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
		         
			   }  
			 
			 if (localName.equals("TextView"))
			   {
				
				 int choice = 1;
			      String id = atts.getValue("android:id");
			      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
			      String layoutWidth = atts.getValue("android:layout_width");
			      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
			      String layoutHeight = atts.getValue("android:layout_height");
			      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
			      String layoutx = atts.getValue("android:layout_x");
			      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
			      String layouty = atts.getValue("android:layout_y");
			      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
			      String text = atts.getValue("android:text");
			      LoadFormWidget.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
			   }  
			 
			 if (localName.equals("ToggleButton"))
			   {
			
				 int choice = 2;
			      String id = atts.getValue("android:id");
			      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
			      String layoutWidth = atts.getValue("android:layout_width");
			      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
			      String layoutHeight = atts.getValue("android:layout_height");
			      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
			      String layoutx = atts.getValue("android:layout_x");
			      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
			      String layouty = atts.getValue("android:layout_y");
			      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
			      String text = atts.getValue("android:text");
			      LoadFormWidget.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
			   }  
			 
			 if (localName.equals("CheckBox"))
			   {
				 
				 int choice = 3;
			      String id = atts.getValue("android:id");
			      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
			      String layoutWidth = atts.getValue("android:layout_width");
			      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
			      String layoutHeight = atts.getValue("android:layout_height");
			      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
			      String layoutx = atts.getValue("android:layout_x");
			      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
			      String layouty = atts.getValue("android:layout_y");
			      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
			      String text = atts.getValue("android:text");
			      LoadFormWidget.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
			   }  
			 
			 if (localName.equals("RadioButton"))
			   {
				
				 int choice = 4;
			      String id = atts.getValue("android:id");
			      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
			      String layoutWidth = atts.getValue("android:layout_width");
			      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
			      String layoutHeight = atts.getValue("android:layout_height");
			      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
			      String layoutx = atts.getValue("android:layout_x");
			      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
			      String layouty = atts.getValue("android:layout_y");
			      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
			      String text = atts.getValue("android:text");
			      LoadFormWidget.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
			   }  
			 
			 if (localName.equals("ProgressBar"))
			   {
				
				 int choice = 5;
			      String id = atts.getValue("android:id");
			      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
			      String layoutWidth = atts.getValue("android:layout_width");
			      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
			      String layoutHeight = atts.getValue("android:layout_height");
			      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
			      String layoutx = atts.getValue("android:layout_x");
			      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
			      String layouty = atts.getValue("android:layout_y");
			      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
			      LoadFormWidget.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,"");
			   }  
			 
			 if (localName.equals("EditText"))
			   {
				
				if (atts.getValue("android:inputType").equalsIgnoreCase("text")){
				 int choice = 0;
			      String id = atts.getValue("android:id");
			      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
			      String layoutWidth = atts.getValue("android:layout_width");
			      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
			      String layoutHeight = atts.getValue("android:layout_height");
			      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
			      String layoutx = atts.getValue("android:layout_x");
			      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
			      String layouty = atts.getValue("android:layout_y");
			      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
			      String text = atts.getValue("android:text");
			      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
				}
				else if (atts.getValue("android:inputType").equalsIgnoreCase("textPassword")){
					 int choice = 1;
				      String id = atts.getValue("android:id");
				      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
				      String layoutWidth = atts.getValue("android:layout_width");
				      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
				      String layoutHeight = atts.getValue("android:layout_height");
				      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
				      String layoutx = atts.getValue("android:layout_x");
				      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
				      String layouty = atts.getValue("android:layout_y");
				      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
				      String text = atts.getValue("android:text");
				      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
					
				}
				else if (atts.getValue("android:inputType").equalsIgnoreCase("numberPassword")){
					  int choice = 2;
				      String id = atts.getValue("android:id");
				      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
				      String layoutWidth = atts.getValue("android:layout_width");
				      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
				      String layoutHeight = atts.getValue("android:layout_height");
				      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
				      String layoutx = atts.getValue("android:layout_x");
				      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
				      String layouty = atts.getValue("android:layout_y");
				      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
				      String text = atts.getValue("android:text");
				      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
					
				}
				else if (atts.getValue("android:inputType").equalsIgnoreCase("textEmailAddress")){
					  int choice = 3;
				      String id = atts.getValue("android:id");
				      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
				      String layoutWidth = atts.getValue("android:layout_width");
				      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
				      String layoutHeight = atts.getValue("android:layout_height");
				      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
				      String layoutx = atts.getValue("android:layout_x");
				      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
				      String layouty = atts.getValue("android:layout_y");
				      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
				      String text = atts.getValue("android:text");
				      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
				}
				else if (atts.getValue("android:inputType").equalsIgnoreCase("phone")){
					  int choice = 4;
				      String id = atts.getValue("android:id");
				      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
				      String layoutWidth = atts.getValue("android:layout_width");
				      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
				      String layoutHeight = atts.getValue("android:layout_height");
				      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
				      String layoutx = atts.getValue("android:layout_x");
				      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
				      String layouty = atts.getValue("android:layout_y");
				      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
				      String text = atts.getValue("android:text");
				      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
				}
				else if (atts.getValue("android:inputType").equalsIgnoreCase("textPostalAddress")){
					  int choice = 5;
				      String id = atts.getValue("android:id");
				      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
				      String layoutWidth = atts.getValue("android:layout_width");
				      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
				      String layoutHeight = atts.getValue("android:layout_height");
				      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
				      String layoutx = atts.getValue("android:layout_x");
				      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
				      String layouty = atts.getValue("android:layout_y");
				      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
				      String text = atts.getValue("android:text");
				      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
				}
				else if (atts.getValue("android:inputType").equalsIgnoreCase("textMultiLine")){
					  int choice = 6;
				      String id = atts.getValue("android:id");
				      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
				      String layoutWidth = atts.getValue("android:layout_width");
				      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
				      String layoutHeight = atts.getValue("android:layout_height");
				      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
				      String layoutx = atts.getValue("android:layout_x");
				      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
				      String layouty = atts.getValue("android:layout_y");
				      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
				      String text = atts.getValue("android:text");
				      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
				}
				else if (atts.getValue("android:inputType").equalsIgnoreCase("time")){
					  int choice = 7;
				      String id = atts.getValue("android:id");
				      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
				      String layoutWidth = atts.getValue("android:layout_width");
				      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
				      String layoutHeight = atts.getValue("android:layout_height");
				      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
				      String layoutx = atts.getValue("android:layout_x");
				      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
				      String layouty = atts.getValue("android:layout_y");
				      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
				      String text = atts.getValue("android:text");
				      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
				}
				else if (atts.getValue("android:inputType").equalsIgnoreCase("date")){
					  int choice = 8;
				      String id = atts.getValue("android:id");
				      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
				      String layoutWidth = atts.getValue("android:layout_width");
				      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
				      String layoutHeight = atts.getValue("android:layout_height");
				      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
				      String layoutx = atts.getValue("android:layout_x");
				      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
				      String layouty = atts.getValue("android:layout_y");
				      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
				      String text = atts.getValue("android:text");
				      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
				}
				else if (atts.getValue("android:inputType").equalsIgnoreCase("number")){
					  int choice = 9;
				      String id = atts.getValue("android:id");
				      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
				      String layoutWidth = atts.getValue("android:layout_width");
				      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
				      String layoutHeight = atts.getValue("android:layout_height");
				      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
				      String layoutx = atts.getValue("android:layout_x");
				      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
				      String layouty = atts.getValue("android:layout_y");
				      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
				      String text = atts.getValue("android:text");
				      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
				}
				else if (atts.getValue("android:inputType").equalsIgnoreCase("numberSigned")){
					  int choice = 10;
				      String id = atts.getValue("android:id");
				      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
				      String layoutWidth = atts.getValue("android:layout_width");
				      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
				      String layoutHeight = atts.getValue("android:layout_height");
				      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
				      String layoutx = atts.getValue("android:layout_x");
				      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
				      String layouty = atts.getValue("android:layout_y");
				      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
				      String text = atts.getValue("android:text");
				      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
				}
				else if (atts.getValue("android:inputType").equalsIgnoreCase("numberDecimal")){
					  int choice = 11;
				      String id = atts.getValue("android:id");
				      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
				      String layoutWidth = atts.getValue("android:layout_width");
				      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
				      String layoutHeight = atts.getValue("android:layout_height");
				      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
				      String layoutx = atts.getValue("android:layout_x");
				      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
				      String layouty = atts.getValue("android:layout_y");
				      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
				      String text = atts.getValue("android:text");
				      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
				}
				
			   }
			 if (localName.equals("AutoCompleteTextView"))
			   {
				 int choice = 12;
			      String id = atts.getValue("android:id");
			      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
			      String layoutWidth = atts.getValue("android:layout_width");
			      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
			      String layoutHeight = atts.getValue("android:layout_height");
			      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
			      String layoutx = atts.getValue("android:layout_x");
			      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
			      String layouty = atts.getValue("android:layout_y");
			      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
			      String text = atts.getValue("android:text");
			      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
			   }  
			 if (localName.equals("MultiAutoCompleteTextView"))
			   {
				 int choice = 13;
			      String id = atts.getValue("android:id");
			      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
			      String layoutWidth = atts.getValue("android:layout_width");
			      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
			      String layoutHeight = atts.getValue("android:layout_height");
			      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
			      String layoutx = atts.getValue("android:layout_x");
			      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
			      String layouty = atts.getValue("android:layout_y");
			      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
			      String text = atts.getValue("android:text");
			      LoadTextFields.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
			   }  
			 if (localName.equals("TimePicker"))
			   {
				 Log.i("Made it ","to time picker parser");
				 int choice = 0;
			      String id = atts.getValue("android:id");
			      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
			     // String layoutWidth = atts.getValue("android:layout_width");
			     // int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
			    //  String layoutHeight = atts.getValue("android:layout_height");
			    //  int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
			      String layoutx = atts.getValue("android:layout_x");
			      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
			      String layouty = atts.getValue("android:layout_y");
			      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
			      Log.i("Made it ","just before text");
			      String text = atts.getValue("android:text");
			      Log.i("I am here","in timepicker parser");
			      LoadTimeDate.getInstance().getView(choice,integerId, 0,0,integerLayoutX,integerLayoutY,text);
			   }  
			 if (localName.equals("Chronometer"))
			   {
				  int choice = 1;
			      String id = atts.getValue("android:id");
			      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
			      String layoutWidth = atts.getValue("android:layout_width");
			      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
			      String layoutHeight = atts.getValue("android:layout_height");
			      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
			      String layoutx = atts.getValue("android:layout_x");
			      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
			      String layouty = atts.getValue("android:layout_y");
			      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
			      String text = atts.getValue("android:text");
			      LoadTimeDate.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
			   }  
			 
			 if (localName.equals("AnalogClock"))
			   {
				  int choice = 2;
			      String id = atts.getValue("android:id");
			      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
			      String layoutWidth = atts.getValue("android:layout_width");
			      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
			      String layoutHeight = atts.getValue("android:layout_height");
			      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
			      String layoutx = atts.getValue("android:layout_x");
			      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
			      String layouty = atts.getValue("android:layout_y");
			      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
			      String text = atts.getValue("android:text");
			      LoadTimeDate.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
			   }  
			 if (localName.equals("DigitalClock"))
			   {
				  int choice = 3;
			      String id = atts.getValue("android:id");
			      int integerId = Integer.parseInt(id.replaceAll("[\\D]", ""));
			      String layoutWidth = atts.getValue("android:layout_width");
			      int integerLayoutWidth = Integer.parseInt(layoutWidth.replaceAll("[\\D]", ""));
			      String layoutHeight = atts.getValue("android:layout_height");
			      int integerLayouHeight = Integer.parseInt(layoutHeight.replaceAll("[\\D]", ""));
			      String layoutx = atts.getValue("android:layout_x");
			      int integerLayoutX = Integer.parseInt(layoutx.replaceAll("[\\D]", ""));
			      String layouty = atts.getValue("android:layout_y");
			      int integerLayoutY = Integer.parseInt(layouty.replaceAll("[\\D]", ""));
			      String text = atts.getValue("android:text");
			      LoadTimeDate.getInstance().getView(choice,integerId, integerLayoutWidth,integerLayouHeight,integerLayoutX,integerLayoutY,text);
			   }  
		}
		
		public void endElement(String namespaceURI, String localName, String qName)  throws SAXException {}
		public void characters(char ch[], int start, int length) {}
		
}
