package CucumberTest.stepFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PracticeContactus {
	
	WebDriver driver;
	
	public String read(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream fs = new FileInputStream("C:\\workplace\\CucumberMyTest\\data.properties");
		properties.load(fs);
		String msg = properties.getProperty(key);
		return msg;
	}
	
	@Before
	public void go() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@Given("^go to webdriveruniversity website$")
	public void go_to_webdriveruniversity_website() throws Throwable {
		driver.get(read("url"));

	}

	@And("^click on contact us link$")
	public void click_on_contact_us_link() throws Throwable {
		driver.findElement(By.xpath("//h1[text()='CONTACT US']")).click();

	}

	@And("^enter first name$")
	public void enter_first_name() throws Throwable {
		
		String parent = driver.getWindowHandle();
		
		ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(all.get(1));
		
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(read("fname"));

	}

	@And("^enter last name$")
	public void enter_last_name() throws Throwable {
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(read("lname"));

	}

	@And("^enter email address$")
	public void enter_email_address() throws Throwable {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(read("email"));

	}

	@And("^enter comments$")
	public void enter_comments() throws Throwable {
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(read("comments"));

	}

	@When("^click on submit button$")
	public void click_on_submit_button() throws Throwable {
		driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();

	}

	@Then("^verify thank you message is display$")
	public void verify_thank_you_message_is_display() throws Throwable {
		String text = driver.findElement(By.xpath("//div[@id='contact_reply']/h1")).getText();
		
		Reporter.log(text, true);
		
		if(text.contains("Thank")) {
			System.out.println("test PASS");
		}
		else {
			System.out.println("test FAIL");
		}

	}

}
