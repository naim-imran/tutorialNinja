package com.tutorialNinja.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;



public class Reuseables {

	public static final String SMOKE = "smoke";
	public static final String REGRESSION = "regression";
	public static final String POSSITIVE = "possitive";
	public static final String NEGATIVE = "negative";
	private Properties prop;

	public Properties loadProperty() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("." + File.separator + "src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + "config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}

	public String takeScreenShot(WebDriver driver, String testCaseName, String folderName) {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String dest = "."+File.separator + "testResultsAndScreecshoots" + File.separator + folderName  + File.separator +  testCaseName + getTimeStamp() + ".png";
		File file = new File(dest);
		try {
			FileUtils.copyFile(source, file);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return file.getAbsolutePath();
	} 

	public HashMap<String, String> getFakerTestData() {
		HashMap<String, String> hashMap = new HashMap<String, String>();

		Faker faker = new Faker();
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

		// Write the JSON object to a file
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(System.getProperty("user.dir") + File.separator + "src" + File.separator
					+ "test" + File.separator + "resources" + File.separator + "data.json");
			fileWriter.append(jsonObject.toString());

			System.out.println("Data has been written to data.json");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return hashMap;
	}

	public synchronized int getURLresponseCode(String url) throws IOException {
		HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(url).openConnection();
		httpsURLConnection.setRequestMethod("HEAD");
		httpsURLConnection.connect();
		return httpsURLConnection.getResponseCode();
	}

	public synchronized String getTimeStamp() {
		LocalDateTime currentDateAndTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatedurrentDateAndTime = formatter.format(currentDateAndTime);
		return formatedurrentDateAndTime.replace("-", "_").replace(":", "_").replace(" ", "_");
	}

	public Object[][] readExcelData(String sheetName) {
		Object[][] data = null;
		XSSFWorkbook workbook = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("." + File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "QaFoxTestData.xlsx"); // dot " . " represents current project path
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = new XSSFWorkbook(fis);
			int totalWorkSheets = workbook.getNumberOfSheets();

			for (byte i = 0; i < totalWorkSheets; i++) {
				if (workbook.getSheetName(i).contains(sheetName)) {
					XSSFSheet workSheet = workbook.getSheetAt(i);
					data = new Object[workSheet.getLastRowNum()][workSheet.getRow(0).getLastCellNum()];

					for (int r = 0; r < workSheet.getLastRowNum(); r++) {
						for (int j = 0; j < workSheet.getRow(0).getLastCellNum(); j++) {
							data[r][j] = workSheet.getRow(r + 0).getCell(j).toString();
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				workbook.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	public ArrayList<HashMap<String, Object>> readExcelData() {
		XSSFWorkbook workbook = null;
		FileInputStream fis = null;
		String sheetName = "Customer Registration Data";
		ArrayList<HashMap<String, Object>> dataList = new ArrayList<>();

		try {
			fis = new FileInputStream("." + File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "QaFoxTestData.xlsx"); // dot " . " represents current project path

			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rows = sheet.getLastRowNum();

			for (int i = 1; i <= rows; i++) { // Start from row 2 (assuming the data starts from row 2)
				HashMap<String, Object> data = new HashMap<>();
				data.put("FirstName", sheet.getRow(i).getCell(0).getStringCellValue());
				data.put("LastName", sheet.getRow(i).getCell(1).getStringCellValue());
				data.put("Email", sheet.getRow(i).getCell(2).getStringCellValue());

				// Format decimal to string
				String telephone = new DecimalFormat("#").format(sheet.getRow(i).getCell(3).getNumericCellValue());
				data.put("Telephone", telephone);

				data.put("password", sheet.getRow(i).getCell(4).getStringCellValue());
				dataList.add(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null) {
					workbook.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return dataList;
	}

}
