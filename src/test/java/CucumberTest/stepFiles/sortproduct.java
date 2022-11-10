package CucumberTest.stepFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class sortproduct {
	
	WebDriver driver;
	
	@Before
	public void go() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Given("^go to swaglab website$")
	public void go_to_swaglab_website() throws Throwable {
		driver.get("https://www.saucedemo.com/");
	}

	@And("^enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void enter_username_and_password(String username, String password) throws Throwable {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	}


	@And("^click on in button$")
	public void click_on_in_button() throws Throwable {
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}


	@And("^verify product page is available$")
	public void verify_product_page_is_available() throws Throwable {
        String msg= driver.findElement(By.xpath("//span[text()='Products']")).getText();
		
		if(msg.contains("PRODUCTS")) {
			System.out.println("product page test PASS");
		}
		else {
			System.out.println("not on product page test FAIL");
		}
	}
	
	@And("^select dropdown option name descending$")
	public void select_dropdown_option_name_descending(){
		WebElement s2= driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select obj = new Select(s2);
		obj.selectByVisibleText("Name (Z to A)");
		
	}


	@Then("^verify product name will sort in descending manner$")
	public void verify_product_name_will_sort_in_descending_manner() throws Throwable {
        List<WebElement> product = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		
		List<String> products = new ArrayList<String>();
		for(WebElement e1 : product) {
			products.add(e1.getText());
		}
		
		List<String> sortedproduct= new ArrayList<String>(products);
		
		Collections.sort(sortedproduct);
		
		System.out.println("sorted product list: "+sortedproduct);
		System.out.println("first product after sort: "+products.get(0));
		
		
	}

}


