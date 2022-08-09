import java.util.Random;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;

public class Selenium1 {

	public static void main(String[] args) throws InterruptedException {
		
		//random mails
		Random rand = new Random();
	    int upperbound = 200;
	    int int_random = rand.nextInt(upperbound);
		String email = "user"+ int_random +"@email.com";
		//email = "holi@email.com";
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
		
		//--------------------------------------------------------------------------------------------------
		//Gender
		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		//FirstName
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("John");
		//LastName
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Doe"); 
		//password
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("P@ssw0rd");
		//dia
		driver.findElement(By.xpath("//div[@id='uniform-days']")).click();
		driver.findElement(By.xpath("//option[@value='28']")).click();
		//mes
		driver.findElement(By.xpath("//div[@id='uniform-months']")).click();
		driver.findElement(By.xpath("//select[@id=\"months\"]/option[5]")).click();
		//year
		driver.findElement(By.xpath("//div[@id='uniform-years']")).click();
		driver.findElement(By.xpath("//option[@value='1993']")).click();
		
		//YOUR ADDRESS
		//name
		driver.findElement(By.id("firstname")).sendKeys("John");
		//last name
		driver.findElement(By.id("lastname")).sendKeys("Doe");
		//company
		driver.findElement(By.id("company")).sendKeys("Hexaware");
		//address1
		driver.findElement(By.id("address1")).sendKeys("Guadalajara");
		//address2
		driver.findElement(By.id("address2")).sendKeys("Jalisco");
		//city text
		driver.findElement(By.id("city")).sendKeys("Gdl");
		//state
		driver.findElement(By.id("id_state"));
		driver.findElement(By.xpath("//select[@id=\'id_state\']/option[20]")).click();
		//zip code
		driver.findElement(By.id("postcode")).sendKeys("54321");
		//driver.findElement(By.id("id_country")).click();
		//comments
		driver.findElement(By.id("other")).sendKeys("Nothing more");
		//phone
		driver.findElement(By.id("phone")).sendKeys("33344455");
		//phone2
		driver.findElement(By.id("phone_mobile")).sendKeys("33355544");
		//alias
		driver.findElement(By.id("alias")).sendKeys("My Home");
		
		driver.findElement(By.xpath("//button[@id=\'submitAccount\']/span")).click();
		
		//checks that creation account message appears
		System.out.println(driver.findElement(By.xpath("//div[@id=\'center_column\']/p")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\'center_column\']/p")).getText(), 
				"Welcome to your account. Here you can manage all of your personal information and orders.");
		
		
	}

}
