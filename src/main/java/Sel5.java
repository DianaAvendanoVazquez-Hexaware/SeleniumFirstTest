import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class Sel5 {
	
	public static void main(String[] args) {
		// chrome.exe --> Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\Hexaware\\Selenium1\\chromedriver.exe");
		
		//webdriver.chrome.driver --> value of path
		WebDriver driver = new ChromeDriver();
		
		//5. 'Search Product' feature
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//webpage
		driver.get("http://automationpractice.com/index.php");
		
		//we instantiate the packages needed to perform actions on the webpage
		Actions actions = new Actions(driver);
				
		//looks for the woman tab
		WebElement women = driver.findElement(By.xpath("//div[@id=\"block_top_menu\"]/ul/li[1]/a"));
		actions.moveToElement(women).perform();
		//click in the t'shirt option
		driver.findElement(By.xpath("//div[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();		
		
		//look for the name of a product
		String product =  driver.findElement(By.xpath("//div[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")).getText();
		//System.out.println(product);
		
		//search for the product in the search bar
		driver.findElement(By.id("search_query_top")).sendKeys(product,Keys.ENTER);
		
		System.out.println(driver.findElement(By.xpath("//div[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")).getText());
		//test
		Assert.assertEquals(product, 
				driver.findElement(By.xpath("//div[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")).getText() );
		
		driver.close();
		
	}

}
