package com.lecture14.homework;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class SoleProprietor extends Company {
    protected String founderName;
    protected double originalFunds;
    protected double currentFunds;

    public SoleProprietor(String name, String dateEstablished, String identifier) {
        super(name, dateEstablished, identifier);
    }

    public SoleProprietor(String name, String dateEstablished, String identifier, String founderName,
                          double originalFunds, double currentFunds) {
        super(name, dateEstablished, identifier);
        this.founderName = founderName;
        this.originalFunds = originalFunds;
        this.currentFunds = currentFunds;

    }

    public double calculateProfit() {
        return currentFunds - originalFunds;
    }

    //should this return double since we're returning a fraction?
    public int getProfitForPeriod(String calculationPeriodInDays, int revenueForPeriod) {

        try {
            int numDays = Integer.parseInt(calculationPeriodInDays);
            return revenueForPeriod / numDays;
        } catch (NumberFormatException nfe) {
            log.error("Invalid parameter calculationPeriodInDays supplied {}", nfe.getMessage());
        } catch (ArithmeticException ae) {
            log.error("Invalid parameter revenueForPeriod supplied {} ", ae.getMessage());
        }
        return -1;
    }

    public int getProfitForPeriodThrows(String calculationPeriodInDays, int revenueForPeriod)
            throws RevenueCalculationException {

        try {
            int numDays = Integer.parseInt(calculationPeriodInDays);
            return revenueForPeriod / numDays;
        } catch (NumberFormatException nfe) {
            throw new RevenueCalculationException(nfe.getMessage());
        } catch (ArithmeticException ae) {
            throw new RevenueCalculationException(ae.getMessage(), ae);
        }
    }

    public int getProfitForPeriodEfficient(String calculationPeriodInDays, int revenueForPeriod) {

        if (calculationPeriodInDays != null && calculationPeriodInDays.matches("[0-9]+(,[0-9]+)*,?")) {
            int numDays = Integer.parseInt(calculationPeriodInDays);
            if (numDays != 0) {
                return revenueForPeriod / numDays;
            }
        }
        log.error("Number of days is 0 or can not be converted to number!");
        return -1;
    }

}