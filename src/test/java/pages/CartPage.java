package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class CartPage  {
	 BasePage basePage;
	public CartPage(WebDriver driver) {
		basePage=new BasePage(driver);
	}
  
  
  /************************Locators*********************************/


	By itemCartText=By.xpath("(//h5[@class='mb-0 prod-name font-weight-bold h6'])[1]");		
	
	 /************************Actions*********************************/
	
public String getItemText() {
		
	
	return basePage.getElementText(itemCartText);
	}





}
