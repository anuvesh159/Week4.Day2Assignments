package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDraggable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Actions builder = new Actions(driver);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame);
        
        WebElement dragEle = driver.findElement(By.xpath("//div[@id='draggable']"));
        builder.dragAndDropBy(dragEle, 100, 200).perform();
       
        
        
        
        
        
        
        
	}

}
