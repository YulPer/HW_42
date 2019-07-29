package facebook;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import java.util.logging.*;

public class Firefox {
	public static void main(String[] args) throws InterruptedException {
		Logger.getLogger("").setLevel(Level.OFF);
		WebDriver driver;
		String driverPath = "";
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			driverPath = "./resources/webdrivers/mac/geckodriver";
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
			driverPath = "./resources/webdrivers/pc/geckodriver.exe";
		else
			throw new IllegalArgumentException("Unknown OS");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000); // Pause in milliseconds (1000 – 1 sec)
		System.out.println("Title: " + driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("superlulu@mail.ru");
		driver.findElement(By.id("pass")).sendKeys("************2");
		driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div/a/span/span")).click();
		Thread.sleep(15000);
		String friends = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/div/div[2]/div[2]/ul/li[3]/a/span[1]")).getText();
		System.out.println("You have: " + friends + " friends");
		Thread.sleep(5000);
		// Click on Account Settings
		driver.findElement(By.id("userNavigationLabel")).click();
		Thread.sleep(2000);
		// Click on Log out button
		driver.findElement(By.linkText("Log Out")).click();
		driver.quit();
	}
}