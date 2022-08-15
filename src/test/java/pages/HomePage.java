package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage  {
	 BasePage basePage;
	public HomePage(WebDriver driver) {
		  basePage=new BasePage(driver);
	}

 // BasePage basePage=new BasePage(driver);

/************************Locators*********************************/
	
	By category=By.xpath(" (//div[@class='product-item-content text-left'])[9]");
	By itemText=By.xpath("(//h3[@class='medium-font'])[2]");
	By addToCart=By.xpath("(//button[@class='btn w-100 add-to-cart text-center ng-star-inserted'])[2]");
    By continueBtn=By.xpath("//button[text()=' Continue ']");
	
    /************************Actions*********************************/
	
	public void selectCategory() {
		
		basePage.click(category);
	}

	

public String getAttributeItemText() {
	

return basePage.getElementAttribute(itemText);
}


public void addToCart() throws InterruptedException {
	Thread.sleep(20000);
	basePage.clickByJavaScript(addToCart);
}

public void continueClick() {
	basePage.click(continueBtn);
}

}
