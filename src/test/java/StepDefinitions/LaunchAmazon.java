package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class LaunchAmazon {
	WebDriver driver =null;
	
	@Given("browser is open")
	public void browser_is_open() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("The WebDriver initialization is successful.");
	}

	@And("user is navigated to the Amazon webpage")
	public void user_is_navigated_to_the_amazon_webpage() {
		String URL = "https://www.amazon.com";
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The launch of Amazon webpage is successful.");
	}

	@Then("validate the title")
	public void validate_the_title() {
		String expected ="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";		
		Assert.assertEquals(expected, driver.getTitle());
		System.out.println("The title displayed is valid.");
	}

	@And("browser is closed")
	public void browser_is_closed() {
		driver.close();
		driver.quit();
		System.out.println("The browser is closed successfully.");
	}

}
