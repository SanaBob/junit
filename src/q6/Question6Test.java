package q6;

import java.io.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class Question6Test {

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
    public void PrimeTrueVariables() {

        String expectedOut = "true" + System.lineSeparator();
        int[] input1 = {-245, -14, -1, 0, 2, 3, 2393, 7393}; // all negarive variables work
        for(int i = 0; i < input1.length; i++){
            provideInput(input1[i] + System.lineSeparator());
            Question6.main( new String[0] );
            String actualOutput = getOutput();
            actualOutput = actualOutput.split(System.lineSeparator())[1 + i * 2] + System.lineSeparator();
            assertEquals(expectedOut, actualOutput, "The output is different");
        }

    }

    @Test
    public void PrimeFalseVariales() {

        String expectedOut = "false" + System.lineSeparator();
        int[] input1 = { 9, 27, 952, 7923 };
        for(int i = 0; i < input1.length; i++){
            provideInput(input1[i] + System.lineSeparator());
            Question6.main( new String[0] );
            String actualOutput = getOutput();
            actualOutput = actualOutput.split(System.lineSeparator())[1 + i * 2] + System.lineSeparator();
            assertEquals(expectedOut, actualOutput, "The output is different");
        }

    }
}