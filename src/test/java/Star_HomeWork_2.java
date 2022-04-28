import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Star_HomeWork_2 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserService browserService = new BrowserService();
        driver = browserService.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void CalcLam() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");

        WebElement selectWay = driver.findElement(By.id("laying_method_laminate"));
        Select way = new Select(selectWay);
        way.selectByValue("2");
        WebElement lenght = driver.findElement(By.id("ln_room_id"));
        lenght.clear();
        lenght.sendKeys("500");
        WebElement width = driver.findElement(By.id("wd_room_id"));
        width.clear();
        width.sendKeys("400");
        WebElement lenghtPanel = driver.findElement(By.id("ln_lam_id"));
        lenghtPanel.clear();
        lenghtPanel.sendKeys("2000");
        WebElement widthPanel = driver.findElement(By.id("wd_lam_id"));
        widthPanel.clear();
        widthPanel.sendKeys("200");
        WebElement choice = driver.findElement(By.id("direction-laminate-id1"));
        choice.click();
        WebElement button = driver.findElement(By.className("calc-btn-div"));
        button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement numBoards = driver.findElement(By.cssSelector(".calc-result div:first-child"));
        Assert.assertEquals(numBoards.getText(), "Требуемое количество досок ламината: 53");
        WebElement numBox = driver.findElement(By.cssSelector(".calc-result div:nth-child(2)"));
        Assert.assertEquals(numBox.getText(), "Количество упаковок ламината: 7");
        Thread.sleep(20000);
    }
}
