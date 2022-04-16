package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider (name="dataForSum")
    public static Object[][] dataForSumTest() {
        return new Object[][]{
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5}
        };
    }
    @DataProvider (name = "dataDivInteger")
    public static Object[][]dataDivInteger(){
        return new Object[][]{
                {-12, -4, 9},
                {0,0,0},
                {4, 4, 1}
        };
    }
    @DataProvider (name = "dataDivDouble")
    public static Object[][]dataDivDouble(){
        return new Object[][]{
                {-49.84, -5.6, 8.9},
                {0,0,0},
                {567.3, 45.7, 18.9}
        };
    }
}

