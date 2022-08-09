import java.time.Duration;

import org.asynchttpclient.netty.channel.DefaultChannelPool.PoolLeaseStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class sel2 {

	public static void main(String[] args) {
		
		// chrome.exe --> Chrome browser
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\Hexaware\\Selenium1\\chromedriver.exe");
				
				//webdriver.chrome.driver --> value of path
				WebDriver driver = new ChromeDriver();
				
				//2. Verify invalid email address error.
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				//webpage
/*				driver.get("http://automationpractice.com/index.php");
				
				//locate sign in and click on it
				driver.findElement(By.linkText("Sign in")).click();
*/
				String email  = "text";
				driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
				driver.findElement(By.xpath("//input[@id='email_create']")).click();
				//create account --> type email
				driver.findElement(By.cssSelector("input[id='email_create']")).sendKeys(email); //user
				driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();//submit
				
				//String errmssg = "Invalid email address.";
				
				System.out.println(driver.findElement(By.xpath("//div[@id=\"create_account_error\"]/ol/li")).getText());
				Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"create_account_error\"]/ol/li")).getText(), "Invalid email address.");
				System.out.println("Hello");
	}

}
