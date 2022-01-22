package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.nykaa.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	Actions builder = new Actions(driver);
	
	WebElement Brands = driver.findElement(By.xpath("//a[text()='brands']"));
	builder.moveToElement(Brands).perform();
	
	driver.findElement(By.xpath("//a[text()=\"L'Oreal Paris\"]")).click();
	System.out.println(driver.getTitle());
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//span[@class='sort-name']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
	Thread.sleep(500);
	
	driver.findElement(By.xpath("//span[text()='Category']")).click();
	Thread.sleep(500);
	driver.findElement(By.xpath("//span[text()='Hair']")).click();
	Thread.sleep(500);
	driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
	Thread.sleep(500);
	driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
	Thread.sleep(500);
	driver.findElement(By.xpath("//span[text()='Concern']")).click();
	Thread.sleep(500);
	driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
	Thread.sleep(2000);
	
	List<WebElement> filter = driver.findElements(By.xpath("//div[@class='css-rtde4j']"));
	for (WebElement whether : filter) {
		String loreal = whether.getText();
		System.out.println(loreal);
		
		if(loreal.contains("shampoo"))
			System.out.println("Filter is applied with Shampoo");
		else
			System.out.println("Filter is not applied with Shampoo");
		}
	  
	   driver.findElement(By.xpath("//div[@class='css-43m2vm']/img")).click();
	   Set<String> newWindow = driver.getWindowHandles();
	   List<String> window = new ArrayList<String>(newWindow);
	   driver.switchTo().window(window.get(1));
	   
	   WebElement drop1 = driver.findElement(By.xpath("//div[@class='css-11wjdq4']//select[1]"));
	   Select ML = new Select(drop1);
	   ML.selectByIndex(2);
	   System.out.println("ML of the Shampoo:"+ML);
	   
	   String MRP = driver.findElement(By.xpath("//span[@class='css-1888qy']/following-sibling::span[1]")).getText();
	   System.out.println(MRP);
	   
	   driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
	   Thread.sleep(2000);
	   
	   driver.findElement(By.xpath("//span[text()='1']")).click();
	   Thread.sleep(500);
	   
	   WebElement gtframe = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
	   driver.switchTo().frame(gtframe);
	   
	   //String GT = driver.findElement(By.xpath("(//div[@class='table-row ']//div)[2]")).getText();
	   //System.out.println(GT);
	   
	   WebElement GT = driver.findElement(By.xpath("(//div[@class='table-row ']//div)[2]"));
	   Thread.sleep(2000);
	   String GT1 = GT.getText();
	   String replaceAll = GT1.replaceAll("[^0-9]","");
	   int parseInt = Integer.parseInt(replaceAll);
	   System.out.println(parseInt);
	   
	   driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
	   driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
	   String GT2 = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
	   
	   String replaceAll1 = GT2.replaceAll("[^0-9]","");
	   int parseInt1 = Integer.parseInt(replaceAll1);
	   System.out.println(parseInt1);
	   
	   if(parseInt==parseInt1)
		   
		   System.out.println("The Grand Total is Same");
	   
	   else
		   
		   System.out.println("The Grand total is Not matched");
	   
	   driver.close();
	   driver.quit();
	   
	   
	
	
	
	
	
}
	
	

}
