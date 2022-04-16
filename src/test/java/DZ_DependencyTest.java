import org.testng.Assert;
import org.testng.annotations.Test;

public class DZ_DependencyTest {
    protected Calculator calculator = new Calculator("Test div");
    @Test(dependsOnMethods = {"testDivFour", "testDivThree"}, groups = "Целые")
    public void testDivOne(){
        Assert.assertEquals(calculator.divInt(6,3),2, "Не делится без остатка");
    }
    @Test (dependsOnMethods = "testDivOne", alwaysRun = true, groups = "Целые")
    public void testDivTwo(){
        Assert.assertEquals(calculator.divInt(6,3),2, "Не делится без остатка");
    }
    @Test (groups = "Целые")
    public void testDivThree(){
        Assert.assertEquals(calculator.divInt(6,3),2, "Не делится без остатка");
    }
    @Test (dependsOnMethods = "testDivThree", groups = "Целые")
    public void testDivFour(){
        Assert.assertEquals(calculator.divInt(6,3),2, "Не делится без остатка");
    }
    @Test(dependsOnGroups = "Целые")
    public void testDivOne2(){
        Assert.assertEquals (calculator.divDouble(23.5,2.5),9.4, "Неверное значение");
    }
    @Test (enabled = false, groups = "Дробные")
    public void testDivTwo2(){
        Assert.assertEquals (calculator.divDouble(23.5,2.5),9.4, "Неверное значение");
    }
    @Test (dependsOnMethods = "testDivOne2", groups = "Дробные")
    public void testDivThree2(){
        Assert.assertEquals (calculator.divDouble(23.5,2.5),9.4, "Неверное значение");
    }
    @Test (priority = 8, groups = "Дробные")
    public void testDivFour2(){
        Assert.assertEquals(calculator.divDouble(23.5,2.5),9.4, "Неверное значение");
    }


}
