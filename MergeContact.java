package Week4.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver =new ChromeDriver(); 

		driver.get("http://leaftaps.com/opentaps");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		String text =driver.findElement(By.tagName("h2")).getText();

		System.out.println(text);

		Thread.sleep(3000);

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Contacts")).click();

		driver.findElement(By.linkText("Merge Contacts")).click();

		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();

		Set<String> newWindow=driver.getWindowHandles();

		List<String> allWindow=new ArrayList<String>(newWindow);

		driver.switchTo().window(allWindow.get(1));

		driver.findElement(By.name("id")).sendKeys("10249");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@class='x-btn-text']")).click();

		driver.findElement(By.linkText("10249")).click();

		Thread.sleep(3000);	

		newWindow=driver.getWindowHandles();

		allWindow=new ArrayList<String>(newWindow);

		driver.switchTo().window(allWindow.get(0));

		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();

		newWindow=driver.getWindowHandles();

		allWindow=new ArrayList<String>(newWindow);

		driver.switchTo().window(allWindow.get(1));

		driver.findElement(By.name("id")).sendKeys("10246");

		Thread.sleep(3000);	

		driver.findElement(By.xpath("//button[@class='x-btn-text']")).click();

		Thread.sleep(3000);	

		driver.findElement(By.linkText("10246")).click();

		newWindow=driver.getWindowHandles();

		allWindow=new ArrayList<String>(newWindow);

		driver.switchTo().window(allWindow.get(0));

		driver.findElement(By.linkText("Merge")).click();

		Alert alert=driver.switchTo().alert();

		alert.accept();

		System.out.println(driver.getTitle());

		driver.close();


	}
}
