import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.annotation.Target;

public class SmokeTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        BrowserService browserService = new BrowserService();
        driver = browserService.getDriver();
    }
    @Test
    public void validateIKTCalculation() throws InterruptedException {
        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");
        WebElement height = driver.findElement(By.name("height"));
        WebElement weight = driver.findElement(By.name("weight"));
        WebElement button = driver.findElement(By.id("calc-mass-c"));
        height.sendKeys("183");
        weight.sendKeys("58");
        button.click();

        Thread.sleep(2000);
        WebElement result = driver.findElement(By.id("imt-result"));
        Assert.assertEquals(result.getText(), "17.3 - Недостаточная (дефицит) масса тела");
    }

    @Test
    public void validateSKF() throws InterruptedException {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");

        WebElement selectWebElemen = driver.findElement(By.id("oSex"));
        Select selectSex = new Select(selectWebElemen);
        selectSex.selectByIndex(1);
        Thread.sleep(2000);
        selectSex.selectByValue("0");
        Thread.sleep(2000);
        selectSex.selectByVisibleText("женский");
        Thread.sleep(2000);
        WebElement creatin = driver.findElement(By.id("oCr"));
        creatin.sendKeys("80");
        WebElement age = driver.findElement(By.id("oAge"));
        age.sendKeys("38");
        WebElement weight = driver.findElement(By.id("oWeight"));
        weight.sendKeys("55");
        WebElement height = driver.findElement(By.id("oHeight"));
        height.sendKeys("163");
        WebElement button = driver.findElement(By.xpath("//input[@value='Рассчитать']"));
        button.click();

        WebElement mdrd = driver.findElement(By.id("txtMDRD"));
        Assert.assertEquals(mdrd.getText(), "MDRD: 74 (мл/мин/1,73кв.м)");
        WebElement xbp = driver.findElement(By.id("txtMDRD1"));
        Assert.assertEquals(xbp.getText(),"ХБП: 2 стадия (при наличии почечного повреждения)");
        WebElement cockroftG = driver.findElement(By.id("txtCG"));
        Assert.assertEquals(cockroftG.getText(), "Cockroft-Gault: 70 (мл/мин)");
        WebElement body = driver.findElement(By.id("txtBSA"));
        Assert.assertEquals(body.getText(), "Поверхность тела:1.58 (кв.м)");
        Thread.sleep (2000);
    }
    @AfterMethod
    public void tearDown(){
     driver.quit();
    }
}
