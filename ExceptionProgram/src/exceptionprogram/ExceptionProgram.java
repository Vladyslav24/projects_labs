/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionprogram;

/**
 *
 * @author vladyslavivchenko
 */
public class ExceptionProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            
            f();
        }
        catch(MyException e){
            System.out.println(e.login + e.password + " ");
        }
    }
    public static void f() throws MyException{
        int a, b;
        a = 0;
        b = 10;
        System.out.println(b/a);
    }

    public class MyException extends Exception {

        private String login;

        private String password;

        public MyException(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }
}
