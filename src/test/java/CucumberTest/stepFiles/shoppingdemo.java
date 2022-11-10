
package CucumberTest.stepFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class shoppingdemo {
	
	WebDriver driver;
	
	@Before
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Given("^go to toolsqa demo shopping website$")
	public void go_to_toolsqa_demo_shopping_website() throws Throwable {
		driver.get("https://shop.demoqa.com/");

	}

	@And("^click on pink drop tshirt$")
	public void click_on_pink_drop_tshirt() throws Throwable {
		driver.findElement(By.xpath("//a[text()='pink drop shoulder oversized t shirt']")).click();

	}

	@And("^select color$")
	public void select_color() throws Throwable {
		WebElement sel = driver.findElement(By.xpath("//select[@id='pa_color']"));
		Select obj = new Select(sel);
		obj.selectByVisibleText("Pink");
		
	}

	@And("^select size$")
	public void select_size() throws Throwable {
		WebElement sel2 = driver.findElement(By.xpath("//select[@id='pa_size']"));
		Select obj2 = new Select(sel2);
		obj2.selectByVisibleText("36");

	}

	@And("^click add to cart button$")
	public void click_add_to_cart_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();

	}

	@And("^click on cart icon and click on proceed to checkout button$")
	public void click_on_cart_icon_and_click_on_proceed_to_checkout_button() throws Throwable {
		driver.findElement(By.xpath("//span[@class='cart-name-and-total']")).click();
		driver.findElement(By.xpath("//a[normalize-space(text())='Proceed to checkout']")).click();

	}

	@And("^Enter billing details fname \"([^\"]*)\"$")
	public void enter_billing_details_fname(String firstname) throws Throwable {
		driver.findElement(By.xpath("//input[@id='billing_first_name']")).sendKeys(firstname);

	}

	@And("^enter lname \"([^\"]*)\"$")
	public void enter_lname(String lastname) throws Throwable {
		driver.findElement(By.xpath("//input[@id='billing_last_name']")).sendKeys(lastname);


	}

	@And("^enter address \"([^\"]*)\"$")
	public void enter_address(String add) throws Throwable {
		driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys(add);

	}

	@And("^enter city \"([^\"]*)\" and select state$")
	public void enter_city_and_select_state(String city) throws Throwable {
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys(city);
		
		WebElement state = driver.findElement(By.xpath("//select[@id='billing_state']"));
		Select obj4 = new Select(state);
		obj4.selectByVisibleText("Maharashtra");
		

	}

	@And("^enter pin \"([^\"]*)\" and mob \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void enter_pin_and_mob_and_email(String pin, String phone, String email) throws Throwable {
		driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys(pin);
		driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys(email);

	}

	@When("^click on agree checkbox and place order button$")
	public void click_on_agree_checkbox_and_place_order_button() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='terms']"))); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement ele = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='place_order']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
	}


	@Then("^verify order has been successfully placed$")
	public void verify_order_has_been_successfully_placed() throws Throwable {
		String msg = driver.findElement(By.xpath("//p[@class='woocommerce-thankyou-order-received']")).getText();
		
		if(msg.contains("Thank")) {
			System.out.println("order place test PASS");
		}
		else {
			System.out.println("order not placed test FAIL");
		}

	}

}
