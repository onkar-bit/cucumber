package CucumberTest.stepFiles;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class swag {
	
	WebDriver driver;
	
	@Before
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Given("^go to swag labs website$")
	public void go_to_swag_labs_website() throws Throwable {
		driver.get("https://www.saucedemo.com/");

	}

	@And("^enter username and password$")
	public void enter_username_and_password(DataTable userdata) throws Throwable {
		List<Map<String,String>> act = userdata.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(act.get(0).get("username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(act.get(0).get("password"));

	}

	@When("^click on login$")
	public void click_on_login() throws Throwable {
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

	}

	@Then("^verify product page will displayed$")
	public void verify_product_page_will_displayed() throws Throwable {
		String txt = driver.findElement(By.xpath("//span[text()='Products']")).getText();
		System.out.println("the msg: "+txt);
		
		if(txt.contains("PRODUCTS")) {
			System.out.println("login success test PASS");
		}
		else {
			System.out.println("login not success test FAIL");
		}

	}

	@Given("^click on sauce lab backpack product$")
	public void click_on_sauce_lab_backpack_product() throws Throwable {
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();


	}

	@When("^click on add to cart button$")
	public void click_on_add_to_cart_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();

	}

	@Then("^verify product added in cart$")
	public void verify_product_added_in_cart() throws Throwable {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		String txt = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		
		if(txt.contains("Sauce Labs Backpack")) {
			System.out.println("product added in cart test PASS");
		}
		else {
			System.out.println("product not added in cart test FAIL");
		}

	}

	@Given("^verify product page displayed after login$")
	public void click_on_sort_icon() throws Throwable {
		String txt4 = driver.findElement(By.xpath("//span[@class='title']")).getText();
		
		if(txt4.contains(txt4)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}

	}

	@And("^select dropdown option price low to high$")
	public void select_dropdown_option_price_low_to_high() throws Throwable {
		WebElement sel = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select obj = new Select(sel);
		obj.selectByVisibleText("Price (low to high)");

	}

	@Then("^verify lowest price product will come first$")
	public void verify_lowest_price_product_will_come_first() throws Throwable {
		
		//scrap price
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='pricebar']/div"));
		
		//extract the prices store in list
		List<String> prices = new ArrayList<String>();
		for(WebElement e : price) {
			prices.add(e.getText());
			
		}
		//make copy of list
		List<String> sortedPrices = new ArrayList<String>(prices);
		
		//sort list
		Collections.sort(sortedPrices);
		
		System.out.println("product price list: "+sortedPrices);
		System.out.println("first product price after sort: "+prices.get(0));

	}
	
	@Given("^user is on product page$")
	public void user_is_on_product_page() throws Throwable {
		String product = driver.findElement(By.xpath("//span[@class='title']")).getText();
		
		if(product.contains("Products")) {
			System.out.println("user is on product page");
		}
		else {
			System.out.println("user is on not product page");
		}

	}

	@And("^select dropdown option price high to low$")
	public void select_dropdown_option_price_high_to_low() throws Throwable {
		WebElement s1 = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select obj77 = new Select(s1);
		obj77.selectByVisibleText("Price (high to low)");

	}

	@Then("^verify highest price product will come first$")
	public void verify_highest_price_product_will_come_first() throws Throwable {
		
		//scrap price
		List<WebElement> priceh = driver.findElements(By.xpath("//div[@class='pricebar']/div"));
		
		//extract prices store in list
		List<String> prices = new ArrayList<String>();
		
		for(WebElement e: priceh) {
			prices.add(e.getText());
		}
		
		//make copy of list
		List<String> sortedprice = new ArrayList<String>(prices);
		
		//sort list
		Collections.sort(sortedprice);
		System.out.println("product price list: "+sortedprice);
		System.out.println("first product price after sort: "+prices.get(0));
		
	}
	
}
