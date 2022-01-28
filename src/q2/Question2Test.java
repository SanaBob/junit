package q2;

import java.io.*;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class Question2Test {

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
    public void OutputCheck() {
        
        Question2.main( new String[0] ); // needs generate key to test
        String actualOutput = getOutput();
        String[] split = actualOutput.trim().split(" ");
        System.out.println(split);
        
        int crypt = 0;
        int encrypt = 0;

        for(int i = 0; i < split.length; i++) {
            try {
                int num = Integer.parseInt(split[i]);
                if(crypt == 0) {
                    crypt = num;
                } else {
                    encrypt = num;
                }
            } catch(NumberFormatException e) {
                split[i] = "0";
            }
        }

        encrypt = crypt / (1 + new Random().nextInt(9));

        String expectedOut = crypt + " has been encrypted into " + encrypt + System.lineSeparator();
        // Call the main method here
        // Get the output

        // Compare
        assertEquals(expectedOut, actualOutput, "The output is different");
    }
}
