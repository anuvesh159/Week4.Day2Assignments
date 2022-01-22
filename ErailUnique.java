package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		WebElement from = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		from.clear();
		from.sendKeys("MS");
		Thread.sleep(1000);
		from.sendKeys(Keys.TAB);
		
		WebElement to = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		to.clear();
		to.sendKeys("MDU");
		Thread.sleep(1000);
		to.sendKeys(Keys.TAB);
		
	    Thread.sleep(2000);
		
	    int size = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
		List<String> tnames = new ArrayList<String>();
		
        
		for(int i=1; i<=size; i++) {
        	  
        	String names = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+ i +"]/td[2]")).getText();
			Thread.sleep(500);
			tnames.add(names);
			}
		
		int size2 = tnames.size();
		System.out.println(size2);
		
		Set<String> uniq = new HashSet<String>(tnames);
		uniq.addAll(tnames);
		
		int size3 = uniq.size();
		System.out.println(size3);
		
		if(size2==size3)
			System.out.println("There are no duplicates");
		else
			System.out.println("Duplicates are present");
		driver.close();
			

	}

}
