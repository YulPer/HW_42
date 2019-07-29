package facebook;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.*;

public class Chrome {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		Logger.getLogger("").setLevel(Level.OFF);
		
		String driverPath = "";
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			driverPath = "./resources/webdrivers/mac/chromedriver";
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
			driverPath = "./resources/webdrivers/pc/chromedriver.exe";
		else
			throw new IllegalArgumentException("Unknown OS");
		System.setProperty("webdriver.gecko.driver", driverPath);
		System.setProperty("webdriver.gecko.silentOutput", "true");
		ChromeOptions option = new ChromeOptions();
		driver = new ChromeDriver(option);
		
		System.out.println("Browser is: Chrome");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://facebook.com/");
		Thread.sleep(1000);
		System.out.println("Title: " + driver.getTitle());
		
		driver.findElement(By.id("email")).sendKeys("superlulu@mail.ru");
		driver.findElement(By.id("pass")).sendKeys("************");
		driver.findElement(By.xpath("//*[@id=\"u_0_a\"]")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).click();
		Thread.sleep(15000);
		String friends = driver.findElement(By.xpath("///*[@id=\"u_fetchstream_3_8\"]/li[3]/a/span[1]")).getText();
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