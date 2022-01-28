package q3;

import java.io.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class Question3Test {

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
    public void OutputCheckNormal() {

        double[] input1 = { 1, 2, 144, 1236.8 }; // hoursworked
        double[] input2 = { 1, 2, 144, 532.4 }; // payrate
        double[] input3 = { 1, 2, 144, 14.5 }; // taxrate

        for (int i = 0; i < input1.length; i++) {
            provideInput(input1[i] + System.lineSeparator() + input2[i] + System.lineSeparator() + input3[i]
                    + System.lineSeparator());
            Question3.main(new String[0]);
            String actualOutput = getOutput();
            actualOutput = actualOutput.split(System.lineSeparator())[3 + i * 6].trim() + System.lineSeparator()
                    + actualOutput.split(System.lineSeparator())[4 + i * 6].trim() + System.lineSeparator()
                    + actualOutput.split(System.lineSeparator())[5 + i * 6].trim() + System.lineSeparator();

            double hoursWorked = input1[i];
            double payRate = input2[i];
            double taxRate = input3[i];
            double pay, tax, net;
            pay = hoursWorked * payRate;
            tax = hoursWorked * payRate * taxRate;
            net = pay - tax;
            String expectedOut = "Pay Amount: " + pay + System.lineSeparator() +
                    "Tax Amount: " + tax + System.lineSeparator() +
                    "Net Earnings: " + net + System.lineSeparator();

            assertEquals(expectedOut, actualOutput, "The output is different for positive doubles");
        }

    }

    @Test
    public void OutputCheckNegative0() {

        double[] input1 = { 0, -2, -144, -1236.8 }; // hoursworked
        double[] input2 = { 0, -2, -144, -532.4 }; // payrate
        double[] input3 = { 0, -2, -144, -14.5 }; // taxrate

        for (int i = 0; i < input1.length; i++) {
            provideInput(input1[i] + System.lineSeparator() + input2[i] + System.lineSeparator() + input3[i]
                    + System.lineSeparator());
            Question3.main(new String[0]);
            String actualOutput = getOutput();
            actualOutput = actualOutput.split(System.lineSeparator())[3 + i * 6].trim() + System.lineSeparator()
                    + actualOutput.split(System.lineSeparator())[4 + i * 6].trim() + System.lineSeparator()
                    + actualOutput.split(System.lineSeparator())[5 + i * 6].trim() + System.lineSeparator();

            double hoursWorked = input1[i];
            double payRate = input2[i];
            double taxRate = input3[i];
            double pay, tax, net;
            pay = hoursWorked * payRate;
            tax = hoursWorked * payRate * taxRate;
            net = pay - tax;
            String expectedOut = "Pay Amount: " + pay + System.lineSeparator() +
                    "Tax Amount: " + tax + System.lineSeparator() +
                    "Net Earnings: " + net + System.lineSeparator();

            assertEquals(expectedOut, actualOutput, "The output is different for negative doubles or 0");
        }

    }
}
