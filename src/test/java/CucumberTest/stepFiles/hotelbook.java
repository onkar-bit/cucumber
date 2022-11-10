package CucumberTest.stepFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class hotelbook {
	
	WebDriver driver;
	
	@Before
	public void go() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Given("^go to hotel booking website$")
	public void go_to_hotel_booking_website() throws Throwable {
		driver.navigate().to("https://www.phptravels.net/login");
		

	}

	@When("^Enter valid username and password click on login$")
	public void enter_valid_username_and_password() throws Throwable {
		driver.findElement(By.xpath("//button[@id='cookie_stop']")).click();
		driver.findElement(By.xpath("//div[@class='form-group']//input")).sendKeys("user@phptravels.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demouser");
		driver.findElement(By.xpath("//div[@class='btn-box pt-3 pb-4']/button")).click();


	}

	@Then("^user will successfully logged in$")
	public void user_will_successfully_logged_in() throws Throwable {
		String msg = driver.getTitle();
		System.out.println("the msg: "+msg);
		
		if(msg.contains("Dashboard")) {
			System.out.println("logged in success");
		}
		else{
			System.out.println("not logged in");
		}

	}

	@Given("^user is on hotel website$")
	public void user_is_on_hotel_website() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Hotels']")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");

	}

	@And("^click on hyatt regency perth image$")
	public void click_on_hyatt_regency_perth_image() throws Throwable {
		WebElement link = driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div/div/div/div[1]/div/div[7]/div/div[1]/a/img"));
		link.click();
		

	}

	@And("^click on book now button$")
	public void click_on_book_now_button() throws Throwable {
		WebElement butt= driver.findElement(By.xpath("//*[@id=\"availability\"]/div[2]/div[1]/div[2]/div/div[2]/form/div/div[4]/div/div/button"));
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("arguments[0].click()", butt);

	}

	@And("^Enter personal information form$")
	public void enter_personal_information_form() throws Throwable {
		driver.findElement(By.xpath("//input[@name='firstname_1']")).sendKeys("ajay");
		driver.findElement(By.xpath("//input[@name='lastname_1']")).sendKeys("adani");
		
		driver.findElement(By.xpath("//input[@name='firstname_2']")).sendKeys("amit");
		driver.findElement(By.xpath("//input[@name='lastname_2']")).sendKeys("jagtap");
		
		WebElement age= driver.findElement(By.xpath("//select[@name='child_age_1']"));
		Select obj = new Select(age);
		obj.selectByValue("4");
		driver.findElement(By.xpath("//input[@name='child_firstname_1']")).sendKeys("ravi");
		driver.findElement(By.xpath("//input[@name='child_lastname_2']")).sendKeys("royes");
		
		WebElement age2 = driver.findElement(By.xpath("//select[@name='child_age_2']"));
		Select obj2 = new Select(age2);
		obj2.selectByValue("5");
		driver.findElement(By.xpath("//input[@name='child_firstname_2']")).sendKeys("raj");
		driver.findElement(By.xpath("//input[@name='child_lastname_2']")).sendKeys("roy");
		
		WebElement pay= driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[3]/div[2]/div/ul/label/label/label/label/div/div/div[1]/input"));
		JavascriptExecutor js4 = (JavascriptExecutor)driver;
		js4.executeScript("arguments[0].click()", pay);
		

	}

	@And("^click on agree checkbox$")
	public void click_on_agree_checkbox() throws Throwable {
		WebElement click= driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[4]/div/div/div/label"));
		JavascriptExecutor js5=(JavascriptExecutor)driver;
		js5.executeScript("arguments[0].click()", click);
	
	}

	@When("^click on confirm booking button$")
	public void click_on_confirm_booking_button() throws Throwable {
		WebElement book= driver.findElement(By.xpath("//button[@id='booking']"));
		JavascriptExecutor js6 = (JavascriptExecutor)driver;
		js6.executeScript("arguments[0].click()", book);

	}

	@Then("^Verify hotel is booked successfully and get reserve number$")
	public void verify_hotel_is_booked_successfully_and_get_reserve_number() throws Throwable {
		String status = driver.findElement(By.xpath("//div[@class='mx-2']")).getText();
		System.out.println("the msg: "+status);
		
		String no = driver.findElement(By.xpath("//h3[@class='title']/span")).getText();
		System.out.println("the reservation no: "+no);
		
		if(status.contains("Thanks")) {
			System.out.println("hotel booked test PASS");
		}
		else {
			System.out.println("hotel not booked test FAIL");
		}

	}
	
	@Given("^user is on tour booking site$")
	public void user_is_on_tour_booking_site() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Tours']")).click();
		

	}

	@And("^click on tour of dubai link$")
	public void click_on_tour_of_dubai_link() throws Throwable {
		WebElement lk= driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[2]/a/div/div[1]/img"));
		JavascriptExecutor js13 = (JavascriptExecutor)driver;
		js13.executeScript("arguments[0].click()", lk);

	}

	@And("^click on book now$")
	public void click_on_book_now() throws Throwable {
		WebElement sel = driver.findElement(By.xpath("//select[@id='adults']"));
		Select obj = new Select(sel);
		obj.selectByVisibleText("2");
		
		WebElement book= driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor js22= (JavascriptExecutor)driver;
		js22.executeScript("arguments[0].click()", book);

	}

	@And("^enter personal info form$")
	public void enter_personal_info_form() throws Throwable {
		driver.findElement(By.xpath("//input[@name='firstname_1']")).sendKeys("ajay");
		driver.findElement(By.xpath("//input[@name='lastname_1']")).sendKeys("demo");
		
		driver.findElement(By.xpath("//input[@name='firstname_2']")).sendKeys("akash");
		driver.findElement(By.xpath("//input[@name='lastname_2']")).sendKeys("demo");
		WebElement clk= driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[3]/div[2]/div/ul/label/label/label/label/div/div/div[1]/input"));

		JavascriptExecutor js9 = (JavascriptExecutor)driver;
		js9.executeScript("arguments[0].click()", clk);
		

	}
	
	@And("^click on agree checkbox on page$")
	public void click_on_agree_checkbox_on_page() throws Throwable{
		WebElement agree= driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[4]/div/div/div/label"));
		JavascriptExecutor js12= (JavascriptExecutor)driver;
		js12.executeScript("arguments[0].click()", agree);
		
	}
	
	@When("^click on confirm booking button on page$")
	public void click_on_confirm_booking_button_on_page() throws Throwable{
		
		WebElement but = driver.findElement(By.xpath("//button[@id='booking']"));
		JavascriptExecutor js33 = (JavascriptExecutor)driver;
		js33.executeScript("arguments[0].click()", but);
		
	}

	@Then("^verify tour is booked successfully$")
	public void verify_tour_is_booked_successfully() throws Throwable {

	}
	
	@Given("^user is on flight booking website$")
	public void user_is_on_flight_booking_website() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/header/div[2]/div/div/div/div/div[2]/nav/ul/li[3]/a")).click();
	}


	@And("^click on mumbai to dubai air india link$")
	public void click_on_mumbai_to_dubai_air_india_link() throws Throwable {
		WebElement clk= driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div/div/div[1]/div/div/div[7]/a/div/div/div[2]/h6"));
		JavascriptExecutor js50 = (JavascriptExecutor)driver;
		js50.executeScript("arguments[0].click()", clk);
	}

	@And("^click on book now button given in page$")
	public void click_on_book_now_button_given_in_page() throws Throwable {
		WebElement clk1=  driver.findElement(By.xpath("/html/body/main/div/div[2]/section/ul/li[1]/div/form/div/div[2]/div/button/span"));
		JavascriptExecutor js51 = (JavascriptExecutor) driver;
		js51.executeScript("arguments[0].click()", clk1);
	
	}

	@And("^enter traveller information$")
	public void enter_traveller_information() throws Throwable {
		driver.findElement(By.xpath("//input[@name='firstname_1']")).sendKeys("akash");
		driver.findElement(By.xpath("//input[@name='lastname_1']")).sendKeys("kadam");
		
		WebElement sel= driver.findElement(By.xpath("//select[@class='form-select form-select nationality']"));
		Select obj = new Select(sel);
		obj.selectByVisibleText("India");
		
		WebElement month= driver.findElement(By.xpath("//select[@name='dob_month_1']"));
		Select obj1 = new Select(sel);
		obj1.selectByValue("03");
		
		WebElement day = driver.findElement(By.xpath("//select[@name='dob_day_1']"));
		Select obj2 = new Select(sel);
		obj2.selectByVisibleText("30");
		
		WebElement year = driver.findElement(By.xpath("//select[@name='dob_year_1']"));
		Select obj3 = new Select(sel);
		obj3.selectByVisibleText("1996");
		
		WebElement pay2 = driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[3]/div[2]/div/ul/label/label/label/label/div/div/div[1]/input"));
		JavascriptExecutor js55 = (JavascriptExecutor) driver;
		js55.executeScript("arguments[0].click()", pay2);

	}

	@And("^click on agree checkbox box on page$")
	public void click_on_agree_checkbox_box_on_page() throws Throwable {
		WebElement agre = driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[4]/div/div/div/label"));
		JavascriptExecutor js34 = (JavascriptExecutor) driver;
		js34.executeScript("arguments[0].click()", agre);

	}

	@When("^click on confirm booking button given$")
	public void click_on_confirm_booking_button_given() throws Throwable {
		WebElement cnfbook = driver.findElement(By.xpath("//button[text()='Confirm Booking']"));
		JavascriptExecutor js87 =(JavascriptExecutor) driver;
		js87.executeScript("arguments[0].click()", cnfbook);

		
	}

	@Then("^verify flight booked succesfully$")
	public void verify_flight_booked_succesfully() throws Throwable {

		
	}



}
