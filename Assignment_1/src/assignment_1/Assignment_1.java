/**
 * @author Vladyslav Ivchenko
 * @since 7-18-2018
 * @version 1.0
 *
 * Description: The following program calculates the amount of money the company
 * (employer) needs to pay to employees depending on their wages, hours of work,
 * and overtime policy. The user needs to input data via the keyboard: hours of
 * work, straight time, and rate of pay of the employee(separated with space).
 * The program will calculate the amount of money the person should get in his/
 * her paychecks. In order to stop the program, user needs to input zero values.
 * After the program is over, the result of the calculation of all inputed data
 * will be saved to the text file "output.txt" with all necessary information.
 */

///NEW BRANCH
package assignment_1;

import java.io.PrintStream;
import java.util.Scanner;

public class Assignment_1 {

    public static void main(String[] args) throws Exception {

        double totalHoursWorked, straightTime, rateOfPay;

        Scanner sc = new Scanner(System.in);
        PrintStream ps = new PrintStream("output.txt");
        promtUser();
        totalHoursWorked = sc.nextDouble();

        //trailer method is used to stop the program when necessary 
        while (totalHoursWorked > 0) {
            straightTime = sc.nextDouble();
            rateOfPay = sc.nextDouble();
            payCheckCalculation(totalHoursWorked, straightTime, rateOfPay, ps);
            promtUser();
            totalHoursWorked = sc.nextDouble();
        }//end while
    }//end main

  
    //printToFile neatly prints info to txt file using prinf method
    public static void printToFile(double rateOfPay, double totalHours,
            double straightTime, double overTime, double grossPay,
            double tax, double netPay, PrintStream ps) throws Exception {

        ps.printf("%-25s $%.2f\n", "Rate of Pay:", rateOfPay);
        ps.printf("%-25s %.0f\n", "Total Hours Worked:", totalHours);
        ps.printf("%-25s %.0f\n", "Straight Time:", straightTime);
        ps.printf("%-25s %.0f\n", "Over Time:", overTime);
        ps.printf("%-25s $%.2f\n", "Gross Pay:", grossPay);
        ps.printf("%-25s $%.2f\n", "Tax:", tax);
        ps.printf("%-25s $%.2f\n", "Net Pay:", netPay);
        ps.println();
    }//end of printToFile

    public static void promtUser() {
        System.out.println("Enter the total hours the person worked, straight "
                + "time, and rate of pay(separated with space).");
        System.out.println("To stop the program enter zero values!");
    }//end of promtUser

    public static void payCheckCalculation(double totalHoursWorked, double straightTime,
            double rateOfPay, PrintStream ps) throws Exception {

        double straightTimePay, overTime, overTimePay, grossPay, tax, netPay;

        // if/else statement is used to separate people with and without overtime
        // hours. Therefore, different formulas used to calculate straightTimePay
        // and grossPay.
        if (totalHoursWorked <= straightTime) {
            overTime = 0;
            straightTimePay = totalHoursWorked * rateOfPay;
            grossPay = straightTimePay;
            tax = grossPay * 0.2;
            netPay = grossPay - tax;
            printToFile(rateOfPay, totalHoursWorked, straightTime, overTime,
                    grossPay, tax, netPay, ps);
        } else {
            overTime = totalHoursWorked - straightTime;
            overTimePay = overTime * 1.5 * rateOfPay;
            straightTimePay = straightTime * rateOfPay;
            grossPay = straightTimePay + overTimePay;
            tax = grossPay * 0.2;
            netPay = grossPay - tax;
            printToFile(rateOfPay, totalHoursWorked, straightTime, overTime,
                    grossPay, tax, netPay, ps);
        }
    } //end of payCheckCalculation
}
