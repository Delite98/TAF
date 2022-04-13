import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {
    @Test
    public void stepB(){
        System.out.println("stepB..");
    }

    @Test (dependsOnMethods = "stepB")
    public void stepA(){
        System.out.println("stepA..");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "stepA", alwaysRun = true)
    public void stepD(){
        System.out.println("stepD..");
    }

    @Test(dependsOnMethods = {"stepD", "stepA"})
    public void stepC(){
        System.out.println("stepC..");
    }
}
