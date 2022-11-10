package CucumberTest.stepFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	WebDriver driver;
	
	@Before
	public void launch() {
		System.setProperty("webdriver.chrome.driver","C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}
	
	
	@After
	public void close() {
		this.driver.manage().deleteAllCookies();
		this.driver.close();
		
	}

	
	@Given("^User navigate to stack overflow website$")
	public void user_navigate_to_stack_overflow_website() throws Throwable {
		driver.navigate().to("https://stackoverflow.com/");

	}

	@And("^User clicks on the login button on homepage$")
	public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Log in']")).click();

	}

	@And("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("omkarbande30@gmail.com");

	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("omkar96@");

	}

	@When("^user clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.xpath("//button[@id='submit-button']")).click();

	}

	@Then("^User should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
		String msg = driver.findElement(By.xpath("//h1[normalize-space(text())='Top Questions']")).getText();
		
		if(msg.equals(msg)) {
			System.out.println("Successfully logged in test PASS");
		}
		else {
			System.out.println("not logged in test FAIL");
		}

	}

}
