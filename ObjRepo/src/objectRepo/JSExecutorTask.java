package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutorTask extends Base {

	public JSExecutorTask(String AppUrl) {
		super(AppUrl);
	}

	public static void main(String[] args) throws InterruptedException {
		
		JSExecutorTask task = new JSExecutorTask("https://classic.freecrm.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("ancd ");
		driver.findElement(By.name("password")).sendKeys("Test@125");
		
		WebElement login = driver.findElement(By.xpath("//div[@class=\"input-group-btn\"]//child::input[@value=\"Login\"]"));
		task.clickElementByJS(login);
		
		Thread.sleep(3000);
		
		task.generateAlert("Login - Successfull !!!");
		
		Thread.sleep(3000);
		
		driver.quit();
	}
	
	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor )driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void generateAlert(String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('"+message+"')");
	}
}
