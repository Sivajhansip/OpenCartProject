package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(id="input-lastname")
	WebElement txtLastname;
	
	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(id="input-telephone")
	WebElement txtTelephone;
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(id="input-confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']") 
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}
	
    public void setEmail(String email) {
    	txtEmail.sendKeys(email);
    }
    
    public void setTelephone(String Tel) {
    	txtTelephone.sendKeys(Tel);
    }
    
    public void setPassword(String pwd) {
    	txtPassword.sendKeys(pwd);
    }
    
    public void setConfirmPassword(String pwd) {
    	txtConfirmPassword.sendKeys(pwd);
    }
    
    public void setPrivacyPolicy() {
    	chkdPolicy.click();
    }
    
    public void clickContinue() {
    	//Sol1
    	btnContinue.click();
    	
    	//Sol2
		/* btnContinue.submit(); */
    	
    	//Sol3
        //Actions act=new Actions(driver);
    	//act.moveToElement(btnContinue).build().perform();
    	
    	//Sol4
    	//JavascriptExecutor js=(JavascriptExecutor)driver;
    	//js.executeScript("arguments[0].click();",btnContinue );
    	
    	//Sol5
    	//btnContinue.sendKeys(Keys.ENTER);
    	
    	//Sol1
    	//WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
    	
    }
    
    public String confirmationMessage() {
    	try{
    		return(msgConfirmation.getText());
    	}
    	catch(Exception e){
    		return(e.getMessage());
    	}
    }

}
