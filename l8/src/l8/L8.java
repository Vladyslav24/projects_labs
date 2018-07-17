/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author vladyslavivchenko
 */
public class L8 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner sc = new Scanner(new File("/Users/vladyslavivchenko/Documents/dna.txt"));
        String dna = "";
        String motif = "GAC";
        while (sc.hasNextLine()) {
            dna += sc.nextLine();
        }
        dna = dna.toUpperCase();

        //System.out.println(isValidDNA2(dna));
        if (isValidDNA(dna)) {
            System.out.println("The DNA has a valid structure!");
            int tandemValue = numTandem(motif, dna);
            if (tandemValue == 0) {
                System.out.println("There is no such sequence in DNA fragment.");
            } else if (tandemValue == 1) {
                System.out.println("There is no tandem sequences. Only single piece of DNA: " + motif);
            } else {
                System.out.println("The longest tandem sequence of DNA piece - " + motif + " is: " + tandemValue);
            }

        } else {
            System.out.println("The DNA you uploaded is wrong and has invalid structure.");
        }
    }

    public static boolean isValidDNA(String dna) {
        char[] arrayOfDNA = dna.toCharArray();
        boolean check = true;
        for (int i = 0; i < arrayOfDNA.length; i++) {
            if (arrayOfDNA[i] != 'A') {
                if (arrayOfDNA[i] != 'C') {
                    if (arrayOfDNA[i] != 'G') {
                        if (arrayOfDNA[i] != 'T') {
                            return false;
                        }
                    }
                }
            }

        }
        return check;
    }
    
    public static String motifInput(){
        
        Scanner sc = new Scanner (System.in);
        
        
        
        return null;
    }

    public static boolean isValidDNA2(String dna) {
        boolean check = true;
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) != 'A') {
                if (dna.charAt(i) != 'C') {
                    if (dna.charAt(i) != 'G') {
                        if (dna.charAt(i) != 'T') {
                            return false;
                        }
                    }
                }
            }

        }
        return check;
    }

    public static int numTandem(String motif, String dna) {

        int maxTandemCount = 0;
        for (int i = 0; i < dna.length() - motif.length();) {
            int tandemCounter = 0;

            //System.out.println(dna.substring(i, i+motif.length()));
            for (int j = i; j < dna.length() - motif.length(); j = j + motif.length()) {
                if (dna.substring(j, j + motif.length()).equals(motif)) {
                    //System.out.println(j + " " + (j + motif.length()));
                    i = i + motif.length();
                    tandemCounter++;
                    if (maxTandemCount < tandemCounter) {
                        maxTandemCount = tandemCounter;
                    }
                    // System.out.println(tandemCounter);

                } else {
                    i++;
                    break;
                }
            }
        }
        return maxTandemCount;

//        for (int i = 0; i < dna.length() - motif.length();) {
//            int tandemCounter = 0;
//            //System.out.println(dna.substring(i, i+motif.length()));
//            for (int j = i;;) {
//                if (dna.substring(i, i + motif.length()).equals(motif)) {
//                    System.out.println(i + " " + (i + motif.length()));
//                    i = i + motif.length();
//                } else {
//                    i++;
//                }
//            }
//        }
    }

}
