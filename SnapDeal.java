package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Actions builder = new Actions(driver);
		
		WebElement Mensfashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		builder.moveToElement(Mensfashion).perform();
		
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		WebElement countofsportsshoes = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		System.out.println(countofsportsshoes.getText());
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='sort-label']/following-sibling::div[1]")).click();
		driver.findElement(By.xpath("(//ul[@class='sort-value']//li)[2]")).click();
		Thread.sleep(2000);
		ArrayList<String> shoesList = new ArrayList<String>();
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='product-price-row clearfix]"));
		Thread.sleep(2000);
		for (WebElement shoes : findElements) {
			
			shoesList.add(shoes.getText());
			
		}
		
		ArrayList<String> shoes1List = new ArrayList<String>();
		
		for (String shoes : shoes1List) {
			shoes1List.add(shoes);	
			
		}
		
		Collections.sort(shoes1List);
		if(shoesList==shoes1List)
			System.out.println("The Shoes are sorted properly");
		else
			System.out.println("The Shoes are not sorted properly");
		Thread.sleep(2000);
		
		WebElement fromval = driver.findElement(By.xpath("//div/input[@name='fromVal']"));
		fromval.clear();
		fromval.sendKeys("900",Keys.TAB);
		
		WebElement toval = driver.findElement(By.xpath("//div/input[@name='toVal']"));
		toval.clear();
		toval.sendKeys("1200",Keys.TAB);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='view-more-button btn btn-line btn-theme-secondary viewMoreFilter']")).click();
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		
		List<WebElement> filter = driver.findElements(By.xpath("//div[@class='filters']"));
		for (WebElement applied : filter) {
			String text = applied.getText();
			System.out.println(text);
			
			WebElement mousehover = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
			builder.moveToElement(mousehover).perform();
			
			driver.findElement(By.xpath("//div[@id=\"636403746951\"]/div[2]/div[2]/div")).click();
			
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> viewpage = new ArrayList<String>(windowHandles);
			System.out.println(viewpage.size());
			
			driver.switchTo().window(viewpage.get(1));
			
			String cost = driver.findElement(By.xpath("//div[@class='disp-table']")).getText();
			System.out.println(cost);
			
			String discount = driver.findElement(By.xpath("//span[@class='pdpDiscount ']")).getText();
			System.out.println(discount);
			
			File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
			File destiny = new File("./images/snapdeal.png");
			FileUtils.copyFile(screenshotAs, destiny);
			
			driver.close();
			driver.switchTo().window(viewpage.get(0));
			
			
			
			
			
			
			
		}
		
		
	}

}
