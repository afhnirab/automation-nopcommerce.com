import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.*;

import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Nopcommerce {
    public static void main(String[] args) {

        String email1 = "nirab" + getRandom(100, 100000) + "@gmail.com";
        String password1 = "hello100";
        String username1 = "nirab" + getRandom(1, 1000);
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        register(driver, email1, password1, username1);
    }
    public static String getRandom(int min, int max){
        return Integer.toString(ThreadLocalRandom.current().nextInt(min, max));
    }

    public static void register(ChromeDriver driver, String email1, String password1, String username1){
        driver.get("https://www.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.xpath("//*[@id=\"en-page\"]/body/div[7]/header/nav/ul/li[3]/span/span"));
        actions.moveToElement(menu);
        WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"en-page\"]/body/div[7]/header/nav/ul/li[3]/ul/li[2]/a"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();

        driver.findElement(By.id("FirstName")).sendKeys("Nirab");
        driver.findElement(By.id("LastName")).sendKeys("Hossan");
        driver.findElement(By.id("Email")).sendKeys(email1);
        driver.findElement(By.id("ConfirmEmail")).sendKeys(email1);
        driver.findElement(By.id("Username")).sendKeys(username1);
        driver.findElement(By.id("check-availability-button")).click();

        WebElement selectCountry = driver.findElement(By.id("CountryId"));
        Select selectcount = new Select(selectCountry);
        selectcount.selectByValue("255");

        WebElement selectTime = driver.findElement(By.id("TimeZoneId"));
        Select timezone = new Select(selectTime);
        timezone.selectByValue("Bangladesh Standard Time");

        driver.findElement(By.id("Password")).sendKeys(password1);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password1);

        WebElement selectComp = driver.findElement(By.id("Details_CompanyIndustryId"));
        Select company = new Select(selectComp);
        company.selectByValue("5");
//
//        WebElement selectActivity = driver.findElement(By.id("Details_CompanyRoleId"));
//        Select activity = new Select(selectActivity);
//        activity.selectByValue("10");
//
//        WebElement selectSize = driver.findElement(By.id("Details_CompanySizeId"));
//        Select size = new Select(selectSize);
//        size.selectByValue("1");

        driver.findElement(By.id("register-button")).click();

    }
}
