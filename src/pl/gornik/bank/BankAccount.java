package pl.gornik.bank;

import java.awt.font.FontRenderContext;

public class BankAccount {
    private String accountNumber;
    private double accountBalance;

    public BankAccount(String accountNumber, double accountBalance) {
        if (accountNumber.length() == 26) this.accountNumber = accountNumber;
        else if (accountNumber.length() < 26) {
            int size = accountNumber.length();
            for (int i=0;i<26-size;i++) {
                accountNumber += "0";
            }
            this.accountNumber = accountNumber;
        }
        if (accountBalance > 0) this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        if (accountBalance > 0) this.accountBalance = accountBalance;

    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public void payCheck(double amount) {
        accountBalance -= amount;
    }

    @Override
    public String toString() {
        return "Numer konta:" + accountNumber  + ", Saldo: " + accountBalance + '}';
    }
}
