package week4day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
public class TableNew {
public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions build = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("//p[text()='Drag to target']"));
		WebElement b = driver.findElement(By.xpath("//span[text()='Droppable Target']"));
		build.dragAndDrop(a,b).perform();		
		System.out.println("element drag and drop in the respective place");
		driver.close();
	}
}
