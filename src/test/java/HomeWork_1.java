import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork_1 {
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
    public void CalcRehau() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        WebElement widthFloor = driver.findElement(By.id("el_f_width"));
        widthFloor.sendKeys("5");
        WebElement lengthFloor = driver.findElement(By.id("el_f_lenght"));
        lengthFloor.sendKeys("7");
        WebElement selectRoom = driver.findElement(By.id("room_type"));
        Select room = new Select(selectRoom);
        room.selectByValue("2");
        Thread.sleep(3000);
        room.selectByVisibleText("Остекленная лоджия или теплый балкон");
        Thread.sleep(3000);
        room.selectByValue("3");
        Thread.sleep(3000);
        WebElement selectHeating = driver.findElement(By.id("heating_type"));
        Select typeOfHeating = new Select(selectHeating);
        typeOfHeating.selectByVisibleText("Основное отопление");
        Thread.sleep(3000);
        typeOfHeating.selectByValue("3");
        WebElement heatingLosses = driver.findElement(By.id("el_f_losses"));
        heatingLosses.sendKeys("23");
        WebElement buttonCalc = driver.findElement(By.cssSelector("table + input"));
        buttonCalc.click();

        WebElement floorCabPower = driver.findElement(By.id("floor_cable_power"));
        Assert.assertEquals(floorCabPower.getAttribute("value"),"13");
        WebElement specFloorCablPower= driver.findElement(By.id("spec_floor_cable_power"));
        Assert.assertEquals(specFloorCablPower.getAttribute("value"), "0");
        Thread.sleep(2000);
    }
}
