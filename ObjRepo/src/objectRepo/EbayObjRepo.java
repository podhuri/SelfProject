package objectRepo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EbayObjRepo {
	
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		
	
			
		Properties prop = new Properties();
		FileInputStream ips = new FileInputStream("C:\\Users\\podhuri\\eclipse-workspace"
				+ "\\ObjRepo\\src\\objectRepo\\config.properties");
		prop.load(ips);
	
		String url = prop.getProperty("url");
		System.out.println(url);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\podhuri\\OneDrive - Capgemini\\Desktop\\DRIVER\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("ff")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\podhuri\\OneDrive - Capgemini\\Desktop\\DRIVER\\chromedriver.exe");
			 driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		
		
		driver.findElement(By.xpath(prop.getProperty("fname_xpath"))).sendKeys(prop.getProperty("fname"));
		driver.findElement(By.xpath(prop.getProperty("lname_xpath"))).sendKeys(prop.getProperty("lname"));
		driver.findElement(By.xpath(prop.getProperty("address_xpath"))).sendKeys(prop.getProperty("address"));
		driver.findElement(By.xpath(prop.getProperty("city_xpath"))).sendKeys(prop.getProperty("city"));
		
		Thread.sleep(3000);
		Select state =new Select(driver.findElement(By.id(prop.getProperty("state_xpath"))));
		state.selectByVisibleText("state");;
		
		driver.findElement(By.xpath(prop.getProperty("zip_xpath"))).sendKeys(prop.getProperty("zip"));
		driver.findElement(By.xpath(prop.getProperty("phone1_xpath"))).sendKeys(prop.getProperty("phone1"));
		driver.findElement(By.xpath(prop.getProperty("phone2_xpath"))).sendKeys(prop.getProperty("phone2"));
		driver.findElement(By.xpath(prop.getProperty("phone3_xpath"))).sendKeys(prop.getProperty("phone3"));
		
		driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(prop.getProperty("re_email_xpath"))).sendKeys(prop.getProperty("re_email"));
		driver.findElement(By.xpath(prop.getProperty("userid_xpath"))).sendKeys(prop.getProperty("userid"));
		driver.findElement(By.xpath(prop.getProperty("pass_xpath"))).sendKeys(prop.getProperty("pass"));
		driver.findElement(By.xpath(prop.getProperty("re_pass_xpath"))).sendKeys(prop.getProperty("re_pass"));
		
		Select question = new Select(driver.findElement(By.xpath("secretques_xpath")));
		question.selectByIndex(3);
		driver.findElement(By.xpath(prop.getProperty("secretans_xpath"))).sendKeys(prop.getProperty("secretans"));
		
		Select month = new Select(driver.findElement(By.xpath("month_xpath")));
		month.selectByVisibleText("June");;
		
		Select date = new Select(driver.findElement(By.xpath("date_xpath")));
		date.selectByIndex(3);
		
		Select year = new Select(driver.findElement(By.xpath("year_xpath")));
		year.selectByIndex(3);
		
		driver.findElement(By.xpath(prop.getProperty("agree_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("continue_btn_xpath"))).click();
		
		driver.quit();

		
		
	}

}
