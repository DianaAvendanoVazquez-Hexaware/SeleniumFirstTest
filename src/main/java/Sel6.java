import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Sel6 {

	public static void main(String[] args) {
		// chrome.exe --> Chrome browser
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\Hexaware\\Selenium1\\chromedriver.exe");
				
				//webdriver.chrome.driver --> value of path
				WebDriver driver = new ChromeDriver();
				
				//6. 'buy Product' feature
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				//webpage
				//home page
				//driver.get("http://automationpractice.com/index.php"); 
				//login page
				driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
				
				//log in
				driver.findElement(By.id("email")).sendKeys("holi@email.com");
				driver.findElement(By.id("passwd")).sendKeys("P@ssw0rd");
				driver.findElement(By.xpath("//button[@id=\'SubmitLogin\']/span")).click();
				
				//we instantiate the packages needed to perform actions on the webpage
				Actions actions = new Actions(driver);
				
				//6. 'Buy Product' feature
				
				//looks for the woman tab
				WebElement women = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
				actions.moveToElement(women).perform();
				driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
			
				//look for the second element of women catalogue
				driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[2]/div/div[2]/div[2]/a[2]/span")).click();
				
				//increase quantity
				driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]/span/i")).click();
				//select large size
				driver.findElement(By.xpath("//*[@id=\"group_1\"]")).click();
				driver.findElement(By.xpath("//option[@value='3']")).click();
				//select colour
				driver.findElement(By.xpath("//*[@id=\"color_8\"]")).click();
				//add to cart
				driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
				
				//checkout
				driver.findElement(By.xpath("//*[@id=\'layer_cart\']/div[1]/div[2]/div[4]/a/span")).click();
				
				//summary
		        driver.findElement(By.xpath("//*[@id=\'center_column\']/p[2]/a[1]/span")).click();
		        //address
		        driver.findElement(By.xpath("//*[@id=\'center_column\']/form/p/button/span")).click();
		        	//terms and cond
		        driver.findElement(By.id("cgv")).click();
		        //shipping
		        driver.findElement(By.xpath("//*[@id=\'form\']/p/button/span")).click();
		        //payment (bank wire)
		        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
		        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
		        //get completion message
		        System.out.println(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText());
		        
		        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText(), 
						"Your order on My Store is complete.");

	}

}
