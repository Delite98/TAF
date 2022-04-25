import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XPathSelectorsTest {
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
    public void basicXpathSelectors(){
        driver.get(ReadProperties.getUrl("https://aqa18.testrail.io/index.php?/auth/login/"));

        //Абсолютный XPath
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div")).isDisplayed());

        //Все элементы на странице, начиная с html
        driver.findElement(By.xpath("//*[@id=\"fancy_overlay\"]"))

        //Аналог поиска по tagName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        //Поиск родительского div и на 1 уровень ниже h1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());

        //Поиск родительского div и на любом уровень ниже div
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());

        //Поиск элемента с тегом div, у которого есть атрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        //Поиск элемента, у которого есть атрибут id со значением 'top-logo'
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'top-logo']")).isDisplayed());

        //Поиск элемента, у которого есть атрибут method со значением И атрибут target со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method = 'post' and [@target ='_blank']]")).isDisplayed());

        //Поиск элемента, у которого есть атрибут method со значением ИЛИ атрибут target со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method = 'post' or [@target ='_blank']]")).isDisplayed());

        //Поиск элемента, который начинается с ate
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id, 'ate')]")).isDisplayed());

        //Поиск элемента, который содержит nim
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@id, 'nim')]")).isDisplayed());

        //Поиск любого элемента, который содержит текст
        Assert.assertTrue(driver.findElement(By.xpath("//*[text() = 'All Projects']")).isDisplayed());

        //Поиск элемента, который имеет тег div и содержит текст All Projects
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'All Projects')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = 'All Projects']")).isDisplayed());

        //Поиск элемента, который имеет тег div и содержит текст All Projects
        Assert.assertTrue(driver.findElement(By.xpath("//div[class = 'summary-links text-secondary']")).isDisplayed());

        //Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//div[class = 'summary-links text-secondary']/a[2]")).isDisplayed());

    }

    @Test
    public void axesXPathTest(){
        driver.get(ReadProperties.getUrl("https://aqa18.testrail.io/index.php?/auth/login/"));

        // Поиск родителя (один уровень) с тегом div у элемента с тегом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::div")).isDisplayed());

        // Поиск предка (несколько уровней) с тегом div у элемента с тегом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // Все дочерние элементы с тегом a от div
        Assert.assertTrue(driver.findElement(By.xpath("//h1/child::a")).isDisplayed());

        // Выбирает все в документе после закрытия текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='top']/following::form")).isDisplayed());

        // Выбирает все в документе после закрытия текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='top']/following-sibling::form")).isDisplayed());


        // Выбирает все в документе перед закрытием текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='dialog-title']/preceding::form")).isDisplayed());

        // Выбирает все в документе перед закрытием текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='dialog-title']/preceding-sibling::form")).isDisplayed());


    }
}
