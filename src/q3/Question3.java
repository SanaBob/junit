package q3;

import java.util.Scanner;

public class Question3
{
   public static void main( String[] args )
      {
         Scanner input = new Scanner( System.in );
         System.out.println( "How many hours have you worked?" );
         double hoursWorked = Double.parseDouble(input.nextLine());
         System.out.println( "What is your hourly wage?" );
         double payRate = Double.parseDouble(input.nextLine());
         System.out.println( "What is the tax rate? (Enter 0.12 for 12%)" );
         double taxRate = Double.parseDouble(input.nextLine());
         double pay, tax, net;
         pay = hoursWorked * payRate;
         tax = hoursWorked * payRate * taxRate;
         net = pay - tax;
         System.out.println( "Pay Amount: " + pay );
         System.out.println( "Tax Amount: " + tax );
         System.out.println( "Net Earnings: " + net );
      }
}

