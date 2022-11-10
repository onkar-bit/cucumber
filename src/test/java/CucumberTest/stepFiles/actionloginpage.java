package CucumberTest.stepFiles;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class actionloginpage {
	
	WebDriver driver;
	
	@Before
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@Given("^User nevigate to login page$")
	public void user_nevigate_to_login_page() throws Throwable {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

	}

	@And("^User enter valid credentials to login$")
	public void user_enter_valid_credentials_to_login(DataTable user) throws Throwable {
		List<List<String>> data =user.raw();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(data.get(0).get(0));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(data.get(0).get(1));

	}

	@When("^Click on login button$")
	public void click_on_login_button() throws Throwable {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

	}

	@Then("^Verify dashboard will open$")
	public void verify_dashboard_will_open() throws Throwable {
		String txt = driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText();
		
		if(txt.equals(txt)) {
			System.out.println("dashboard open test PASS");
		}
		else {
			System.out.println("dashboard not open test FAIL");
		}

	}
	
	//using data table map
	@Given("^User nevigate to login page to login$")
	public void user_nevigate_to_login_page_to_login() throws Throwable {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

	}

	@And("^User enter valid credentials to login page$")
	public void user_enter_valid_credentials_to_login_page(DataTable userdata) throws Throwable {
		List<Map<String,String>> act = userdata.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(act.get(0).get("Username"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(act.get(0).get("Password"));

	}

	@When("^User Click on login button$")
	public void user_Click_on_login_button() throws Throwable {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

	}

	@Then("^Verify dashboard will open after click on login$")
	public void verify_dashboard_will_open_after_click_on_login() throws Throwable {
		
		String txt = driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText();
		
		if(txt.equals(txt)) {
			System.out.println("dashboard open test PASS");
		}
		else {
			System.out.println("dashboard not open test FAIL");
		}

	}


}
