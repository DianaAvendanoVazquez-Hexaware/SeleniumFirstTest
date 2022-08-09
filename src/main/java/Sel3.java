import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sel3 {

	public static void main(String[] args) {
		
		//3. Verify error messages for mandatory fields.
		
		//random mails
				Random rand = new Random();
			    int upperbound = 200;
			    int int_random = rand.nextInt(upperbound);
				String email = "user"+ int_random +"@email.com";
				
		// chrome.exe --> Chrome browser
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\Hexaware\\Selenium1\\chromedriver.exe");
				
				//webdriver.chrome.driver --> value of path
				WebDriver driver = new ChromeDriver();
				
				//1. Automate User Registration process of e-commerce website.
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				//webpage
		/*		driver.get("http://automationpractice.com/index.php");
				
				//locate sign in and click on it
				driver.findElement(By.linkText("Sign in")).click();
				
				//create an account
				//Thread.sleep(4000);
				driver.findElement(By.xpath("//input[@id='email_create']")).clear();

				driver.findElement(By.xpath("//input[@id='email_create']")).click();
				driver.findElement(By.cssSelector("input[id='email_create']")).sendKeys("usuario12@email.com"); //user
				driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();//submit
		*/		
				driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
				
				driver.findElement(By.xpath("//input[@id='email_create']")).click();				
				//create account --> type email
				driver.findElement(By.cssSelector("input[id='email_create']")).sendKeys(email); //user
				driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();//submit
				
				//--------------------------------------------------
				
				//Gender
				driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
				//dia
				driver.findElement(By.xpath("//div[@id='uniform-days']")).click();
				driver.findElement(By.xpath("//option[@value='28']")).click();
				//mes
				driver.findElement(By.xpath("//div[@id='uniform-months']")).click();
				driver.findElement(By.xpath("//select[@id=\"months\"]/option[5]")).click();
				//year
				driver.findElement(By.xpath("//div[@id='uniform-years']")).click();
				driver.findElement(By.xpath("//option[@value='1993']")).click();
				
				//company
				driver.findElement(By.id("company")).sendKeys("Hexaware");
				//address2
				driver.findElement(By.id("address2")).sendKeys("Jalisco");
				//comments
				driver.findElement(By.id("other")).sendKeys("Nothing more");
				//alias
				driver.findElement(By.id("alias")).sendKeys("My Home");
				//submit
				driver.findElement(By.xpath("//button[@id=\'submitAccount\']/span")).click();
				
				System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText());
				String errmssg = "There are 8 errors\n"
						+"You must register at least one phone number.\n"
						+"lastname is required.\n"
						+"firstname is required.\n"
						+"passwd is required.\n"
						+"address1 is required.\n"
						+"city is required.\n"
						+"The Zip/Postal code you\'ve entered is invalid. It must follow this format: 00000\n"
						+"This country requires you to choose a State.";
				
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText(), errmssg);
				driver.close();
	}

}
