/**
 * @author Vladyslav Ivchenko
 * @since 7-15-2018
 * @version 1.0
 *
 * Description: This is my first program. This program asks user to enter
 * his/her first and last name. After the user did it, he/she can press enter.
 * The program will project on the screen hello message followed by first and
 * last name of the user.
 */
package assignment_0;

import java.util.Scanner;

public class Assignment_0 {

    public static void main(String[] args) {

        String first, last;

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your first and last name.");
        System.out.println("Do not forget to press the ENTER key.");

        first = sc.next();
        last = sc.next();

        System.out.println("\nThis is my first program!");
        System.out.println("My name is: " + first + " " + last);
        
        System.out.print("GITHUBCHANGE");
    }
}
