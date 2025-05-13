package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001AccountRegistrationTest extends BaseClass{
     
	@Test(groups={"Regression","Master"})//Step7 groups added
     public void verifyAccountRegistration() {
    	 logger.info("*********** Starting TC001_AccountRegistrationTest   *************");
    	 logger.debug("**This is debug message**");
    	 HomePage hp=new HomePage(driver);
    	 try {
    	 hp.clickAccount();
    	 logger.info("Clicked on My account.....");
    	 hp.clickRegister();
    	 logger.info("Clicked on Register option.....");
    	 
    	 AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
    	 logger.info("Providing customer details...");
    	 regPage.setFirstName(randomString().toUpperCase());
    	 regPage.setLastName(randomString().toUpperCase());
    	 regPage.setEmail(randomString()+"@gmail.com");// randomly generated the email
 		 regPage.setTelephone(randomNumber());
 		
 		 String password=randomAlphaNumeric();
 		
 		 regPage.setPassword(password);
 		 regPage.setConfirmPassword(password);
 		
 		 regPage.setPrivacyPolicy();
 		 regPage.clickContinue();
 		
 		logger.info("Validating expected message..");
 		 
 		 String confmsg=regPage.confirmationMessage();
 		 if (confmsg.equals("Your Account Has Been Created!")) {
 			 Assert.assertTrue(true);
 		 }
 		 else {
 			 logger.error("Test Failed....");
 			 logger.debug("debug log...");
 			 Assert.assertTrue(false);
 		 }
 		 logger.info("Hurray! Test passed..........");
 		// Assert.assertEquals(confmsg, "Your Account Has Been Created!");
    	 }
    	 catch(Exception e) {
    		 logger.error("Test failed: " + e.getMessage());
    		 Assert.fail();
    	 }
    	 finally {
    		 logger.info("***** Finished TC001_AccountRegistrationTest *****");
    	 }
    	 
     }
     
     
}
