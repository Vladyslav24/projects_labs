/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l2;

import java.util.Scanner;

/**
 *
 * @author vladyslavivchenko
 */
public class L2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        double weightInKilo;
        double dosage;
        double patientOneWeight = 150.0;
        double patientTwoWeight = 200.0;
        double patientThreeWeight = 250.0;
        System.out.println("The program will tell how many mg of medication patients need to take depending on their weight.\n");
        
        weightInKilo = patientOneWeight/2.2046;
        dosage = weightInKilo*30; 
        System.out.println("Patient#1 weight is: " + patientOneWeight + " lb, or " + weightInKilo + " kg.");
        System.out.println("The patient#1 need to take " + dosage + " mg of medication.");
        System.out.println("------------------------------------------------------------");
        
        weightInKilo = patientTwoWeight/2.2046;
        dosage = weightInKilo*30; 
        System.out.println("Patient#2 weight is: " + patientTwoWeight + " lb, or " + weightInKilo + " kg.");
        System.out.println("The patient#2 need to take " + dosage + " mg of medication.");
        System.out.println("------------------------------------------------------------"); 
        
        weightInKilo = patientThreeWeight/2.2046;
        dosage = weightInKilo*30; 
        System.out.println("Patient#3 weight is: " + patientThreeWeight + " lb, or " + weightInKilo + " kg.");
        System.out.println("The patient#3 need to take " + dosage + " mg of medication.");
        System.out.println("------------------------------------------------------------");
        
    }
    
}
