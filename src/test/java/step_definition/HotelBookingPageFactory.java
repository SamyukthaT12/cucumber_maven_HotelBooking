package step_definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.assertEquals;

public class HotelBookingPageFactory {
	 public WebDriver driver;
	
	@FindBy(id="txtFirstName") WebElement fname;
	@FindBy(id="txtLastName") WebElement lname;
	@FindBy(id="txtEmail") WebElement email;
	@FindBy(id="txtPhone") WebElement mobile;
	@FindBy(name="city") WebElement city;
	@FindBy(name="state") WebElement state;
	@FindBy(name="persons") WebElement guests;
	@FindBy(id="rooms") WebElement rooms;
	@FindBy(id="txtCardholderName") WebElement cardholdername;
	@FindBy(id="txtDebit") WebElement debit;
	@FindBy(id="txtCvv") WebElement cvv;
	@FindBy(id="txtMonth") WebElement month;
	@FindBy(id="txtYear") WebElement year;
	@FindBy(id="btnPayment") WebElement button;
	
	

	public HotelBookingPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void setPffname(String strfname) {
		fname.sendKeys(strfname);
	}

	public void setPflname(String strlname) {
		lname.sendKeys(strlname);		
	}

	public void setPfemail(String stremail) {
		email.sendKeys(stremail);
	}

	public void setPfmobile(String strmobile) {
		mobile.sendKeys(strmobile);
	}
	
	public void setPfcity(String strcity) {
		Select ct = new Select(city);
		ct.selectByVisibleText(strcity);
		
	}
	
	public void setPfstate(String strstate) {
		Select st = new Select(state);
		st.selectByVisibleText(strstate);
		
	}
	
	public void setPfpersons(int i) {
		Select gust = new Select(guests);
		gust.selectByIndex(i);
		
	}
	
	public void setPfrooms(String strrooms) {
		String count = rooms. getText().trim();
		//System.out.println(strrooms);
		//assertEquals("6",count);
		System.out.println(count);
		
	}
	
	public void setPfcardholder(String strcard) {
		cardholdername.sendKeys(strcard);
	}
	
	public void setPfdebit(String strdebit) {
		debit.sendKeys(strdebit);
	}
	
	public void setPfcvv(String strcvv) {
		cvv.sendKeys(strcvv);
	}
	
	public void setPfmonth(String strmonth) {
		month.sendKeys(strmonth);
	}
	
	public void setPfyear(String stryear) {
		year.sendKeys(stryear);
	}
	
	public void setPfbutton() {
		button.click();
		
	}

}
