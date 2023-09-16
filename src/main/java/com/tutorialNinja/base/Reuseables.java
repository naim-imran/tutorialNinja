package com.tutorialNinja.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.tutorialNinja.pageObjectFactory.HeadersAndFootersObjects;

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
		
		 // Create a JSON object
        JSONObject jsonObject = new JSONObject();

        // Add data to the JSON object
		
		  jsonObject.put("FirstName", hashMap.get("randomFirstName"));
		  jsonObject.put("LastName", hashMap.get("randomLastName"));
		  jsonObject.put("email", hashMap.get("randomEmail"));
		  jsonObject.put("Password", hashMap.get("randomPassword"));
		  jsonObject.put("PhoneNumber", hashMap.get("randomPhoneNumber"));
		 
        
       // jsonObject.put("test data 1", hashMap);

        

        // Write the JSON object to a file
        try {
            FileWriter fileWriter = new FileWriter(System.getProperty("user.dir")+"\\src\\test\\resources\\data.json");
            fileWriter.write(jsonObject.toString());
            fileWriter.close();
            System.out.println("Data has been written to data.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return hashMap;
	}
	
	public synchronized int getURLresponseCode(String url) throws IOException {
		HttpsURLConnection httpsURLConnection= (HttpsURLConnection)new URL(url).openConnection();
		httpsURLConnection.setRequestMethod("HEAD");
		httpsURLConnection.connect();
		return httpsURLConnection.getResponseCode();
	}
	
	
	
	
}
