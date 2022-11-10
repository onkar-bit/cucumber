package CucumberTest.stepFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class searchverify {
	
	WebDriver driver;
	
	@Before
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Given("^user is on tutorial ninja demo website$")
	public void user_is_on_tutorial_ninja_demo_website() throws Throwable {
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
		
	}

	@And("^click on my account in homepage$")
	public void click_on_my_account_in_homepage() throws Throwable {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();

	}

	@And("^click on login in homepage$")
	public void click_on_login_in_homepage() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Login']")).click();

	}

	@And("^enter the correct \"([^\"]*)\" and \"([^\"]*)\" click on sign in$")
	public void enter_the_correct_and_click_on_sign_in(String username, String password) throws Throwable {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();

	}

	@And("^move curser over desktop click on show all$")
	public void move_curser_over_desktop_click_on_show_all() throws Throwable {
		WebElement mov = driver.findElement(By.xpath("//a[text()='Desktops']"));
		Actions act = new Actions(driver);
		act.moveToElement(mov).build().perform();
		driver.findElement(By.xpath("//a[text()='Show All Desktops']")).click();

	}

	@And("^get camera name from homepage$")
	public void get_camera_name_from_homepage() throws Throwable {
		String msg= driver.findElement(By.xpath("//a[text()='Canon EOS 5D']")).getText();
		System.out.println("the msg: "+msg);
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(msg);

	}

	@And("^search that camera name in search field$")
	public void search_that_camera_name_in_search_field() throws Throwable {
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

	}

	@When("^click on search button in demo web$")
	public void click_on_search_button_in_demo_web() throws Throwable {
		driver.navigate().back();

	}

	@Then("^Verify both product matches\\.$")
	public void verify_both_product_matches() throws Throwable {
		String name= driver.findElement(By.xpath("//a[text()='Canon EOS 5D']")).getText();
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String name2 = driver.findElement(By.xpath("//a[text()='Canon EOS 5D']")).getText();
		
		if(name.equals(name2)) {
			System.out.println("test PASS");
		}
		else {
			System.out.println("test FAIL");
		}
			

	}

}
