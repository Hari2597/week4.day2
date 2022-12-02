package week4day2;

import java.awt.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Html {
public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://html.com/tags/table/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']")).getText();
java.util.List<WebElement> list = driver.findElements(By.xpath("(//table[caption='The Three Most Popular JavaScript Libraries'])//tr"));
System.out.println("Print row count :"+list.size());
java.util.List<WebElement> list2 = driver.findElements(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']//th"));
System.out.println("Print column count :"+list2.size());
String data1 = driver.findElement(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']//th[1]")).getText();
System.out.println(data1);
String data2 = driver.findElement(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']//th[2]")).getText();
System.out.println(data2);
String data3 = driver.findElement(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']//th[3]")).getText();
System.out.println(data3);
String data4 = driver.findElement(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']//th[4]")).getText();
System.out.println(data4);
String row1 = driver.findElement(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']//tr[1]/td[1]")).getText();
System.out.println(row1);
String drow2 = driver.findElement(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']//tr[1]/td[2]")).getText();
System.out.println(drow2);
String drow3 = driver.findElement(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']//tr[1]/td[3]")).getText();
System.out.println(drow3 );
String drow4 = driver.findElement(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']//tr[1]/td[4]")).getText();
System.out.println(drow4);
String row2 = driver.findElement(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']//tr[2]/td[1]")).getText();
System.out.println(row2);
String drow = driver.findElement(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']//tr[2]/td[2]")).getText();
System.out.println(drow);
String drow1 = driver.findElement(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']//tr[2]/td[3]")).getText();
System.out.println(drow1);
String drow5 = driver.findElement(By.xpath("//table[caption='The Three Most Popular JavaScript Libraries']//tr[2]/td[4]")).getText();
System.out.println(drow5);
String colmn = driver.findElement(By.xpath("//em[text()='Market Share']")).getText();
System.out.println(colmn);
driver.close();
}
}