package Week4.day1.assignments;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver =new ChromeDriver(); 

		driver.get("https://www.nykaa.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Actions action=new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//a[text()='brands']"))).build().perform();

		action.moveToElement(driver.findElement(By.xpath("//a[text()='Popular']"))).build().perform();

		driver.findElement(By.xpath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']")).click();

		Set<String> newWindow=driver.getWindowHandles();

		List<String> allWindow=new ArrayList<String>(newWindow);

		driver.switchTo().window(allWindow.get(1));

		Thread.sleep(3000);

		String title = driver.getTitle();

		if(title.contains("L'Oreal Paris"))
		{
			System.out.println("Title contains L'Oreal Paris");
		}

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Sort By : ']")).click();
		
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='pull-right filter-options-toggle']")).click();
		
		driver.findElement(By.xpath("//div[@class='filter-options-toggle']")).click();
		
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		
		driver.findElement(By.xpath("//div[@class='control__indicator']")).click();

		String shampoo = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']/li")).getText();
		
		if(shampoo.contains("Shampoo")) {
			System.out.println("Shampoo is applied");
		}

		driver.findElement(By.xpath("//div[@id='listingContainer']/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[10]/div[1]/a[1]/div[1]/div[2]/div[1]/h2[1]/span[1]")).click();

		newWindow=driver.getWindowHandles();

		allWindow=new ArrayList<String>(newWindow);

		driver.switchTo().window(allWindow.get(2));
		
		driver.findElement(By.xpath("//span[text()='175ml']")).click();

		String MRP=driver.findElement(By.xpath("//span[@class='post-card__content-price-offer']")).getText();

		System.out.println(MRP);

		driver.findElement(By.xpath("//button[text()='ADD TO BAG']")).click();

		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		
		Thread.sleep(2000);

		String GrandTotal=driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div")).getText();
		
		GrandTotal=GrandTotal.replaceAll("\\D", "").trim();
		int grandTotal=Integer.parseInt(GrandTotal);
		System.out.println("Grand Total:"+grandTotal);

		Thread.sleep(7000);
		
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

		String CheckTotal=driver.findElement(By.xpath("//span[text()='205']")).getText();
		
		CheckTotal=CheckTotal.replaceAll("\\D", "").trim();
		int total=Integer.parseInt(CheckTotal);
		System.out.println("Grand Total final page:"+total);

		if(total==grandTotal)
		{
			System.out.println("Both are equal");
		}

		Thread.sleep(5000);

		driver.quit();



	}

}
