import org.testng.annotations.Test;

public class PriorityTest {
    @Test (priority = 1)
    public void stepB(){
        System.out.println("stepB..");
    }@Test(priority = 2)
    public void stepA1(){
        System.out.println("stepA1..");
    }@Test(priority = 3)
    public void stepA11(){
        System.out.println("stepA11..");
    }@Test(priority = 4)
    public void stepC(){
        System.out.println("stepC..");
    }
}
