package example.service.impl;

import example.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {

    @Override
    public double cal(int number1, int number2, String cal) {
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
