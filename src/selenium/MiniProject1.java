package selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MiniProject1 {
	WebDriver driver =new ChromeDriver();
	String url="https://www.facebook.com";
	
	public void invokeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.get(url);
		
		String urlFromWebPage=driver.getCurrentUrl();
		
		if(urlFromWebPage.equals("https://www.facebook.com")) {
		  System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
	}
	
	public void signup() {
		WebElement createAccount=driver.findElement(By.xpath("//a[contains(text(),'Create new account')]"));
		
		if(createAccount.isDisplayed()) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		//driver.get("https://www.fb.com");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Aswin");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("S");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("987654321");
        WebElement day=driver.findElement(By.xpath("//select[@name='birthday_day']"));
        WebElement month=driver.findElement(By.xpath("//select[@name='birthday_month']"));
        WebElement year=driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select dates=new Select(day);
        Select months=new Select(month);
        Select years=new Select(year);
        dates.selectByVisibleText("12");
        months.selectByIndex(10);
        years.selectByValue("2000");
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        
        WebElement error1=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[2]/div/i[1]"));
        error1.click();
        String msg1=driver.findElement(By.xpath("//div[contains(text(),'Please enter a valid mobile number')]")).getText();
        System.out.println(msg1);
        
        WebElement error2=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[4]/div/i[1]"));
        error2.click();
        String msg2=driver.findElement(By.xpath("//div[contains(text(),'Enter a combination of')]")).getText();
        System.out.println(msg2);
        driver.close();
	}

	public static void main(String[] args) {
        MiniProject1 fb=new MiniProject1();
        fb.invokeBrowser();
        fb.signup();
	}
}
