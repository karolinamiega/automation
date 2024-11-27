package lt.vcs.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestDemo {

    @Test
    public void testIsFourEven() {
        int number = 4;
        int expectedResult = 0;
        int actualResult;

        actualResult = number % 2;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testNegativeFourIsNotEven() {
        int number = 4;
        int expectedResult = 1;
        int actualResult;

        actualResult = number % 2;
        Assert.assertNotEquals(actualResult, expectedResult);
//        Assert.assertTrue(actualResult != expectedResult);
//        Assert.assertFalse(actualResult == expectedResult);
    }

    @Test
    public void testTimeNowIs19() {
        int expectedResult = 19;
        int actualResult;

        actualResult = LocalTime.now().getHour();
        Assert.assertEquals(actualResult, expectedResult);
    }

    //    Testas “žalias” jeigu 995 dalijasi iš 3 (be liekanos)
    @Test
    public void test995DividesBy3() {
        int num = 995;
        int actualResult = num % 3;
        int expectedResult = 0;

        Assert.assertEquals(actualResult, expectedResult);
    }


    //    Testas “žalias” jeigu šiandien trečiadienis
    @Test
    public void testIfTodayIsWednesday() {
        String expectedResult = "WEDNESDAY";
        String actualResult = String.valueOf(LocalDate.now().getDayOfWeek());

        Assert.assertEquals(actualResult, expectedResult);

    }

    //    Testas “žalias” po to, kai “palaukia” 5 sekundes
    @Test
    public void testWaitsFiveSeconds() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        long endTime = System.currentTimeMillis();
        long actualResult = endTime - startTime;
        long expectedResult = 5000;
        long tolerance = 100;

        Assert.assertTrue((actualResult - expectedResult) <= tolerance);

    }
//    Bonus: Testas “žalias” jei nuo 1 iki 10 yra 4 lyginiai skaičia

    @Test
    public void testCountOfEvenNumbersBetween1To10() {
        int expectedResult = 4;
        int actualResult = 0;

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                actualResult++;
            }
        }
        Assert.assertEquals(actualResult, expectedResult);

    }
}
