package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions builder = new Actions(driver);
		
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("oneplus 9 pro ");
		
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		WebElement priceof1pro = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String price = priceof1pro.getText();
		String replaceAll = price.replaceAll("[^1-9]", "");
		int parseInt = Integer.parseInt(replaceAll);
		System.out.println(parseInt);
		Thread.sleep(2000);
		
		WebElement rating = driver.findElement(By.xpath("(//div[@class='sg-col-inner']//div/div//div/span/following-sibling::span/a/span)[1]"));
		String cr1 = rating.getText();
		System.out.println(cr1);
		Thread.sleep(1000);
		
		WebElement stars = driver.findElement(By.xpath("(//span[@class='a-icon-alt'])[1]"));
		builder.moveToElement(stars).perform();
		Thread.sleep(1000);
		
		WebElement percentage = driver.findElement(By.xpath("(//span[text()='4.3 out of 5'])[2]"));	
		String per = percentage.getText();
		System.out.println(per);
		
		driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		
		File screenshot= driver.getScreenshotAs(OutputType.FILE);
		File destination= new File("./images/Amazon.png");
		FileUtils.copyFile(screenshot, destination);
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button']//input\")")).click();
		
		WebElement subtotal  = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']"));
		String sub = subtotal.getText();
		String replaceAll2 = sub.replaceAll("[^1-9]","");
		int parseInt2 = Integer.parseInt(replaceAll2);
		
		System.out.println(parseInt2);
		
		if(parseInt2==parseInt)
			
			System.out.println("subtotal and total and priceof1pro is correct");
		
		else
			
			System.out.println("subtotal and total and priceof1pro is not correct");
		
		
	}

}
