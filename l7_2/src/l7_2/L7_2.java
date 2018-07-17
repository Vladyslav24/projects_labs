/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l7_2;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author vladyslavivchenko
 */
public class L7_2 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int k;
        int linesNumber = checkAmountOfLines();
        
        do {
            System.out.println("The amount of lines in a file is " + linesNumber);
            System.out.println("Enter number that is bigger than 0 and less than amount of lines in the file.");
            while (!sc.hasNextInt()) {
                System.out.println("Not a nubmer");
                sc.next();
            }
            k = sc.nextInt();

        } while (k < 0 || k > linesNumber);

        int[] mathScore = new int[k];
        int[] readingScore = new int[k];
        int[] sumScores = new int[k];
        boolean[] maxArea = new boolean[k];

        readSATScores(mathScore, readingScore, k);
        sumScores(mathScore, readingScore, sumScores, k);
        fillMax(mathScore, readingScore, k, maxArea);
        tallyAreas(maxArea, k);
        print4Arrays(mathScore, readingScore, sumScores, maxArea, k);

    }
    
    public static void print4Arrays(int[] mathScores, int [] readingScores, int[] sumScores, boolean[] maxArea, int k) throws Exception{
        PrintStream ps = new PrintStream(new File("/Users/vladyslavivchenko/Documents/result.txt"));
        ps.println("Math      " + "Reading   " + "Total     " + "MaxArea");
        for(int i = 0; i < k; i ++){
            String newLine = arrangeText(mathScores[i], readingScores[i], sumScores[i], maxArea[i]);
            ps.println(newLine);
        }
        ps.close();
        
    }
    
    public static void tallyAreas(boolean[] maxArea, int k){
        int mathResults = 0;
        int readingResults = 0;
        for(int i = 0; i < k; i ++){
            if(maxArea[i] == true){
                mathResults++;
            }
            else{
                readingResults++;
            }
        }
        System.out.println("In math exam " + mathResults +  " students scored the best.");
        System.out.println("In reading exam " + readingResults +  " students scored the best.");
    }
    
    public static void fillMax(int [] mathScores, int [] readingScores, int k, boolean [] maxArea){
        for(int i = 0; i < k-1; i ++){
            if(mathScores[i] >= readingScores[i]){
                maxArea[i] = true;
            }
            else{
                maxArea[i] = false;
            }
        }
    }
    
    public static void sumScores(int [] mathScores, int [] readingScores, int [] totalScores, int k){
        for(int i=0; i < k; i ++){
            totalScores[i] = mathScores[i] + readingScores[i];
        }
        
    }

    public static void readSATScores(int[] mathScores, int[] readingScores, int k) throws Exception {
        Scanner sc = new Scanner(new File("/Users/vladyslavivchenko/Documents/input.txt"));

        for (int i = 0; i < k; i++) {
            if (!sc.hasNext()) {
                System.out.println("The number your entered: " + k + " - is less than actual amount of lines in the file: " + i + ".");
                break;
            } else {
                int mathGrade = sc.nextInt();
                int readingGrade = sc.nextInt();
                mathScores[i] = mathGrade;
                readingScores[i] = readingGrade;
            }
        }
    }

    public static int checkAmountOfLines() throws Exception {

        Scanner sc = new Scanner(new File("/Users/vladyslavivchenko/Documents/input.txt"));
        int count = 0;
        while (sc.hasNextLine()) {
            count++;
            sc.nextLine();
        }
        return count;
    }

    public static String arrangeText(int mathScore, int readingScore, int sumScore, boolean area) {

        //math score trim
        String mathToString = Integer.toString(mathScore);
        int mathColomn = 10 - mathToString.length();
        if (mathToString.length() < 10) {
            for (int i = 0; i < mathColomn; i++) {
                mathToString += " ";
            }
        }
        //reading score trim
        String readingToString = Integer.toString(readingScore);
        int readingColumn = 10 - readingToString.length();
        if (readingToString.length() < 10) {
            for (int i = 0; i < readingColumn; i++) {
                readingToString += " ";
            }
        }
        //total score trim
        String sumToString = Integer.toString(sumScore);
        int sumColumn = 10 - sumToString.length();
        if (sumToString.length() < 10) {
            for (int i = 0; i < sumColumn; i++) {
                sumToString += " ";
            }
        }
        
        //total score trim
        String areaToString;
        if(area == true){
           areaToString = "math";
        }
        else{
            areaToString = "reading";
        }
        int areaColumn = 10 - areaToString.length();
        if (areaToString.length() < 10) {
            for (int i = 0; i < areaColumn; i++) {
                areaToString += " ";
            }
        }


        return mathToString + readingToString + sumToString + areaToString;
    }

}
