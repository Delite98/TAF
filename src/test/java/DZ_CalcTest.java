import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DZ_CalcTest {
    protected Calculator calculator = new Calculator("Test div");

    @Test(dataProvider = "dataDivDouble", dataProviderClass = StaticProvider.class, threadPoolSize = 4)
    public void testDataProvider2(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.divDouble (a,b), expectedResult, "Неверное значение");
    }

    @Test (invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void invocationCountTest2 () throws InterruptedException{
        Thread.sleep(900);
        Assert.assertEquals(calculator.divDouble (23.5, 2.5), 9.4, "Неверное значение");
    }

    @Test
    public void testDiv2(){
        Assert.assertEquals(calculator.divDouble(23.5,2.5),9.4, "Неверное значение");
    }
    @Test (testName = "Падающий тест")
    public void testFail2(){
        Assert.assertEquals(calculator.divDouble(23.5,2.5),9.7, "Неверное значение");
    }
    @Test (description = "Деление дробных чисел")
    public void testDescr2(){
        Assert.assertEquals(calculator.divDouble(23.5,2.5),9.4, "Неверное значение");
    }
    @Test (enabled = false)
    public void testIgnore2(){
        Assert.assertEquals(calculator.divDouble(23.5,2.5),9.4, "Неверное значение");
    }

    @Test (expectedExceptions = NullPointerException.class)
    public void testDZExeptions () {
        List list = null;
        int size = list.size();
    }

    @Test(dataProvider = "dataDivInteger", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void testDataProvider(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.divInt(a, b), expectedResult, "Не делится без остатка");
    }

    @Test (invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
            public void invocationCountTest () throws InterruptedException{
            Thread.sleep(900);
        Assert.assertEquals(calculator.divInt(6, 3), 2, "Не делится без остатка");
    }

    @Test(timeOut = 1000)
    public void waitLongTimeTest() throws InterruptedException {
        Thread.sleep(900);
    }
    @Test
    public void testDiv(){
        Assert.assertEquals(calculator.divInt(6,3),2, "Не делится без остатка");
    }
    @Test (testName = "Упавший тест")
    public void testFail(){
        Assert.assertEquals(calculator.divInt(6,3),3, "Не делится без остатка");
    }
    @Test (description = "Деление целых чисел")
    public void testDescr(){
        Assert.assertEquals(calculator.divInt(6,3),2, "Не делится без остатка");
    }
    @Test (enabled = false)
    public void testIgnore(){
    Assert.assertEquals(calculator.divInt(6,3),2, "Не делится без остатка");
    }
}
