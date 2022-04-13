import org.testng.annotations.Test;

public class GroupsTest {
        @Test (groups = "smoke")
        public void stepB(){
            System.out.println("stepB..");
        }

        @Test (groups = "regression")
        public void stepA(){
            System.out.println("stepA..");
        }

        @Test(groups = "regression")
        public void stepD(){
            System.out.println("stepD..");
        }

        @Test (groups = {"smoke", "regression"})
        public void stepC(){
            System.out.println("stepC..");
        }
}
