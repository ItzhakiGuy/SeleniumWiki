import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.*;

public class seleniumTest {


    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        ChromeDriver driver=new ChromeDriver();

        driver.get("https://www.wikipedia.org");
        WebElement searchRobert = driver.findElementById("searchInput");
        searchRobert.sendKeys("Uncle Bob");
        driver.findElementByXPath("//*[@id='search-form']/fieldset/button").click();
        WebElement uncBob = driver.findElementByXPath("//*[@id='mw-content-text']/div[1]");
        Boolean isRCM = false;
        List<WebElement> uncleBob=uncBob.findElements(By.tagName("li"));
        for (WebElement result: uncleBob){
            System.out.println(result.getText());
            if (result.getText().contains("Robert C. Martin"))
                isRCM = true;
        }
        if (isRCM){
            System.out.println("Robert C. Martin is found!! :-)");
            uncBob.findElement(By.linkText("Robert C. Martin")).click();
            String bday = driver.findElementByXPath("//*[@id=\"mw-content-text\"]/div[1]/table[2]/tbody/tr[3]/td/span[1]/span").getAttribute("innerHTML");
            System.out.println(bday);
        }
            else
            System.out.println("Ohhhh no......");
    }
}
