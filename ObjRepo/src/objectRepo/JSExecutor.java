package objectRepo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class JSExecutor {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\podhuri\\OneDrive - Capgemini\\Desktop\\DRIVER\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("batchautomation ");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		
		WebElement btn = driver.findElement(By.xpath("//input[@type='submit']"));
		//flash(btn,driver);
		drawBorder(btn,driver);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		new File(".\\Images\\").mkdirs();
		FileHandler.copy(src, new File(".\\Images\\defect2.png"));
		
		driver.quit();
		
	}
	
	//public static void getElement()
	
	public static void drawBorder(WebElement locator , WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');" ,locator);
		
	}
		/*public static void flash(WebElement locator,WebDriver driver) throws InterruptedException {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			String bgcolor = locator.getCssValue("background");
			for (int i=0;i<1000;i++) {
				changeColor("rgb(0,255,0)",locator,driver);
				//Thread.sleep(500);
				changeColor("rgb(255,0,0)",locator,driver);
			}
			
			
		}
		
		public static void changeColor(String color, WebElement locator,WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].style.background = arguments[1];",locator,color);
			//js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", locator);

			
			//try {
				//Thread.sleep(10000);
			//}catch(InterruptedException e) {
				
			//}
		}
		*/
}

