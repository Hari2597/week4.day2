package week4day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Myntra {
public static void main(String[] args) throws IOException, InterruptedException {
    WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement men = driver.findElement(By.xpath("//div[@class='desktop-navLink']"));
        Actions act=new Actions(driver);
		act.moveToElement(men).perform();
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("the number of items present----"+ count);
		driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[text()='Duke']")).click();
		driver.findElement(By.xpath("//span[contains(@class,'FilterDirectory-close')]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']")).click();
		driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[1]/section/div[1]/div[1]/div/div/div/ul/li[4]/label")).click();
		driver.findElement(By.xpath("//label[text()='50% and above']")).click();
		driver.findElement(By.xpath("//img[@alt='Duke Men Green Bomber Jacket']")).click();
		Set<String> wh = driver.getWindowHandles();
		List<String>list1=new ArrayList<String>(wh);
		driver.switchTo().window(list1.get(1));
		String Name = driver.findElement(By.className("pdp-name")).getText();
		String price = driver.findElement(By.className("pdp-price")).getText().replaceAll("[^0-9]", "");
		String offer = driver.findElement(By.className("pdp-discount")).getText();
		System.out.println("Item Name:	"+Name+"\nRate:	Rs."+price+"\nDiscount:	"+offer);
		driver.quit();
		}
}