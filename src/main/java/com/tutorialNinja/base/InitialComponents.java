package com.tutorialNinja.base;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;

import com.tutorialNinja.pageObjectFactory.HomePageObjects;

public class InitialComponents extends Reuseables {
// test
	public WebDriver driver;// driver has to be public because we have to get it through reflection API in listener class
	private ThreadLocal<WebDriver> threadLocaldriver = new ThreadLocal<WebDriver>();
	
	public WebDriver setupThreadLocalDriver() {
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: loadProperty().getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome") && threadLocaldriver.get() == null) {
			ChromeOptions co = new ChromeOptions();
			co.setBrowserVersion(loadProperty().getProperty("browserVersion"));
			co.setAcceptInsecureCerts(Boolean.parseBoolean(loadProperty().getProperty("insecureCertificate")));
			driver = new ChromeDriver(co);
			threadLocaldriver.set(driver);
			driver = threadLocaldriver.get();

		} else if (browserName.equalsIgnoreCase("firefox") && threadLocaldriver.get() == null) {
			threadLocaldriver.set(ThreadGuard.protect(new FirefoxDriver()));
			driver = threadLocaldriver.get();
		}
		return driver;
	}
	
	
	public HomePageObjects launchApplicationHomePage() {
		setupThreadLocalDriver();
		System.out.println("Thread ID= " + Thread.currentThread().getId());

		long implicitWaitTime = Long.parseLong(loadProperty().getProperty("implicitWaitTime"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
		driver.manage().window().maximize();
		driver.get(loadProperty().getProperty("testServerURL"));
		return new HomePageObjects(driver);
	}

	public void cleanTestsBed() {
		String folderPath = System.getProperty("user.dir") + "\\testResultsAndScreecshoots\\";

		try (Stream<Path> paths = Files.walk(Path.of(folderPath))) {
			paths.filter(Files::isRegularFile).filter(p -> p.getFileName().toString().endsWith(".png"))
					.forEach(p -> {
						try {
							Files.delete(p);
							System.out.println("Deleted: " + p);
						} catch (IOException e) {
							System.err.println("Failed to delete: " + p);
							e.printStackTrace();
						}
					});
		} catch (IOException e) {
			e.printStackTrace();
		}

		

		// Specify the source folder path 
		Path sourceFolderPath = Path.of(System.getProperty("user.dir") + "\\testResultsAndScreecshoots\\");

		// Specify the target folder path 
		Path targetFolderPath =Path.of(System.getProperty("user.dir") + "\\testResultArcheive\\");

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceFolderPath)) {
			for (Path sourceFilePath : stream) {
				if (Files.isRegularFile(sourceFilePath)) {
					Path targetFilePath = targetFolderPath.resolve(sourceFilePath.getFileName());
					Files.move(sourceFilePath, targetFilePath, StandardCopyOption.REPLACE_EXISTING);
					System.out.println("Moved: " + sourceFilePath.getFileName());
				}
			}
			System.out.println("All files moved successfully!");
		} catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
		}

		System.out.println("TestBed cleaned up");
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void quitDriver() {
		WebDriver driver = threadLocaldriver.get();
		if (driver != null) {
			driver.quit();
			threadLocaldriver.remove();
		}
	}
}
