package week4day2;

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
public class AmazonAdv {
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("price of the product---->"+price);
		driver.findElement(By.xpath("//a[@class='a-popover-trigger a-declarative']")).click();
		String starno= driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-beside-button a-text-bold']")).getText();
		System.out.println("star value----------->"+ starno);
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
        Set<String> wh = driver.getWindowHandles();
		List<String>Page=new ArrayList<String>(wh);
		driver.switchTo().window(Page.get(1));
		File photo = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("amazon.png");
		FileUtils.copyFile(photo, dest);
		driver.findElement(By.id("add-to-cart-button")).click();
	    Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
		String subtotal = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")).getText();
		System.out.println("Sub Total Value------->"+subtotal);
		if(price==subtotal) {
		System.out.println("the prices are equal");
		}
		else
		{
		System.out.println("the prices are not equal");
		}
		driver.switchTo().window(Page.get(0));
		driver.close();
	}

}
