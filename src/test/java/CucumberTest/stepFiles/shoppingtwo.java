package CucumberTest.stepFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class shoppingtwo {
	
	WebDriver driver;
	
	@Before
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Given("^User nevigate to the shopping website$")
	public void user_nevigate_to_the_shopping_website() throws Throwable {
		
		driver.get("http://automationpractice.com/index.php");

	}

	@And("^User click on sign in link$")
	public void user_click_on_sign_in_link() throws Throwable {
		driver.findElement(By.xpath("//a[@class='login']")).click();

	}

	@And("^User enters valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_valid_and(String Username, String Password) throws Throwable {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(Password);

	}

	@When("^User click on logged in button$")
	public void user_click_on_logged_in_button() throws Throwable {
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();

	}

	@Then("^Verify successful logged in display my account dashboard$")
	public void verify_successful_logged_in_display_my_account_dashboard() throws Throwable {
		
		String text = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
		
		if(text.contains("ACCOUNT")) {
			System.out.println("login sucess test PASS");
		}
		else {
			System.out.println("login fail test FAIL");
		}

	}
	
	
}

