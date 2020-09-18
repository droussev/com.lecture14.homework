package com.lecture14.homework;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    final int option = 1;

    public static void main(String[] args) {
        SoleProprietor sp = new SoleProprietor(
                "ЕТ Чугун99",
                "19.9.1999",
                "1028528710",
                "Желязко Каменов",
                10000,
                99999);
        int result1, result2;

        //case1 catching exceptions
        result1 = sp.getProfitForPeriod("340days", 150700);
        result2 = sp.getProfitForPeriod("0", 150700);

        //case2 catching custom exception
        try {
            result1 = sp.getProfitForPeriodThrows("340days", 150700);
        } catch (RevenueCalculationException rce) {
            log.error("RevenueCalculationException caught: {} {}", rce.getMessage(), rce.getCause());
        }
        try {
            result2 = sp.getProfitForPeriodThrows("0", 150700);
        } catch (RevenueCalculationException rce) {
            log.error("RevenueCalculationException caught: {} {}", rce.getMessage(), rce.getCause());
        }
        //case3 - the efficient one
        result1 = sp.getProfitForPeriodEfficient("340days", 150700);
        result2 = sp.getProfitForPeriodEfficient("0", 150700);


    }

}
