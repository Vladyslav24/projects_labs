/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l4;

import java.util.Scanner;

/**
 *
 * @author vladyslavivchenko
 */
public class L4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
//        double a = 4.3321;
//        System.out.println(roundToTwoDecimals(a));
        printHello();
        double areaOfWork = areaOfWork();
        totalEstimate(costOfPaint(gallonPrice(),gallonsOfPaintRequired(areaOfWork)), laborCharges(laborHoursRequired(areaOfWork)));
        
        
        
    }
    public static void printHello(){
        System.out.println("Hello! This program will help you to calculate an estimate for the job you are going to do.");
    }
    public static double gallonPrice(){
        Scanner sc = new Scanner(System.in);
        double gallonPrice;
        
        do{
            System.out.println("Input the price of 1 gallon of paint (in US dollars) and press enter key...");
            while(!sc.hasNextDouble()){
                System.out.println("Not a number");
                sc.next();
            }
            gallonPrice = sc.nextDouble();
        }
        while(gallonPrice <= 0);
        return gallonPrice;
    }
    
    public static double areaOfWork(){
        
        Scanner sc = new Scanner(System.in);
        double squareArea;
        
        do{
            System.out.println("Input the area that is needed to be painted (in square feet) and press enter key...");
            while(!sc.hasNextDouble()){
                System.out.println("Not a number.");
                sc.next();
            }
            squareArea = sc.nextDouble();
        }while(squareArea <= 0);
        
        return squareArea;
    }
    
    
    public static double gallonsOfPaintRequired(double area){
        System.out.println("Gallons of paint needeed : "+ (area/100.0) + " gallons.");
        return area/100.00;
    }
    public static double laborHoursRequired(double area){
        System.out.println("Labor days needeed to finish work : "+ (area/100.0) + " days.");
        return area/100.0;
    }
    public static double costOfPaint(double price, double gallonsAmount){
        System.out.println("Total cost of paint : "+ (price*gallonsAmount) + " $");
        return price*gallonsAmount;
    }
    public static double laborCharges(double days){
        double wage = 25;
        double hoursPerDay = 8;
        System.out.println("Total cost of labor : "+ (wage*hoursPerDay*days) + " $");
        return wage*hoursPerDay*days;
    } 
    public static double totalEstimate(double paintCharges, double laborCharges){
        System.out.println("Total charges for work is  : "+ (paintCharges+laborCharges) + " $");
        return paintCharges+laborCharges;
    }
    
    /*
    public static double roundToTwoDecimals(double number){
        return  Math.round(number * 100.0) / 100.0;
    }*/
    
}
