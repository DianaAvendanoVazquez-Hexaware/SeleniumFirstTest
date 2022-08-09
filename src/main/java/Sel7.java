import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Sel7 {

	public static void main(String[] args) {

		// chrome.exe --> Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\Hexaware\\Selenium1\\chromedriver.exe");
		
		//7. Verify that 'Add to Wishlist' only works after login.
		
		//webdriver.chrome.driver --> value of path
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//webpage
		//home page
		driver.get("http://automationpractice.com/index.php");
		
		//we instantiate the packages needed to perform actions on the webpage
		Actions actions = new Actions(driver);
		
		//looks for the woman tab
		WebElement women = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		actions.moveToElement(women).perform();
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
		
		//look for the second element of women catalogue
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[3]/div[1]/a")).click();
		
		//error message
		System.out.println(driver.findElement(By.xpath("//*[@id=\"category\"]/div[2]/div/div/div/div/p")).getText());
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"category\"]/div[2]/div/div/div/div/p")).getText(), 
				"You must be logged in to manage your wishlist.");

	}

}
