package example.service.impl;

import example.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {

    @Override
    public String cal(int number1, int number2, String cal) {
        switch (cal) {
            case "+":
                return number1 +" "+cal+" "+number2+" = " + (number1 + number2);
            case "-":
                return number1 +" "+cal+" "+number2+" = " + (number1 - number2);
            case "*":
                return number1 +" "+cal+" "+number2+" = " + (number1 * number2);
            case "/":
                if (number2 == 0) {
                    return "number2 phải lớn hơn 0";
                } else {
                    return number1 +" "+cal+" "+number2+" = " + (number1 / number2);
                }
            default:
                return "error";
        }
    }
}
