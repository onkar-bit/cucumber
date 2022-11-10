package CucumberTest.stepFiles;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class registeruser {
	
	WebDriver driver;
	
	public void takescreen(WebDriver driver, String name) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("C:\\workplace\\CucumberMyTest\\screenshot\\"+name+".png");
		FileUtils.copyFile(SrcFile, DestFile);

	}
	
	@Before
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@Given("^go to online shopping website$")
	public void go_to_shopping_website() throws Throwable {
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

	}

	@And("^Click on my account link$")
	public void click_on_my_account_link() throws Throwable {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		

	}

	@And("^click on register$")
	public void click_on_register() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Register']")).click();

	}

	@And("^Enter Fname \"([^\"]*)\"$")
	public void enter_Fname(String firstname) throws Throwable {
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(firstname);

	}

	@And("^Enter Lname \"([^\"]*)\"$")
	public void enter_Lname(String lastname) throws Throwable {
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(lastname);

	}

	@And("^Enter email \"([^\"]*)\"$")
	public void enter_email(String emailid) throws Throwable {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailid);

	}

	@And("^Enter phone no \"([^\"]*)\"$")
	public void enter_phone_no(String telephone) throws Throwable {
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(telephone);

	}

	@And("^Enter password \"([^\"]*)\"$")
	public void enter_password(String password) throws Throwable {
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);

	}

	@And("^Enter cnf password \"([^\"]*)\"$")
	public void enter_cnf_password(String passwordcnf) throws Throwable {
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(passwordcnf);

	}

	@And("^click on agree check box$")
	public void click_on_agree_check_box() throws Throwable {
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		takescreen(driver, "demo");
		takescreen(driver, "data2");

	}

	@When("^click on continue button$")
	public void click_on_continue_button() throws Throwable {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

	}

	@Then("^verify sucessfull register and account created msg has dispaly$")
	public void verify_sucessfull_register_and_account_created_msg_has_dispaly() throws Throwable {
		String msg = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		
		takescreen(driver, "cmp");
		takescreen(driver, "cmp2");
		
		if(msg.contains("Created!")) {
			System.out.println("account registered test PASS");
		}
		else {
			System.out.println("account not registered test FAIL");
		}

	}

}
