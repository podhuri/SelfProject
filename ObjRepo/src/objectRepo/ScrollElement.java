package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ScrollElement extends Base {

	public ScrollElement(String AppUrl) {
		super(AppUrl);
	}

	public static void main(String[] args) throws InterruptedException {
			
		ScrollElement se = new ScrollElement("https://classic.freecrm.com/index.html");
		
		Thread.sleep(3000);
		WebElement lang = driver.findElement(By.xpath("//*[contains(text(),'Documents')]"));
		
		Thread.sleep(3000);
		
		
		scroll(lang);
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
	}
	
	public static void scroll(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}

}
