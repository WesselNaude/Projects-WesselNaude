package com.application;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.xmlpull.v1.XmlSerializer;

import android.os.Environment;
import android.util.Xml;
import android.view.View;
import android.widget.Toast;

import com.activities.Home;



public class XmlParser {
	private String xml;
	private ArrayList<View> viewCollection;
	private XmlAttributeColllection attributeColllection;


	public XmlParser(){
		viewCollection = ViewCollection.getInstance().getViews();
		attributeColllection = new XmlAttributeColllection();
		
	}
	
	
    public void ParseXml(){
		XmlSerializer serializer = Xml.newSerializer();
		StringWriter writer = new StringWriter();
		try {
			serializer.setOutput(writer);
		  
			serializer.startDocument("UTF-8", false);
			serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
			serializer.startTag("", "AbsoluteLayout"); 
			serializer.attribute("", "android:id", "@+id/guiBuilder_Layout \n");
			serializer.attribute("", "android:layout_width", "fill_parent");
			serializer.attribute("", "android:layout_height", "fill_parent");
			serializer.attribute("", "android:background", "#000000");
			serializer.attribute("", "xmlns:android", "http://schemas.android.com/apk/res/android");

				for (XmlAttribute attribute: attributeColllection.getAttributeCollection()){
					if  (attribute.isEditText()== true) {
						 serializer.startTag("", attribute.getAttributeTag());
							serializer.attribute("", attribute.getAttributeId(), attribute.getValueId());
							serializer.attribute("", attribute.getAttributeWidth(), attribute.getValueWidth());
							serializer.attribute("", attribute.getAttributeHeight(), attribute.getValueHeight());
							serializer.attribute("", attribute.getAttributeLayoutX(), attribute.getValueLayoutX());
							serializer.attribute("", attribute.getAttributeLayoutY(), attribute.getValueLayoutY());	
							serializer.attribute("", attribute.getAttributeInputType(), attribute.getValueInputType());
							serializer.attribute("", attribute.getAttributeText(), attribute.getValueText());
							serializer.attribute("", attribute.getAttributeColor(), attribute.getValueColor());
							serializer.endTag("", attribute.getAttributeTag());
							}
					else if (attribute.isProgressBar() == true){
						serializer.startTag("", attribute.getAttributeTag());
						serializer.attribute("", attribute.getAttributeId(), attribute.getValueId());
						serializer.attribute("", attribute.getAttributeStyle(), attribute.getValueStyle());
						serializer.attribute("", attribute.getAttributeWidth(), attribute.getValueWidth());
						serializer.attribute("", attribute.getAttributeHeight(), attribute.getValueHeight());
						serializer.attribute("", attribute.getAttributeLayoutX(), attribute.getValueLayoutX());
						serializer.attribute("", attribute.getAttributeLayoutY(), attribute.getValueLayoutY());
						serializer.endTag("", attribute.getAttributeTag());
					}
					
					else if (attribute.isTimePicker() == true){
						serializer.startTag("", attribute.getAttributeTag());
						serializer.attribute("", attribute.getAttributeId(), attribute.getValueId());
						serializer.attribute("", attribute.getAttributeWidth(), attribute.getValueWidth());
						serializer.attribute("", attribute.getAttributeHeight(), attribute.getValueHeight());
						serializer.attribute("", attribute.getAttributeLayoutX(), attribute.getValueLayoutX());
						serializer.attribute("", attribute.getAttributeLayoutY(), attribute.getValueLayoutY());
						serializer.attribute("", attribute.getAttributeScaleWidth(), attribute.getValueScaleWidth());
						serializer.attribute("", attribute.getAttributeScaleHeight(), attribute.getValueScaleHeight());
						serializer.endTag("", attribute.getAttributeTag());
					}
					
					
					else {
				    serializer.startTag("", attribute.getAttributeTag());
					serializer.attribute("", attribute.getAttributeId(), attribute.getValueId());
					serializer.attribute("", attribute.getAttributeWidth(), attribute.getValueWidth());
					serializer.attribute("", attribute.getAttributeHeight(), attribute.getValueHeight());
					serializer.attribute("", attribute.getAttributeLayoutX(), attribute.getValueLayoutX());
					serializer.attribute("", attribute.getAttributeLayoutY(), attribute.getValueLayoutY());
					serializer.attribute("", attribute.getAttributeText(), attribute.getValueText());
					serializer.attribute("", attribute.getAttributeColor(), attribute.getValueColor());
					serializer.endTag("", attribute.getAttributeTag());
					}
			}
			serializer.endTag("", "AbsoluteLayout");
			serializer.endDocument();
			xml =   writer.toString();
		    saveToSdCard(xml);
  
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
    
 
    public void saveToSdCard(String xml){
    	try {
    	File guiBuilder = new File("/sdcard/GuiBuilder.xml");
    	guiBuilder.createNewFile();
		FileOutputStream fileOutputStream = new FileOutputStream(guiBuilder);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		outputStreamWriter.append(xml);
		outputStreamWriter.close();
		fileOutputStream.close();
		
		if(!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
			Toast.makeText(Home.getHome().getContext(), "Please mount sd card", Toast.LENGTH_LONG).show();
			}
		else  {

		Toast.makeText(Home.getHome().getContext(),
				"File saved",
				Toast.LENGTH_SHORT).show();
		}
	} catch (Exception e) {
		Toast.makeText(Home.getHome().getContext(), e.getMessage(),
				Toast.LENGTH_SHORT).show();
	}
 }
}
