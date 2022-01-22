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

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions builder = new Actions(driver);
		
		WebElement mousemen = driver.findElement(By.xpath("//a[text()='Men']"));
		builder.moveToElement(mousemen).perform();
		
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		
		String totalcount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String replaceAll = totalcount.replaceAll("[^0-9]","");
		int parseInt = Integer.parseInt(replaceAll);
		System.out.println(parseInt);
		
		List<WebElement> categories = driver.findElements(By.xpath("//ul[@class='categories-list']"));
		
		String jacks = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String replaceAll1 = jacks.replaceAll("[^0-9]","");
		int parseInt1 = Integer.parseInt(replaceAll1);
		System.out.println(parseInt1);
		
		String rjacks = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String replaceAll2 = rjacks.replaceAll("[^0-9]","");
		int parseInt2 = Integer.parseInt(replaceAll2);
		System.out.println(parseInt2);   
		
		int countMatches = parseInt1 + parseInt2;
		System.out.println(countMatches);
		
		if(countMatches==parseInt)
			System.out.println("count Matches");
		else
			System.out.println("count not matches");
		
		driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).click();
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[2]")).click();
		
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		
		driver.findElement(By.xpath("//input[@value='Duke']/parent::label[@class=' common-customCheckbox']")).click();
		
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		
		List<WebElement> brand = driver.findElements(By.xpath("product-brand"));
		
		System.out.println(brand.size());
		
		Thread.sleep(2000);
		
		WebElement sort = driver.findElement(By.xpath("myntraweb-sprite sort-downArrow sprites-downArrow"));
		sort.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='sort-list']/li[3]")).click();
		Thread.sleep(2000);
		
		String firsteleprice = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println(firsteleprice);
		
		driver.findElement(By.xpath("(//div[@class='product-sliderContainer'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File Destination = new File("./images/Myntra.png");
		FileUtils.copyFile(screenshot, Destination);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconWishlist sprites-headerWishlist']")).click();
		driver.close();
		driver.switchTo().window(window.get(0)).close();
		
	}

}
