package week4.day2;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundSortable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		int size = driver.findElements(By.xpath("//table[@id='table_id']//tbody/tr")).size();
		
		List<String> names = new ArrayList<String>();
		
		for(int i=1; i<=size; i++)
		{
			String value = driver.findElement(By.xpath("//table[@id='table_id']//tbody/tr[\"+ i +\"]/td[2]")).getText();
		
	        names.add(value);	
		}
		
		System.out.println(names);
		Collections.sort(names);
		System.out.println(names);
		
		WebElement header = driver.findElement(By.xpath("//th[text()='Name']"));
		header.click();
		
		List<String> n2 = new ArrayList<String>();
		
		for(int i=1; i<=size; i++)
		{
			String text = driver.findElement(By.xpath("//table[@id='table_id']//tbody/tr[\"+ i +\"]/td[2]")).getText();
	        n2.add(text);
	        
  		
		}
		
		System.out.println(n2);
		
		if(n2.equals(names))
			
			System.out.println("Sort is Done");
		
		else
			
			System.out.println("Sort is not done");
			
		

	}

}
