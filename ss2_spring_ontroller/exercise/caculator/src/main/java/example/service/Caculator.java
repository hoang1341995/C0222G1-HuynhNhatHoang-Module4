package example.service;

public class Caculator {
    public static double cal(int number1,int number2,String cal){
        switch (cal){
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
            default:
                return 0;
        }
    }
}
