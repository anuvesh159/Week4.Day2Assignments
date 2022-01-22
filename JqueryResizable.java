package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryResizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Actions builder = new Actions(driver);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		WebElement Ele1 = driver.findElement(By.xpath("//div[@id='resizable']"));
		
		WebElement Ele2 = driver.findElement(By.xpath("//div[@id='resizable']/div[@class='ui-resizable-handle ui-resizable-e']"));
	
	    builder.clickAndHold(Ele1).moveToElement(Ele2, 200, 56).release().perform();
	
	}

}
