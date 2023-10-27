package pl.gornik.bank;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount("12345678901234567890123456",5000);
        System.out.println(bankAccount);

        System.out.println("Twoj numer konta :\n"+bankAccount.getAccountNumber());

        bankAccount.setAccountBalance(-5500);

        System.out.println(bankAccount.getAccountBalance());

        bankAccount.deposit(500);
        System.out.println("Saldo po wplacie: "+bankAccount.getAccountBalance());

        bankAccount.payCheck(1000);
        System.out.println("Saldo po wyplacie: " +bankAccount.getAccountBalance());

        int timeDeposit = 1;
        double amount = 2000;
        double termPercent= 10;
        LocalTime startTime = LocalTime.now();
//        System.out.println(startTime);
        LocalTime endTime = startTime.plusMinutes(timeDeposit);
//        System.out.println(endTime);
        LocalTime timeNow = LocalTime.now();

        //zalozenie lokaty
        TermDeposit termDeposit = new TermDeposit(timeDeposit,amount,termPercent,startTime);
        //odjecie z konta
        bankAccount.setAccountBalance(bankAccount.getAccountBalance()-amount);

        String end ="";
        while (!end.equals("stop")) {
            System.out.printf("Poczekaj %d i potem wpisz stop: \n",timeDeposit);
            end = scanner.nextLine();
        }


        if (timeNow.isBefore(endTime)) {
            System.out.println("Lokata trwa");
        }
        else {
            bankAccount.setAccountBalance(
                    bankAccount.getAccountBalance()+ termDeposit.calculateProfit());
        }

        //wypisanie stanu po wplaceniu na lokate
        System.out.printf("Stan konta po załozeniu lokaty %.2f",bankAccount.getAccountBalance());
        System.out.println("");
        //obliczenie lokaty

        //wypisanie profitu z lokaty
        System.out.printf("Saldo z lokatą terminowa: %.2f",bankAccount.getAccountBalance());
    }
}