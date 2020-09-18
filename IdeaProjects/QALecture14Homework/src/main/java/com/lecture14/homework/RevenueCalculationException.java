package com.lecture14.homework;

public class RevenueCalculationException extends Exception {
    public RevenueCalculationException(String message){
        super(message);
    }
    public RevenueCalculationException(String message,Throwable cause){
        super(message, cause);
    }
}
