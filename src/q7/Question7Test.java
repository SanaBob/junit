package q7;

import java.io.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class Question7Test {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void OutputCheckRandomArray() {

        int[] testArray = new int[(int) Math.floor(Math.random() * 100)];
        for(int i = 0; i < testArray.length; i++ ){
            testArray[i] = (int) Math.floor(Math.random() * 10);
        }

        int[] expectedArr = countThisPlease(testArray);
        String expectedOutput = "";

        int[] outputArr = Question7.countThisPlease(testArray);
        String actualOutput = "";

        for(int i = 0; i < expectedArr.length; i++ ){
            expectedOutput = expectedArr[i] + System.lineSeparator();
            actualOutput = outputArr[i] + System.lineSeparator();
        }

        assertEquals(expectedOutput, actualOutput, "The output for a random Array is different");
    }

    // @Test
    // public void OutputCheckOutOfBoundsArray() {

    //     int[] testArray = new int[(int) Math.floor(Math.random() * 100)];
    //     for(int i = 0; i < testArray.length; i++ ){
    //         testArray[i] = (int) Math.floor(Math.random() * 10);
    //     }

    //     int[] expectedArr = countThisPlease(testArray);
    //     String expectedOutput = "";

    //     int[] outputArr = Question7.countThisPlease(testArray);
    //     String actualOutput = "";

    //     for(int i = 0; i < expectedArr.length; i++ ){
    //         expectedOutput = expectedArr[i] + System.lineSeparator();
    //         actualOutput = outputArr[i] + System.lineSeparator();
    //     }

    //     assertEquals(expectedOutput, actualOutput, "The output for a random Array is different");
    // }

    public static int[] countThisPlease(int[] nums) {
        int[] counts = new int[10];
        for (int i = 0; i < nums.length; i++)
            counts[nums[i]]++;
        return counts;
    }
}
