package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DemoTests {
	public static void main(String[] args) throws InterruptedException {
		 
		   WebDriver driver = new ChromeDriver();
		   ChromeOptions option = new ChromeOptions();
		   option.setAcceptInsecureCerts(true);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   driver.get("https://web.whatsapp.com/");
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofDays(86400));
		   WebElement qr= driver.findElement(By.xpath("//div[text()='Use WhatsApp on your computer']"));
		   System.out.println("Please Scan the QR code for your smartphone");
		   Thread.sleep(20000);
		   WebElement chat = driver.findElement(By.cssSelector(".x1qlqyl8.x1pd3egz.xcgk4ki"));
		   wait.until(ExpectedConditions.visibilityOf(chat));
		   System.out.println(chat.getText());
		   driver.findElement(By.xpath("//span[@title='My Voda Orissa']")).click();
		   
		
	}
}
