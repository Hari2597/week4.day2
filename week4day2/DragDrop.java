package week4day2;

import java.awt.Point;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class DragDrop {
public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement move = driver.findElement(By.id("form:conpnl"));
		Actions act=new Actions (driver);
		act.dragAndDropBy(move, 500, 50).perform();
		System.out.println("moved the box");
		WebElement from = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		WebElement to = driver.findElement(By.xpath("//div[@id='form:drop']"));
		act.dragAndDrop(from, to).perform();
		System.out.println("moved and dropped the box");
	}
}