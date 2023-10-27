package pl.gornik.bank;

import java.time.LocalTime;

public class TermDeposit {
    private int timeDeposit;
    private double amount;
    private double termPercent;
    private LocalTime startTime;

    public TermDeposit(int timeDeposit, double amount, double termPercent, LocalTime startTime) {
        this.timeDeposit = timeDeposit;
        this.amount = amount;
        this.termPercent = termPercent;
        this.startTime = startTime;
    }

    public double calculateProfit() {
        return amount * (1+termPercent/100*timeDeposit/12);
    }
}
