package Utility;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PractiseTables {
	static Date d = new Date();
	
 public static Logger log = LogManager.getLogger(PractiseTables.class.getName());
	public static void main(String[] args) {
		
		System.setProperty("current.date",d.toString().replace(":","_").replace(" ", "_"));
		log.debug("Hello debug 1");
		System.setProperty("webdriver.chrome.driver", "H:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/30464/mi-vs-kxip-36th-match-indian-premier-league-2020");
		log.error("Hello error 1");
		List<WebElement> runs = driver.findElements(By.xpath("//div[@id='innings_1'] //div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'] //div[@class='cb-col cb-col-33']/following-sibling::div[1]"));
		log.debug("Hello debug 2");
		int sum=0;
		System.out.println(runs.size());
		for(int i=1;i<runs.size();i++)
		{
		String numString = runs.get(i).getText();
		System.out.println(numString);
		sum +=Integer.parseInt(numString);
		//System.out.println(sum);
		} 
		log.error("Hello error 2");

		List<WebElement> otherRuns = driver.findElements(By.xpath("//div[@id='innings_1'] //div[@class='cb-col cb-col-60']/following-sibling::div[1]"));
		System.out.println("extras String format "+ otherRuns.get(0).getText());
		int extras= Integer.parseInt(otherRuns.get(0).getText());
		System.out.println("extras "+ extras);
		
		sum+=extras;
         System.out.println(sum);
        int a =Integer.parseInt(otherRuns.get(1).getText());
        System.out.println("poora "+a);
        Assert.assertEquals(a, sum);
//__________________________Click on Dynamic Dropdown______________________________________________
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ch");
        
        List<WebElement> dOptions = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
        for(int i=0;i<dOptions.size();i++) {
            System.out.println(dOptions.get(i).getText());
            if(dOptions.get(i).getText().equalsIgnoreCase("Taiwan, Province of China")) {
            	dOptions.get(i).click();
            	break;
            }
        }
        
	}

}
