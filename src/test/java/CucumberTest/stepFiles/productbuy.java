package CucumberTest.stepFiles;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class productbuy {
	
	WebDriver driver;
	
	@Before
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Given("^user nevigate to login page$")
	public void user_nevigate_to_login_page() throws Throwable {
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();

	}

	@When("^user submit valid username and password$")
	public void user_submit_valid_username_and_password() throws Throwable {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("hijk@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("hijk@abc");

	}

	@Then("^user should be logged in$")
	public void user_should_be_logged_in() throws Throwable {
		driver.findElement(By.xpath("//input[@value='Login']")).click();

	}

	@Given("^user is on my account dashboard page$")
	public void user_is_on_my_account_dashboard_page() throws Throwable {
		String title = driver.getTitle();
		if(title.contains("Account")) {
			System.out.println("user is on dashboard");
		}
		else {
			System.out.println("user not on my account");
		}

	}

	@And("^curser move over desktop link$")
	public void curser_move_over_desktop_link() throws Throwable {
		WebElement move = driver.findElement(By.xpath("//a[text()='Desktops']"));
		Actions act = new Actions(driver);
		act.moveToElement(move).build().perform();

	}

	@And("^click on show all desktop$")
	public void click_on_show_all_desktop() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Show All Desktops']")).click();

	}

	@And("^click on canon camera$")
	public void click_on_canon_camera() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Canon EOS 5D']")).click();
	
	}

	@When("^click on add to wishlist button$")
	public void click_on_add_to_wishlist_button() throws Throwable {
		driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();

	}

	@Then("^verify product successfully added to wishlist$")
	public void verify_product_successfully_added_to_wishlist() throws Throwable {
		String txt = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		if(txt.contains("Success:")) {
			System.out.println("success added");
		}
		else {
			System.out.println("not added");
		}
		
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("C:\\workplace\\CucumberMyTest\\screenshot\\cart.png");
		FileUtils.copyFile(SrcFile, DestFile);
		

	}

	@And("^click on hp laptop and add to cart$")
	public void click_on_hp_laptop_and_add_to_cart() throws Throwable {
		WebElement mouse = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
		Actions add = new Actions(driver);

		add.moveToElement(mouse).build().perform();
		
		driver.findElement(By.xpath("//a[text()='Show All Laptops & Notebooks']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a")).click();
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();

	}

	@And("^click on cart item and click on checkout$")
	public void click_on_cart_item_and_click_on_checkout() throws Throwable {
		driver.findElement(By.xpath("//span[@id='cart-total']")).click();
		driver.findElement(By.xpath("//p[@class='text-right']/a[2]")).click();

	}

	@And("^fill billing details click on continue$")
	public void fill_billing_details_click_on_continue() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"collapse-payment-address\"]/div/form/div[3]/label/input")).click();
		driver.findElement(By.xpath("//input[@id='input-payment-firstname']")).sendKeys("akshay");
		driver.findElement(By.xpath("//input[@id='input-payment-lastname']")).sendKeys("kadam");
		driver.findElement(By.xpath("//input[@id='input-payment-address-1']")).sendKeys("pune");
		driver.findElement(By.xpath("//input[@id='input-payment-city']")).sendKeys("pune");
		
		WebElement sel = driver.findElement(By.xpath("//select[@id='input-payment-country']"));
		Select obj = new Select(sel);
		obj.selectByVisibleText("India");
		
		WebElement sel2 = driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
		Select obj2 = new Select(sel2);
		obj2.selectByVisibleText("Maharashtra");
		
		
		driver.findElement(By.xpath("//input[@id='button-payment-address']")).click();

	}

	@And("^in delivery details tab click on continue$")
	public void in_delivery_details_tab_click_on_continue() throws Throwable {
		driver.findElement(By.xpath("//input[@id='button-shipping-address']")).click();

	}

	@And("^in delivery method click on continue$")
	public void in_delivery_method_click_on_continue() throws Throwable {
		driver.findElement(By.xpath("//input[@id='button-shipping-method']")).click();

	}

	@And("^in payment method click agree checkbox and click continue$")
	public void in_payment_method_click_agree_checkbox_and_click_continue() throws Throwable {
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@id='button-payment-method']")).click();

	}

	@When("^user click on confirm order button$")
	public void user_click_on_confirm_order_button() throws Throwable {
		driver.findElement(By.xpath("//input[@id='button-confirm']")).click();

	}

	@Then("^verify order is placed$")
	public void verify_order_is_placed() throws Throwable {
		Thread.sleep(3000);
		String order = driver.getTitle();
		System.out.println("the title: "+order);
		
		if(order.contains("Your order has been placed!")) {
			System.out.println("order placed test PASS");
		}
		else {
			System.out.println("order not placed test FAIL");
		}
		
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("C:\\workplace\\CucumberMyTest\\screenshot\\order.png");
		FileUtils.copyFile(SrcFile, DestFile);

	}

}
