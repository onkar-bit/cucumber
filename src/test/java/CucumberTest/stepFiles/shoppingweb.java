package CucumberTest.stepFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class shoppingweb {
	
	WebDriver driver;
	
	@Before
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Given("^go to shoppping website$")
	public void go_to_shoppping_website() throws Throwable {
		driver.get("http://automationpractice.com/index.php");

	}

	@And("^click on sign in link$")
	public void click_on_sign_in_link() throws Throwable {
		driver.findElement(By.xpath("//a[normalize-space(text())='Sign in']")).click();

	}

	@And("^nevigate to login page enter valid email$")
	public void nevigate_to_login_page_enter_valid_email() throws Throwable {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mnopq@gmail.com");

	}

	@And("^Enter valid password$")
	public void enter_valid_password() throws Throwable {
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("abc123");

	}

	@When("^click on sign in$")
	public void click_on_sign_in() throws Throwable {
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();

	}

	@Then("^Verify user successful logged in display my account page$")
	public void verify_user_successful_logged_in_display_my_account_page() throws Throwable {
		String actual =driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
		String expected = "MY ACCOUNT";
		Assert.assertEquals(actual, expected);
		
		Reporter.log(actual, true);

	}
	
	@Given("^go to shopping website$")
	public void go_to_shopping_website() throws Throwable {
		driver.get("http://automationpractice.com/index.php");

	}

	@And("^move your cursor over women link$")
	public void move_your_cursor_over_women_link() throws Throwable {
		WebElement sel = driver.findElement(By.xpath("//a[text()='Women']"));
		Actions act = new Actions(driver);
		act.moveToElement(sel).build().perform();

	}

	@And("^click on T-shirt link$")
	public void click_on_T_shirt_link() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();

	}

	@And("^get name of first product displayed on page$")
	public void get_name_of_first_product_displayed_on_page() throws Throwable {
		String name= driver.findElement(By.xpath("//div[@class='right-block']/h5/a")).getText();
		System.out.println("the product is: "+name);

	}

	@And("^enter same product name in searchbar$")
	public void enter_same_product_name_in_searchbar() throws Throwable {
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("Faded Short Sleeve T-shirts");

	}

	@When("^click on search$")
	public void click_on_search() throws Throwable {
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();

	}

	@Then("^verify same product name displayed on searched page which dispalyed in Tshirt$")
	public void verify_same_product_name_displayed_on_searched_page_which_dispalyed_in_Tshirt() throws Throwable {

		String searchname = driver.findElement(By.xpath("//div[@class='right-block']/h5/a")).getText();
		driver.navigate().back();
		String name= driver.findElement(By.xpath("//div[@class='right-block']/h5/a")).getText();
		
		if(name.equalsIgnoreCase(searchname)) {
			System.out.println("product match test PASS");
		}
		else {
			System.out.println("product not match test FAIL");
		}


	}

}
