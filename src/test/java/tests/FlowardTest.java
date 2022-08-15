package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.HomePage;




public class FlowardTest extends TestBase {

	
    HomePage homePage;
    CartPage cartPage;
   //Intialize objects of page classes
	@BeforeMethod
	
	void init() {
		
		System.out.println("init()");
		homePage=new HomePage(driver);
		cartPage=new CartPage(driver);
		
			
	}

    //Test case for passing add to cart
	
	@Test(description ="Add to cart", priority = 1)
	
	
	public void AddToCartTest() throws InterruptedException, IOException {
		
		
		homePage.selectCategory();
		Thread.sleep(20000);
		 test.log(LogStatus.PASS,"select category");
			String expectedItemText=homePage.getAttributeItemText();
			System.out.println(expectedItemText);
			test.log(LogStatus.PASS,"get expected result");
			homePage.addToCart();
			Thread.sleep(10000);
			test.log(LogStatus.PASS,"Add to cart");
			homePage.continueClick();
			Thread.sleep(10000);
			test.log(LogStatus.PASS,"Continue button clicked");
		String actualItemText=cartPage.getItemText();
	
		Assert.assertEquals( actualItemText,expectedItemText,"item didn't add to cart");
		
	}
	
	//Test case for  failing add to cart
	
		@Test(description ="Add to cart", priority = 1)
		
		
		public void AddToCartTestFail() throws InterruptedException, IOException {
			
			
			homePage.selectCategory();
			Thread.sleep(20000);
			 test.log(LogStatus.PASS,"select category");
			String expectedItemText=homePage.getAttributeItemText();
			System.out.println(expectedItemText);
			test.log(LogStatus.PASS,"get expected result");
			homePage.addToCart();
			Thread.sleep(10000);
			test.log(LogStatus.PASS,"Add to cart");
			homePage.continueClick();
			Thread.sleep(10000);
			test.log(LogStatus.PASS,"Continue button clicked");
			String actualItemText=cartPage.getItemText();
		
			Assert.assertEquals( actualItemText,"This is wrong text","item didn't add to cart");
			
		}
	
	
	

}
