package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{
	public ShoppingCartPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='cart']")
	WebElement btnItems;
	
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement lnkViewCart;
	
	//@FindBy(xpath="//tbody/tr/td[5]")
	@FindBy(xpath="//*[@id='content']/div[2]/div/table//strong[text()='Total:']//following::td")
	//*[@id='content']/div[2]/div/table//strong[text()='Total:']//following::td
	WebElement lblTotalPrice;
	
	@FindBy(xpath="//div//a[text()='Checkout']")
	WebElement btnCheckout;
	
	public void clickItemsToNavigate() {
		btnItems.click();
	}
	
	public void clickViewCart() {
		lnkViewCart.click();
	}
	
	public String getTotalPrice() {
		return lblTotalPrice.getText();
	}
	
    public void clickOnCheckout() {
        btnCheckout.click();
    }

}
