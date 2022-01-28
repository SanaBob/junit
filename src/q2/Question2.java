package q2;

import java.util.Random;

public class Question2
   {
      public static void main( String[] args )
         {
            Random gen = new Random();
            int crypt = gen.nextInt( 90000000 ) + 10000000;
            int encrypt = crypt / (1 + gen.nextInt( 9 ));
            System.out.println( crypt + " has been encrypted into " + encrypt);
         }
   }

