/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l5;

import java.util.Scanner;

/**
 *
 * @author vladyslavivchenko
 * @version 1.0
 */
public class L5 {

    /**
     * This is the main method which makes use of randomGenerator method.
     * @param args the command line arguments.
     * @return Nothing.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! Are you ready to play a game with me?");
        System.out.println("Rules are pretty simple. I am thinking of a number between 0 and 100, and you need to guess that number.");
        System.out.println("Don't worry. You do not need to rush, but I will keep an eye of how many guesses you did before you hit the right number. ");
        System.out.println("And lastly, I will help you. If you number is wrong, I will give you a clue saying wheather this number is less or more than the one I have chosen.");
        System.out.println("Good luck!");
        do {
            int counter = 0;
            System.out.println("Enter any number between 0 and 100...");
            int playerNumber;
            int randomNumber = randomGenerator();

            for (int i = 0;; i++) {
                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Not a nubmer");
                        sc.next();
                    }
                    playerNumber = sc.nextInt();
                } while (playerNumber < 0 || playerNumber > 100);

                if (playerNumber != randomNumber) {
                    counter++;
                    if (playerNumber < randomNumber) {
                        System.out.println("Your number is smaller than the one I think about.");
                    } else if (playerNumber > randomNumber) {
                        System.out.println("Your number is bigger than the one I think about.");
                    }
                } else if (playerNumber == randomNumber) {
                    System.out.println("Excellent!!! You won! It took you " + (counter + 1) + " guesses to find the right one.");
                    break;
                }
            }
            if(counter>1){
                System.out.println("\nYou can do better!\n");
            }
            else{
                System.out.println("Perfect score!");
            }
            

        } while (true);
    }
    
   /**
   * Random number generator method
   * 
   * This is the method which generates random number in the range from 0 to 100.
   * @return int value of random variable in range of 0 to 100.
   */

    public static int randomGenerator() {
        int maxValue = 100;
        int minValue = 0;
        int range = maxValue - minValue + 1;

        return (int) (Math.random() * range) + minValue;
    }

}
