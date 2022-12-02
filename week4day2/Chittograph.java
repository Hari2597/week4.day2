package week4day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.time.Duration;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Chittograph {
public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver=new ChromeDriver();
	    driver.get(" https://www.chittorgarh.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.findElement(By.id("navbtn_stockmarket")).click();
	    driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();
	    List<WebElement> securityRow = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr"));
	    System.out.println(securityRow.size());
	    List<String> list =new ArrayList<String>();
	    for (int i = 1; i <securityRow.size(); i++) {
	    String nam = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr["+i+"]//td[3]")).getText();	
	    list.add(nam);
	    System.out.println(nam);
		}
	    int size = list.size();
	    System.out.println("List Size "+ size);
	    Set<String> set = new LinkedHashSet<String>(list);
	    int size2 = set.size();
	    System.out.println("Set Size "+size2);
	    if (size==size2) {
			System.out.println("Dup Not Remove");
		}
	    else {
			System.out.println("Dup Removed");
		}
	}
}
