package CucumberTest.stepFiles;

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

public class backgroundtest {
	
	WebDriver driver;
	
	@Before(order=1)
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}
	
	@Before(order=0)
	public void print() {
		System.out.println("------ start scenario -------");
	}
	
	@Given("^I nevigate to login page$")
	public void i_nevigate_to_login_page() throws Throwable {
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		

	}

	@When("^I submit username and password$")
	public void i_submit_username_and_password() throws Throwable {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("hijk@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("hijk@abc");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

	}

	@Then("^I should be logged in$")
	public void i_should_be_logged_in() throws Throwable {
		String txt = driver.getTitle();
		if(txt.contains("My Account")) {
			System.out.println("logged in");
		}
		else{
			System.out.println("not logged in");
		}

	}

	@Given("^user is on my account page$")
	public void user_is_on_my_account_page() throws Throwable {
		String t1 = driver.getTitle();
		if(t1.contains(t1)) {
			System.out.println("on account page");
		}
		else {
			System.out.println("not on account page");
		}

	}

	@And("^I cursor moved on desktops$")
	public void i_cursor_moved_on_desktops() throws Throwable {
		WebElement move = driver.findElement(By.xpath("//a[text()='Desktops']"));
		Actions act = new Actions(driver);
		act.moveToElement(move).build().perform();

	}

	@And("^I clicked on mac link$")
	public void i_clicked_on_mac_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Mac (1)']")).click();

	}

	@And("^I get the first product name$")
	public void i_get_the_first_product_name() throws Throwable {
		String prd = driver.findElement(By.xpath("//a[text()='iMac']")).getText();
		System.out.println("the product name: "+prd);

	}

	@And("^I search that product name in search bar$")
	public void i_search_that_product_name_in_search_bar() throws Throwable {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iMac");

	}

	@When("^clicked on search button$")
	public void clicked_on_search_button() throws Throwable {
		driver.findElement(By.xpath("//span[@class='input-group-btn']/button")).click();

	}

	@Then("^verify searched product is same displyed on homepage$")
	public void verify_searched_product_is_same_displyed_on_homepage() throws Throwable {
		driver.navigate().back();
		String cmp1 =driver.findElement(By.xpath("//a[text()='iMac']")).getText();
		
		driver.findElement(By.xpath("//span[@class='input-group-btn']/button")).click();
		
		String cmp2 = driver.findElement(By.xpath("//a[text()='iMac']")).getText();
		
		if(cmp1.equals(cmp2)) {
			System.out.println("product match test PASS");
		}
		else {
			System.out.println("product not match test FAIL");
		}
		

	}

	@And("^I cursor moved on laptop$")
	public void i_cursor_moved_on_laptop() throws Throwable {
		WebElement mov = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
		Actions avt = new Actions(driver);
		avt.moveToElement(mov).build().perform();
		

	}

	@And("^I clicked on show all laptop$")
	public void i_clicked_on_show_all_laptop() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Show All Laptops & Notebooks']")).click();

	}

	@And("^I click on HP laptop$")
	public void i_click_on_HP_laptop() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a")).click();

	}

	@When("^I clicked on add to cart button$")
	public void i_clicked_on_add_to_cart_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();

	}

	@Then("^verify product has successfully added to cart$")
	public void verify_product_has_successfully_added_to_cart() throws Throwable {
		Thread.sleep(5000);
		
		String add = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
	if(add.contains("Success:")) {
		System.out.println("product added to cart test PASS");
	}
	else {
		System.out.println("not added test FAIL");
	}

	}

}
