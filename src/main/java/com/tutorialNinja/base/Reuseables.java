package com.tutorialNinja.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Reuseables {
	private Properties prop;

	public Properties loadProperty() {
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\config.properties");
			prop = new Properties();
			prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
