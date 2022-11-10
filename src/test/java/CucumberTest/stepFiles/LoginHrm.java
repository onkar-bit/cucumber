package CucumberTest.stepFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginHrm {
	
	WebDriver driver;
	
	@Before
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		this.driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	
	@Given("^User navigate to orange hrm website$")
	public void user_navigate_to_orange_hrm_website() throws Throwable {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

	}


	@And("^User enter valid username$")
	public void user_enter_valid_username() throws Throwable {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");

	}

	@And("^User enter valid password$")
	public void user_enter_valid_password() throws Throwable {
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");

	}

	@When("^User clicked on Login button$")
	public void user_clicked_on_Login_button() throws Throwable {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

	}

	@Then("^User will successfully logged in$")
	public void user_will_successfully_logged_in() throws Throwable {
		String msg = driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText();
		
		if(msg.equals(msg)) {
			System.out.println("successfully logged in test PASS");
		}
		else {
			System.out.println("not logged in test FAIL");
		}
		
		//Logout
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		

	}
	
	//Invalid Login check
	@Given("^User is on orange hrm website$")
	public void user_is_on_orange_hrm_website() throws Throwable {
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@And("^User enter invalid username and password$")
	public void user_enter_invalid_username_and_password() throws Throwable {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("abc111");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ssdfg");

	}

	@When("^User click on Login button on page$")
	public void user_click_on_Login_button_on_page() throws Throwable {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

	}

	@Then("^User will see error message and not logged in$")
	public void user_will_see_error_message_and_not_logged_in() throws Throwable {
		String errormsg = driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
		if(errormsg.contains("Invalid")) {
			System.out.println("test PASS");
		}
		else {
			System.out.println("test FAIL");
		}

	}
	

	}

