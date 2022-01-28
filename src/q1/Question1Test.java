package q1;
import java.io.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class Question1Test {

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
        //Call the main method here
        Question1.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        
        String[] split = actualOutput.trim().split(" ");
        System.out.println(split);
        int inputVar = 0;
        int outputVar = 0; //outputVar is useless here

        for(int i = 0; i < split.length; i++) {
            try {
                int num = Integer.parseInt(split[i]);
                if(inputVar == 0) {
                    inputVar = num;
                } else {
                    outputVar = num;
                }
            } catch(NumberFormatException e) {
                split[i] = "0";
            }
        }
        double r = 0.3;
        // int t = 30;
        int x0 = 5;
        double quantity = Math.pow( 1+r, inputVar );
        double xt = quantity * x0;
        String expectedOut = "Num cases of infections in " + inputVar + " days is " + xt + " people" + System.lineSeparator();
        //Compare
        assertEquals(expectedOut, actualOutput, "The output is different");
    }
}
