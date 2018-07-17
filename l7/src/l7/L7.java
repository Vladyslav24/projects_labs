/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l7;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;

/**
 *
 * @author vladyslavivchenko
 */
public class L7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Scanner sc = new Scanner(new File("/Users/vladyslavivchenko/Documents/input.txt"));
        PrintStream ps = new PrintStream(new File("/Users/vladyslavivchenko/Documents/result.txt"));
        while(sc.hasNext()){
            String name = sc.next();
            int mathGrade = sc.nextInt();
            int readingGrade = sc.nextInt();
            String newLine = arrangeText(name, Integer.toString(mathGrade), Integer.toString(readingGrade));
            //System.out.println(newLine);
            ps.println(newLine);
        }
        
        }
    public static String arrangeText(String name, String mathScore, String readingScore){
        //name trim
        int nameColomn = 20 - name.length();
        if(name.length() < 25){
            for(int i = 0; i < nameColomn; i++){
           name += " ";
        }
        }
        //math score trim
        int mathColomn = 10 - mathScore.length();
        if(mathScore.length() < 10){
            for(int i = 0; i < mathColomn; i++){
           mathScore += " ";
        }
        }
        //reading score trim
        int readingColomn = 10 - readingScore.length();
        if(readingScore.length() < 10){
            for(int i = 0; i < readingColomn; i++){
           readingScore += " ";
        }
        }
        //total score trim
        
        return name + mathScore + readingScore;
    }
}
