import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssSelectorsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void cssSelectorsTest() throws InterruptedException {
        driver.get("D:\\TMS\\TAF\\src\\test\\resources\\index.html");
        Thread.sleep(2000);

        //Поиск по id
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed());

        //Поиск по class name
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());

        //Поиск по нескольким значениям в аттрибуте class
        Assert.assertTrue(driver.findElement(By.cssSelector(".noSel.newsletter")).isDisplayed());

        //Поиск по tag name
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());

        //Поиск по tag и значению из аттрибута class
        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed());//Поиск по tag и значению из аттрибута class

        //Поиск по tag и значению из аттрибута class
        Assert.assertEquals(2, driver.findElements(By.cssSelector("#Lastname .markup")).size());

        //Поиск всех элементов с тегом h1 или p
        Assert.assertEquals(8, driver.findElements(By.cssSelector("h1, p")).size());

        //Поиск всех элементов с тегом p, у которых непосредственный родитель с тегом div
        Assert.assertEquals(6, driver.findElements(By.cssSelector("div >p")).size());

        //Поиск всех элементов с тегом p, которые идут сразу за элементом с тегом ul
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + p")).size());

        //Поиск всех элементов с тегом div, которые являются братьями элементам с тегом p
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p ~ div")).size());

        //Поиск всех элементов у которых присутствует аттрибут lilte
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title]")).size());

        //Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());

        //Поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$=ess]")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value-
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id^=L]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим слово целиком
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим какой текст
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*=beaut]")).size());

        // Поиск всех disabled элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());

        // Поиск всех enabled элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":enabled")).size());

        // Поиск всех выборанных элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":checked")).size());

        // Поиск всех элементов c пустым телом
        Assert.assertEquals(1,driver.findElements(By.cssSelector(":empty")));

        // Поиск элемента с тегом p и который является первым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:first-child")).size());

        // Поиск элемента с тегом p и который является последним дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:last-child")).size());

        // Поиск элемента с тегом p и который является n-ым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(2)")).size());

    }
}