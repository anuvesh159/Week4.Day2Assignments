package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerySortable {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Actions builder = new Actions(driver);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		WebElement Item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement Item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement Item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		WebElement Item7 = driver.findElement(By.xpath("//li[text()='Item 7']"));
		
		Thread.sleep(2000);
		
		builder.clickAndHold(Item2).moveToElement(Item7).release().perform();
		builder.clickAndHold(Item4).moveToElement(Item6).release().perform();
		
		

	}

}
