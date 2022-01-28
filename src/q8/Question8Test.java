package q8;

import q8.Bubble;
import java.io.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class Question8Test {

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
    public void CheckOutputGetterSetterSize() {

        int[] randomInt = {1, 7, 27, 213, 1098};
        
        for(int i = 0; i < randomInt.length; i++){
            Bubble testBubble = new Bubble(Math.random());
            testBubble.setSize(randomInt[i]);
            assertEquals( randomInt[i], testBubble.getSize(), "The getter and setter for size is not working");
        }

    }

    @Test
    public void CheckOutputGetterSetterIsPopped() {
        Bubble bubble = new Bubble(10.0);
        bubble.setIsPopped(true);
        assertEquals(true, bubble.getIsPopped(), "The getter and setter for isPopped is not working");
        bubble.setIsPopped(false);
        assertEquals(false, bubble.getIsPopped(), "The getter and setter for isPopped is not working");
    }
}