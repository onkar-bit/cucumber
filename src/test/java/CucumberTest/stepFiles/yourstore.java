package CucumberTest.stepFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class yourstore {
	
	WebDriver driver;
	
	@Before
	public void lanuch() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Given("^open your store website$")
	public void open_your_store_website() throws Throwable {
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");


	}

	@And("^move cursor over desktop and click on show all$")
	public void move_cursor_over_desktop_and_click_on_show_all() throws Throwable {
		WebElement ele =driver.findElement(By.xpath("//a[text()='Desktops']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		
		driver.findElement(By.xpath("//a[text()='Show All Desktops']")).click();

	}

	@And("^click on sort feature$")
	public void click_on_sort_feature() throws Throwable {
		WebElement sel = driver.findElement(By.xpath("//select[@id='input-sort']"));
		Select s1 = new Select(sel);
		s1.selectByVisibleText("Name (Z - A)");

	}

	@And("^click on name descending order$")
	public void click_on_name_descending_order() throws Throwable {

	}

	@Then("^verify name are shown in descending order$")
	public void verify_name_are_shown_in_descending_order() throws Throwable {
		List<WebElement> product = driver.findElements(By.xpath("//div[@class='caption']/h4/a"));
		
		List<String> products= new ArrayList<String>();
		for(WebElement e1: product) {
			products.add(e1.getText());
		}
		List<String> productlist = new ArrayList<String>(products);
		Collections.sort(productlist);
		
		System.out.println("product list:"+productlist);
		System.out.println("first product after sort:"+products.get(0));
	}

}
