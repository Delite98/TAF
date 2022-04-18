import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstTest  {
    private WebDriver driver;
    @Test
    public void browserTests(){
        SimpleDriver simpleDriver = new SimpleDriver();
        driver = simpleDriver.getDriver();
    }
    @Test
    public void advancedTests (){
        AdvancedDriver advancedDriver = new AdvancedDriver();
        driver = advancedDriver.getDriver();
    }
    @Test
    public void browserServiseTests (){
        BrowserService browserService = new BrowserService();
        driver = browserService.getDriver();
    }


}
