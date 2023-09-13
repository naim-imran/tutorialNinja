package com.tutorialNinja.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import com.github.javafaker.Faker;

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
	
	public  HashMap<String, String> getFakerTestData() {
		HashMap<String, String> hashMap= new HashMap<String, String>();
		
		Faker faker= new Faker();
		hashMap.put("randomFirstName", faker.name().firstName());
		hashMap.put("randomLastName", faker.name().lastName());
		hashMap.put("randomEmail", faker.internet().emailAddress());
		hashMap.put("randomPassword", "654321");
		hashMap.put("randomPhoneNumber", faker.phoneNumber().cellPhone());
		return hashMap;
	}
}
