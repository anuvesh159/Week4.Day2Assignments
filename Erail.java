package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("MS");
		Thread.sleep(500);
		from.sendKeys(Keys.TAB);
		
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("MDU");
		Thread.sleep(500);
		to.sendKeys(Keys.TAB);
		
		Thread.sleep(200);
		
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		
	    int rows = driver.findElements(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']//tr")).size();
		
	   List<String> traiNames = new ArrayList<String>();
	   
	    for (int i = 1; i <=rows; i++) {
		   
		   String trainName = driver.findElement(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']//tr["+ i +"]/td[2]")).getText();
		
		   traiNames.add(trainName);
		   
	    }
		   
		   Set<String> trains = new HashSet<String>(traiNames);
		   
		   if(traiNames.size()==trains.size()) {
			   
			   System.out.println("There is no duplicates");
		   }
		   else
		   {
			   System.out.println("There is no duplicates");
		   }
	
		

	}

}
