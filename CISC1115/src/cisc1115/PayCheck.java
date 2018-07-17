/**
 *
 * @author vladyslavivchenko
 * @since July 12, 2018
 * @version 1.0
 *
 * Description : This is my first program, and it will print hello world.
 * IMPORTANT !!! WRITE A LOT ABOUT PROGRAM, PROBLEMS, GOALS, ETC.
 */
package cisc1115;

import java.util.Scanner;

public class PayCheck {

    public static void main(String[] args) {

        final double TAX = 25.00;
        double gross, net, hours, rate;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter hours and rate you recieve.");
        hours = sc.nextDouble();
        rate = sc.nextDouble();
        gross = hours*rate;
        net = gross - TAX;
        System.out.printf("Gross is: $%.2f\n ", gross);
        System.out.printf("Net is: $%.2f\n", net);

    }//end of main method

} // end of HelloWorld class
