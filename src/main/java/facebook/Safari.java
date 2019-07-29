package facebook;

import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;

public class Safari {
	public static void main(String[] args) throws InterruptedException {
		Logger.getLogger("").setLevel(Level.OFF);
		WebDriver driver;
		driver = new SafariDriver();
		driver.manage().window().maximize();
		System.out.println("Browser is: Safari");
		driver.get("http://facebook.com/");
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("superlulu@mail.ru");
		driver.findElement(By.id("pass")).sendKeys("************");
		driver.findElement(By.id("u_0_2")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).click();
		Thread.sleep(15000);
		String friends = driver.findElement(By.xpath("//*[@id=\"u_fetchstream_3_8\"]/li[3]/a/span[1]")).getText();
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