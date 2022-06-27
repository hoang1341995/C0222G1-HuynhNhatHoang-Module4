package com.example.book_application.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @After("execution(* com.example.book_application.controller.BookController.*(..))")
    public void logAfterMethodController(JoinPoint joinPoint) {
        String log = "";
        String nameMethod = joinPoint.getSignature().getName();
        if (nameMethod.equals("showIndex")){
            log = "Có 1 người truy cập";
        }
        switch (nameMethod){
            case "showIndex":
                log = "Có 1 người truy cập";
                break;
            case "handleException":
                log = "có lỗi tại phương thức "+ nameMethod;
                break;
            case "borrow":
                log = "Có 1 người thuê sách ";
                break;
            case "giveBack":
                 log = "Có 1 người trả sách ";
                break;
            default:
                log = "Tên phương thức được sử dụng " + nameMethod;
        }
        ReadAndWrite.write("/Users/hoanghuynh/Desktop/module4/ss9_ AOP_exception_handling/exercise/book_application/src/main/java/com/example/book_application/utils/log.txt",log);
    }
}
