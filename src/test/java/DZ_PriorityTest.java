import org.testng.Assert;
import org.testng.annotations.Test;

public class DZ_PriorityTest {
    protected Calculator calculator = new Calculator("Test div");
    @Test(priority = 3)
    public void testDivOne(){
        Assert.assertEquals(calculator.divInt(6,3),2, "Не делится без остатка");
    }
    @Test (priority = 1)
    public void testDivTwo(){
        Assert.assertEquals(calculator.divInt(6,3),2, "Не делится без остатка");
    }
    @Test (priority = 4)
    public void testDivThree(){
        Assert.assertEquals(calculator.divInt(6,3),2, "Не делится без остатка");
    }
    @Test (priority = 2)
    public void testDivFour(){
        Assert.assertEquals(calculator.divInt(6,3),2, "Не делится без остатка");
    }

    @Test(priority = 6)
    public void testDivOne2(){
        Assert.assertEquals (calculator.divDouble(23.5,2.5),9.4, "Неверное значение");
    }
    @Test (priority = 8)
    public void testDivTwo2(){
        Assert.assertEquals (calculator.divDouble(23.5,2.5),9.4, "Неверное значение");
    }
    @Test (priority = 5)
    public void testDivThree2(){
        Assert.assertEquals (calculator.divDouble(23.5,2.5),9.4, "Неверное значение");
    }
    @Test (priority = 7)
    public void testDivFour2(){
        Assert.assertEquals(calculator.divDouble(23.5,2.5),9.4, "Неверное значение");
    }

}