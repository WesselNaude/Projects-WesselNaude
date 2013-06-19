package com.application;

public class XmlAttribute {
	
	private String attributeTag; 
	private String attributeId;
	private String attributeWidth;
	private String attributeHeight;
	private String attributeText;
	private String attributeLayoutX;
	private String attributeLayoutY ;
	private String attributeColor;
	private String attributeInputType;
	private String attributeStyle;
	private String attributeScaleHeight;
	private String attributeScaleWidth;
	private String valueId ="";
	private String valueWidth="";
	private String valueHeight="";
	private String valueText="";
	private String valueLayoutX="";
	private String valueLayoutY="";
	private String valueColor="";
	private String valueInputType="";
	private String valueStyle;
	private String valueScaleHeight;
	private String valueScaleWidth;
	private boolean isTimePicker = false;
	private boolean isEditText = false;
	private boolean isProgressBar = false;
	
	
	
	public XmlAttribute(String attributeTag, String valueId, String valueLayoutX,
			String valueLayoutY, Boolean isTimePicker) {
		
		this.attributeTag = attributeTag;
		this.valueId = "@+id/" + valueId;	
		this.valueWidth = "wrap_content";
		this.valueHeight = "wrap_content";
		this.valueLayoutX = valueLayoutX +"dp";
		this.valueLayoutY = valueLayoutY +"dp";
		this.valueScaleHeight ="50%";
		this.valueScaleWidth ="50%";
		this.attributeId = "android:id";
		this.attributeWidth = "android:layout_width";
		this.attributeHeight = "android:layout_height";
		this.attributeLayoutX = "android:layout_x";
		this.attributeLayoutY = "android:layout_y";
		this.attributeScaleHeight = "android:scaleHeight";
		this.attributeScaleWidth = "android:scaleWidth";
		this.isTimePicker = isTimePicker;
	}
	
	
	
	public XmlAttribute(String attributeTag, String valueId, String valueWidth,
			String valueHeight,  String valueLayoutX,
			String valueLayoutY) {
		
		this.attributeTag = attributeTag;
		this.valueId = "@+id/" + valueId;	
		this.valueWidth = valueWidth +"dp";
		this.valueHeight = valueHeight +"dp";
		this.valueLayoutX = valueLayoutX +"dp";
		this.valueLayoutY = valueLayoutY +"dp";
		this.valueStyle = "?android:attr/progressBarStyleLarge";
		this.attributeId = "android:id";
		this.attributeStyle = "style";
		this.attributeWidth = "android:layout_width";
		this.attributeHeight = "android:layout_height";
		this.attributeLayoutX = "android:layout_x";
		this.attributeLayoutY = "android:layout_y";
		this.isProgressBar = true;
	}
	
	
	
	
	public XmlAttribute(String attributeTag, String valueId, String valueWidth,
			String valueHeight, String valueText, String valueLayoutX,
			String valueLayoutY, String valueColor) {
		
		this.attributeTag = attributeTag;
		this.valueId = "@+id/" + valueId;
		this.valueWidth = valueWidth +"dp";
		this.valueHeight = valueHeight +"dp";
		this.valueText = valueText;
		this.valueLayoutX = valueLayoutX +"dp";
		this.valueLayoutY = valueLayoutY +"dp";
		this.valueColor = valueColor;
		this.attributeId = "android:id";
		this.attributeWidth = "android:layout_width";
		this.attributeHeight = "android:layout_height";
		this.attributeText = "android:text";
		this.attributeLayoutX = "android:layout_x";
		this.attributeLayoutY = "android:layout_y";
		this.attributeColor = "android:textColor";
		
	}
	
	
	public XmlAttribute(String attributeTag, String valueId, String valueWidth,
			String valueHeight, String valueText, String valueLayoutX,
			String valueLayoutY, String valueColor, String inputType) {
		
		this.attributeTag = attributeTag;
		this.valueId = "@+id/" + valueId;
		this.valueWidth = valueWidth +"dp";
		this.valueHeight = valueHeight +"dp";
		this.valueText = valueText;
		this.valueLayoutX = valueLayoutX +"dp";
		this.valueLayoutY = valueLayoutY +"dp";
		this.valueColor = valueColor;
		this.valueInputType = inputType;
		
		this.attributeId = "android:id";
		this.attributeWidth = "android:layout_width";
		this.attributeHeight = "android:layout_height";
		this.attributeText = "android:text";
		this.attributeLayoutX = "android:layout_x";
		this.attributeLayoutY = "android:layout_y";
		this.attributeColor = "android:textColor";
		this.attributeInputType = "android:inputType"; 
		this.isEditText =  true;
	}
	
	

	public String getAttributeTag() {
		return attributeTag;
	}

	public String getAttributeId() {
		return attributeId;
	}

	public String getAttributeWidth() {
		return attributeWidth;
	}

	public String getAttributeHeight() {
		return attributeHeight;
	}

	public String getAttributeText() {
		return attributeText;
	}

	public String getAttributeLayoutX() {
		return attributeLayoutX;
	}

	public String getAttributeLayoutY() {
		return attributeLayoutY;
	}

	public String getAttributeColor() {
		return attributeColor;
	}
	
	public String getAttributeInputType(){
		return attributeInputType;
	}
	
	public String getAttributeScaleWidth() {
		return attributeScaleWidth;
	}
	
	public String getAttributeScaleHeight(){
		return attributeScaleHeight;
	}
	

	public String getValueId() {
		return valueId;
	}

	public String getValueWidth() {
		return valueWidth;
	}

	public String getValueHeight() {
		return valueHeight;
	}

	public String getValueText() {
		return valueText;
	}

	public String getValueLayoutX() {
		return valueLayoutX;
	}


	public String getValueLayoutY() {
		return valueLayoutY;
	}

	public String getValueColor() {
		return valueColor;
	}
	
	public String getAttributeStyle (){
		return attributeStyle;
	}
	
	public String getValueStyle (){
		return valueStyle;
	}
	
	public String getValueScaleWidth (){
		return valueScaleWidth;
	}
	
	public String getValueScaleHeight (){
		return valueScaleHeight;
	}
	
	
	public String getValueInputType(){
		if (valueInputType.equalsIgnoreCase("1")){
			return this.valueInputType ="textPassword";
		}
		else if (valueInputType.equalsIgnoreCase("2")){
			return this.valueInputType = "numberPassword";
		}
		else if (valueInputType.equalsIgnoreCase("3")){
			return this.valueInputType ="textEmailAddress";
		}
		
		else if  (valueInputType.equalsIgnoreCase("4")){
			return this.valueInputType ="phone";
		}
		else if  (valueInputType.equalsIgnoreCase("5")){
			return this.valueInputType ="textPostalAddress";
		}
		else if  (valueInputType.equalsIgnoreCase("6")){
			return this.valueInputType ="textMultiLine";
		}
		else if  (valueInputType.equalsIgnoreCase("7")){
			return this.valueInputType ="time";
		}
		else if  (valueInputType.equalsIgnoreCase("8")){
			return this.valueInputType ="date";
		}
		
		else if  (valueInputType.equalsIgnoreCase("9")){
			return this.valueInputType ="number";
		}
		else if  (valueInputType.equalsIgnoreCase("10")){
			return this.valueInputType ="numberSigned";
		}
		else if  (valueInputType.equalsIgnoreCase("11")){
			return this.valueInputType ="numberDecimal";
		}
		else if  (valueInputType.equalsIgnoreCase("131073")){
			return this.valueInputType = "text";
		}
		else
		
		return null;
		}
	
	
	public boolean isEditText(){
		return this.isEditText;
	}
	
	public boolean isProgressBar(){
		return this.isProgressBar;
	}
	
	public boolean isTimePicker(){
		return this.isTimePicker;
	}
	
 }

		