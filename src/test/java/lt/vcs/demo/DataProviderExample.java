package lt.vcs.demo;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    @Test
    public void test4isEven(){
        int value = 4;
        int expectedResult = 0;
        int actualResult;

        actualResult = value % 2;


        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void test5isNotEven(){
        int value = 5;
        int expectedResult = 0;
        int actualResult;

        actualResult = value % 2;

        Assert.assertNotEquals(actualResult, expectedResult);

    }

    @DataProvider(name = "dataProviderIsEven")
    public Object[][] provideDataForTestIfEven(){
        // some more code here
        return new Object[][]{
                {4, 0},
                {-6, 0},
                {1208, 0},
                {5, 1},
                {-169, -1},
                {999, 1}
        };
    }

    @Test(dataProvider = "dataProviderIsEven")
    public void testIfEven(int value, int expectedResult){
        int actualResult = value % 2;


        Assert.assertEquals(actualResult, expectedResult);
    }
}
