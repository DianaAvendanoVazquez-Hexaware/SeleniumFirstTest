import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sel8 {
	
	public static void main(String[] args) {
		//T8. Test Case - Verify that Total Price is reflecting correctly if user changes quantity on 'Shopping Cart Summary' Page.

		
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
		
		//choose quantity
		//driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]/span/i")).click();
		//select large size
		driver.findElement(By.xpath("//*[@id=\"group_1\"]")).click();
		driver.findElement(By.xpath("//option[@value='3']")).click();
		//select colour
		driver.findElement(By.xpath("//*[@id=\"color_8\"]")).click();
		//add to cart
		driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
		
		//checkout
		driver.findElement(By.xpath("//*[@id=\'layer_cart\']/div[1]/div[2]/div[4]/a/span")).click();
		
		//check for current price
		String price1 = driver.findElement(By.id("total_product_price_2_12_723852")).getText();
		System.out.println(driver.findElement(By.id("total_product_price_2_12_723852")).getText());
		//increase by one the quantity
		driver.findElement(By.xpath("//*[@id=\"cart_quantity_up_2_12_0_723852\"]/span/i")).click();
		//check new current price
		String price2 = driver.findElement(By.id("total_product_price_2_12_723852")).getText();
		System.out.println(driver.findElement(By.id("total_product_price_2_12_723852")).getText());
		
		
		if (price2 == price1) {
			System.out.println("The price didn't update");
		}else if (price2 == "$54.00"){
			System.out.println("The price updated successfully");
		}else {
		}
		
		
		
		
		
		
	}

}
