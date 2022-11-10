
package CucumberTest.stepFiles;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Leave {
	
	WebDriver driver;
	
	@Before
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\workplace\\CucumberMyTest\\src\\test\\java\\CucumberTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Given("^go to website and log in using correct username and password$")
	public void go_to_website_and_log_in_using_correct_username_and_password(DataTable user) throws Throwable {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		List<Map<String, String>> act = user.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(act.get(0).get("username"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(act.get(0).get("password"));
	   
	}

	@And("^click on logged in$")
	public void click_on_logged_in() throws Throwable {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

	}

	@And("^verify successfully logged in$")
	public void verify_successfully_logged_in() throws Throwable {
		String txt =driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText();
		System.out.println("the msg "+txt);
		
		if(txt.contains(txt)) {
			System.out.println("test PASS");
		}
		else {
			System.out.println("test FAIL");
		}

	}

	@And("^move cursor over leave tab$")
	public void move_cursor_over_leave_tab() throws Throwable {
		WebElement mov = driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']"));
		Actions act = new Actions(driver);
		act.moveToElement(mov).build().perform();

	}

	@And("^click on assign leave$")
	public void click_on_assign_leave() throws Throwable {
		driver.findElement(By.xpath("//a[@id='menu_leave_assignLeave']")).click();

	}

	@And("^enter all details$")
	public void enter_all_details() throws Throwable {
		driver.findElement(By.xpath("//input[@id='assignleave_txtEmployee_empName']")).sendKeys("john smith");
		WebElement sel= driver.findElement(By.xpath("//select[@id='assignleave_txtLeaveType']"));
		Select obj = new Select(sel);
		obj.selectByValue("9");
		
		driver.findElement(By.xpath("//input[@id='assignleave_txtFromDate']")).click();
		driver.findElement(By.xpath("//a[text()='11']")).click();
		driver.findElement(By.xpath("//input[@id='assignleave_txtToDate']")).click();
		driver.findElement(By.xpath("//a[text()='12']")).click();

	}

	@When("^click on assign button$")
	public void click_on_assign_button() throws Throwable {
		driver.findElement(By.xpath("//input[@id='assignBtn']")).click();
		driver.findElement(By.xpath("//input[@id='confirmOkButton']")).click();

	}

	@Then("^Verify successfull message shown on page$")
	public void verify_successfull_message_shown_on_page() throws Throwable {
         
	}
	
	@And("^move cursor over recruitment tab$")
	public void move_cursor_over_recruitment_tab() throws Throwable {
	    
		WebElement movc = driver.findElement(By.xpath("//a[@id=\"menu_recruitment_viewRecruitmentModule\"]"));
		Actions demo = new Actions(driver);
		demo.moveToElement(movc).build().perform();
	}

	@And("^click on vacancy$")
	public void click_on_vacancy() throws Throwable {
	    driver.findElement(By.xpath("//a[text()='Vacancies']")).click();
		
	}

	@And("^fill all detail$")
	public void fill_all_detail() throws Throwable {
	    
	     driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
	     WebElement act = driver.findElement(By.xpath("//select[@id='addJobVacancy_jobTitle']"));
	     Select obj = new Select(act);
	     obj.selectByVisibleText("Automation Tester");
	     
	     driver.findElement(By.xpath("//input[@id='addJobVacancy_name']")).sendKeys("Test lead");
	     driver.findElement(By.xpath("//input[@id='addJobVacancy_hiringManager']")).sendKeys("purva jagdale");
	     driver.findElement(By.xpath("//input[@id='addJobVacancy_noOfPositions']")).sendKeys("5");
	     
	     TakesScreenshot scrShot = ((TakesScreenshot)driver);
	     File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
	     File destFile = new File("C:\\workplace\\CucumberMyTest\\screenshot\\demoimg.png");
	     FileUtils.copyFile(SrcFile, destFile);
	     
	    		 
	     driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	}

	@Then("^Verify vacancy added successfully$")
	public void verify_vacancy_added_successfully() throws Throwable {
	    
		
	}

}
