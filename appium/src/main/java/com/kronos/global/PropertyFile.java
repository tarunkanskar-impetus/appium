package com.kronos.global;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	
	private Properties _gui_automation_properties = new Properties();
	public final static String PROPERTY_FILENAME1 = System.getProperty("user.dir")+"\\configFile\\gui_automation.properties";
	public final static String PROPERTY_FILENAME2 = System.getProperty("user.dir")+"\\configFile\\objectRepository.properties";
	
	public String  GUI_automation_properties(String key) throws FileNotFoundException, IOException {
		
			_gui_automation_properties.load(new FileInputStream(PROPERTY_FILENAME1));
			String property = _gui_automation_properties.getProperty(key).toString();
			return property;

		
	}
	
	public String  objectRepository_properties(String key) throws FileNotFoundException, IOException {
		
		_gui_automation_properties.load(new FileInputStream(PROPERTY_FILENAME2));
		String property = _gui_automation_properties.getProperty(key).toString();
		return property;

	
}
	
  

}


