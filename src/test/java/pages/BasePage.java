package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


/************************Base class for common actions*********************************/

public class BasePage {

	
		protected WebDriver driver;
	
		public BasePage(WebDriver driver) {
			this.driver=driver;
		}
		//Click action Method
				protected void click (By element) {
			
				driver.findElement(element).click();	
			
		}
				protected void clickByJavaScript (By element) {		
				WebElement elem = driver.findElement(element);

		        //in order to click a non visible element
		        JavascriptExecutor js = (JavascriptExecutor)driver;
		        js.executeScript("arguments[0].click();", elem);
		        
				}
				
			

				
//get text
				protected String getElementText(By item) {
				return	driver.findElement(item).getText();
				}
// Get element By Attribute
				protected String getElementAttribute(By item) {
					return	driver.findElement(item).getAttribute("title");
					}
				
				
	}


