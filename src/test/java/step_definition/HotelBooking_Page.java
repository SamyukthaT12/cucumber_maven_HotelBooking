package step_definition;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertEquals;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HotelBooking_Page {
private	WebDriver driver;
	private HotelBookingPageFactory objectpg;


	@Before
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium_jarfiles\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objectpg = new HotelBookingPageFactory(driver);
		objectpg = PageFactory.initElements(driver, HotelBookingPageFactory.class);
		
		
	}
	

	@Given("User is on hotel booking page")
	public void user_is_on_hotel_booking_page() {
	    driver.get("file:///C:/Users/SAMYUKTHA/Desktop/hotelbooking.html");
	}

	@Then("check the title of the page")
	public void check_the_title_of_the_page() {
	    String title = driver.getTitle();
	    if(title.contentEquals("Hotel Booking"))  System.out.println(" -------- Title Matched ");
	    else System.out.println(" --------- Title Not Matched ");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.close();
	}

	@When("user enters all valid data")
	public void user_enters_all_valid_data() throws Throwable {
	    objectpg.setPffname("Samyuktha");
	    Thread.sleep(1000);
	    objectpg.setPflname("Telamsetti");
	    Thread.sleep(1000);
	    objectpg.setPfemail("samyudevi7@gmail.com");
	    Thread.sleep(1000);
	    objectpg.setPfmobile("7287082363");
	    Thread.sleep(1000);
	    objectpg.setPfcity("Hyderabad");
	    Thread.sleep(1000);
	    objectpg.setPfstate("Telangana");
	    Thread.sleep(1000);
	    objectpg.setPfpersons(5);
	    Thread.sleep(2000);
	    objectpg.setPfcardholder("Devi Samyuktha");
	    Thread.sleep(1000);
	    objectpg.setPfdebit("1234432198765432");
	    Thread.sleep(1000);
	    objectpg.setPfcvv("351");
	    Thread.sleep(1000);
	    objectpg.setPfmonth("4");
	    Thread.sleep(1000);
	    objectpg.setPfyear("2021");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    objectpg.setPfbutton();

	}

	@Then("navigate to welcome page")
	public void navigate_to_welcome_page() {
	    driver.navigate().to("file:///C:/Users/SAMYUKTHA/Desktop/hotelbooking.html");
	    String name = driver.getTitle();
	    System.out.println(name);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.close();
	   
	}

	@When("user leaves first Name blank")
	public void user_leaves_first_Name_blank() throws Throwable {
	    objectpg.setPffname("");
	    Thread.sleep(1000);
	}

	@When("clicks the button")
	public void clicks_the_button() {
	   objectpg.setPfbutton();
	   
	}

	@Then("display alert msg")
	public void display_alert_msg() throws Throwable {
	    String alertMessage = driver.switchTo().alert().getText();
	    Thread.sleep(1000);
	    driver.switchTo().alert().accept();
	    System.out.println(" --------- " + alertMessage);
	    driver.close();
	}

	@When("user leaves last Name blank and clicks the button")
	public void user_leaves_last_Name_blank_and_clicks_the_button() throws Throwable {
		objectpg.setPffname("Samyuktha");
		Thread.sleep(1000);
		objectpg.setPflname("");
		Thread.sleep(1000);
		objectpg.setPfbutton();
		
	}

	@When("user enters all data")
	public void user_enters_all_data() throws Throwable {
		objectpg.setPffname("Samyuktha");
	    Thread.sleep(1000);
	    objectpg.setPflname("Telamsetti");
	    Thread.sleep(1000);
	    objectpg.setPfmobile("7287082363");
	    Thread.sleep(1000);
	    objectpg.setPfcity("Hyderabad");
	    Thread.sleep(1000);
	    objectpg.setPfstate("Telangana");
	    Thread.sleep(1000);
	    objectpg.setPfpersons(5);
	    Thread.sleep(2000);
	    objectpg.setPfcardholder("Devi Samyuktha");
	    Thread.sleep(1000);
	    objectpg.setPfdebit("1234432198765432");
	    Thread.sleep(1000);
	    objectpg.setPfcvv("351");
	    Thread.sleep(1000);
	    objectpg.setPfmonth("4");
	    Thread.sleep(1000);
	    objectpg.setPfyear("2021");
	}

	@When("user enters incorrect email format and clicks the button")
	public void user_enters_incorrect_email_format_and_clicks_the_button() throws Throwable {
	    objectpg.setPfemail("samyu@.com");
	    Thread.sleep(1000);
	    objectpg.setPfbutton();
	    
	}

	@When("user leaves MobileNo blank and clicks the button")
	public void user_leaves_MobileNo_blank_and_clicks_the_button() throws Throwable {
	    objectpg.setPffname("Samyutha");
	    Thread.sleep(1000);
	    objectpg.setPflname("Telamsetti");
	    Thread.sleep(1000);
	    objectpg.setPfemail("samyudevi7@gmail.com");
	    Thread.sleep(1000);
	    objectpg.setPfmobile("");
	    Thread.sleep(1000);
	    objectpg.setPfbutton();
	}

	@When("user enters incorrect mobileNo format and clicks the button")
	public void user_enters_incorrect_mobileNo_format_and_clicks_the_button(io.cucumber.datatable.DataTable table1) throws Throwable {
		objectpg.setPffname("Samyutha");
	    Thread.sleep(1000);
	    objectpg.setPflname("Telamsetti");
	    Thread.sleep(1000);
	    objectpg.setPfemail("samyudevi7@gmail.com");
	    Thread.sleep(1000);
	    
	    List<String> oblist = table1.asList(String.class);
	    objectpg.setPfbutton();
	    
	    for(int i=1; i<oblist.size();i++)
	    {
	    	if(Pattern.matches("^[789][0-9]{9}$", oblist.get(i)))
	    	{
	    		System.out.println("--------- Matched " +oblist.get(i) + "----------");
	    	}
	    	else
	    	{
	    		System.out.println("---------- Not Matched " +oblist.get(i) + "-------------");
	    	}
	    }
	}

	@When("user doesnot select city")
	public void user_doesnot_select_city() throws Throwable {
		objectpg.setPffname("Samyuktha");
	    Thread.sleep(1000);
	    objectpg.setPflname("Telamsetti");
	    Thread.sleep(1000);
	    objectpg.setPfemail("samyudevi7@gmail.com");
	    Thread.sleep(1000);
	    objectpg.setPfmobile("7287082363");
	    Thread.sleep(1000);
	    objectpg.setPfcity("Select City");
	    Thread.sleep(1000);
	    objectpg.setPfbutton();
	}

	@When("user doesnot select state")
	public void user_doesnot_select_state() throws Throwable {
		objectpg.setPffname("Samyuktha");
	    Thread.sleep(1000);
	    objectpg.setPflname("Telamsetti");
	    Thread.sleep(1000);
	    objectpg.setPfemail("samyudevi7@gmail.com");
	    Thread.sleep(1000);
	    objectpg.setPfmobile("7287082363");
	    Thread.sleep(1000);
	    objectpg.setPfcity("Hyderabad");
	    Thread.sleep(1000);
	    objectpg.setPfstate("Select State");
	    Thread.sleep(1000);
	    objectpg.setPfbutton();
	}

	@When("user enters {int}")
	public void user_enters(int num) throws Throwable {
		objectpg.setPffname("Samyuktha");
	    Thread.sleep(1000);
	    objectpg.setPflname("Telamsetti");
	    Thread.sleep(1000);
	    objectpg.setPfemail("samyudevi7@gmail.com");
	    Thread.sleep(1000);
	    objectpg.setPfmobile("7287082363");
	    Thread.sleep(1000);
	    objectpg.setPfcity("Hyderabad");
	    Thread.sleep(1000);
	    objectpg.setPfstate("Telangana");
	    Thread.sleep(1000);
	    objectpg.setPfpersons(num);
	    Thread.sleep(1000);
	    

	}

	@Then("allocate rooms such that {int} room for minimum {int} guests")
	public void allocate_rooms_such_that_room_for_minimum_guests(int num, int rom_count) {
	    if(rom_count <= 3)
	    {
	    	System.out.println("-------- 1 room ");
	    	assertEquals(1, num);
	    }
	    else if(rom_count  <=7)
	    {
	    	System.out.println("---------- 2 rooms");
	    	assertEquals(2, num);
	    }
	    else if(rom_count <=9)
	    {
	    	System.out.println("------------ 3 rooms");
	    	assertEquals(3, num);
	    }
	}

	@When("user leaves CardHolderName blank and clicks the button")
	public void user_leaves_CardHolderName_blank_and_clicks_the_button() throws Throwable {
		 objectpg.setPffname("Samyuktha");
		    Thread.sleep(1000);
		    objectpg.setPflname("Telamsetti");
		    Thread.sleep(1000);
		    objectpg.setPfemail("samyudevi7@gmail.com");
		    Thread.sleep(1000);
		    objectpg.setPfmobile("7287082363");
		    Thread.sleep(1000);
		    objectpg.setPfcity("Hyderabad");
		    Thread.sleep(1000);
		    objectpg.setPfstate("Telangana");
		    Thread.sleep(1000);
		    objectpg.setPfpersons(5);
		    Thread.sleep(2000);
		    objectpg.setPfcardholder("");
		    Thread.sleep(1000);
		    objectpg.setPfbutton();
	}

	@When("user leaves DebitCardNo blank and clicks the button")
	public void user_leaves_DebitCardNo_blank_and_clicks_the_button() throws Throwable {
		 objectpg.setPffname("Samyuktha");
		    Thread.sleep(1000);
		    objectpg.setPflname("Telamsetti");
		    Thread.sleep(1000);
		    objectpg.setPfemail("samyudevi7@gmail.com");
		    Thread.sleep(1000);
		    objectpg.setPfmobile("7287082363");
		    Thread.sleep(1000);
		    objectpg.setPfcity("Hyderabad");
		    Thread.sleep(1000);
		    objectpg.setPfstate("Telangana");
		    Thread.sleep(1000);
		    objectpg.setPfpersons(5);
		    Thread.sleep(2000);
		    objectpg.setPfcardholder("Devi Samyuktha");
		    Thread.sleep(1000);
		    objectpg.setPfdebit("");
		    Thread.sleep(1000);
		    objectpg.setPfbutton();
	}

	@When("user leaves expirationMonth blank and clicks the button")
	public void user_leaves_expirationMonth_blank_and_clicks_the_button() throws Throwable {
		objectpg.setPffname("Samyuktha");
	    Thread.sleep(1000);
	    objectpg.setPflname("Telamsetti");
	    Thread.sleep(1000);
	    objectpg.setPfemail("samyudevi7@gmail.com");
	    Thread.sleep(1000);
	    objectpg.setPfmobile("7287082363");
	    Thread.sleep(1000);
	    objectpg.setPfcity("Hyderabad");
	    Thread.sleep(1000);
	    objectpg.setPfstate("Telangana");
	    Thread.sleep(1000);
	    objectpg.setPfpersons(5);
	    Thread.sleep(2000);
	    objectpg.setPfcardholder("Devi Samyuktha");
	    Thread.sleep(1000);
	    objectpg.setPfdebit("1234432198765432");
	    Thread.sleep(1000);
	    objectpg.setPfcvv("351");
	    Thread.sleep(1000);
	    objectpg.setPfmonth("");
	    Thread.sleep(1000);
	    objectpg.setPfbutton();
	}

	@When("user leaves expirationYr blank and clicks the button")
	public void user_leaves_expirationYr_blank_and_clicks_the_button() throws Throwable {
		 objectpg.setPffname("Samyuktha");
		    Thread.sleep(1000);
		    objectpg.setPflname("Telamsetti");
		    Thread.sleep(1000);
		    objectpg.setPfemail("samyudevi7@gmail.com");
		    Thread.sleep(1000);
		    objectpg.setPfmobile("7287082363");
		    Thread.sleep(1000);
		    objectpg.setPfcity("Hyderabad");
		    Thread.sleep(1000);
		    objectpg.setPfstate("Telangana");
		    Thread.sleep(1000);
		    objectpg.setPfpersons(5);
		    Thread.sleep(2000);
		    objectpg.setPfcardholder("Devi Samyuktha");
		    Thread.sleep(1000);
		    objectpg.setPfdebit("1234432198765432");
		    Thread.sleep(1000);
		    objectpg.setPfcvv("351");
		    Thread.sleep(1000);
		    objectpg.setPfmonth("4");
		    Thread.sleep(1000);
		    objectpg.setPfyear("");
		    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    objectpg.setPfbutton();

	}


}
