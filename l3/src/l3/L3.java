    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package l3;
    import java.util.Scanner;
    /**
     *
     * @author vladyslavivchenko
     */
    public class L3 {
        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            // TODO code application logic here
            Scanner sc = new Scanner(System.in);
            
            String optionOne = "Option 1: Unlimited Calling and Texting. Price $89.00 per month.";
            String optionTwo = "Option 2: Unlimited Calling and Pay per text. Base Price: $79.00 per month plus 5 cents per text.";
            String optionThree = "Option 3: $35.00 base price for up to 50 minutes, and then 3 cents per minute. This option does not allow texting.";
            
            System.out.println(optionOne);
            System.out.println(optionTwo);
            System.out.println(optionThree);
            
            int option;
            do {
                System.out.println("Please type the number of option 1, 2, or 3 you want to sign for and press enter key)");
                    while (!sc.hasNextInt()) {
                        System.out.println("You entered not a number.");
                        sc.next();
                }
            option = sc.nextInt();
            }while (option <= 0 || option >= 4);
            
            if(option == 1){
                System.out.println("Your choice: " + optionOne);
            }
            else if(option == 2){
                System.out.println("Your choice: " + optionTwo);
            }
            else if(option == 3){
                System.out.println("Your choice: " + optionThree);
            }
            
            System.out.println("In order to help you to make sure that this plan is right for you please answer couple of questions.");
            
            int minutesNumber; 
            do{
                System.out.println("How many minutes a day do you talk on average over the phone? (Enter number and press enter key.");
                while(!sc.hasNextInt()){
                    System.out.println("You entered not a number!");
                    sc.next();
                }
                minutesNumber = sc.nextInt();
            }while(minutesNumber < 0);
           
            
            int messageNumber;
            do{
                System.out.println("How many messages do you send on average per one day? Enter number and press enter key.");
                while(!sc.hasNextInt()){
                    System.out.println("You entered not a number!");
                    sc.next();
                }
                messageNumber = sc.nextInt();
            }while(messageNumber < 0);
            
            if(minutesNumber > 50){
                if(messageNumber > 0){
                    double monthlyPayment = 79.0 + 0.03*messageNumber;
                    if(monthlyPayment < 89){
                        System.out.println("The best plan for you is: " + optionTwo);
                        System.out.println("Your montlhy statement will be " + monthlyPayment + " $/month");
                    }
                    else{
                        System.out.println("The best plan for you is: " + optionOne);
                        System.out.println("Your montlhy statement will be " + 89 + " $/month");
                    }
                }
            }
            else{
                if(messageNumber == 0){
                    System.out.println("The best plan for you is: " + optionThree);
                    System.out.println("Your montlhy statement will be " + 35 + " $/month");
                }
                else if(messageNumber > 0){
                    double monthlyPayment = 79 + 0.03*messageNumber;
                    if(monthlyPayment < 89){
                        System.out.println("The best plan for you is: " + optionTwo);
                        System.out.println("Your montlhy statement will be " + monthlyPayment + " $/month");
                    }
                    else if(monthlyPayment >= 89){
                        System.out.println("The best plan for you is: " + optionOne);
                        System.out.println("Your montlhy statement will be " + 89 + " $/month");
                    }
                }
            }






        }

    }
