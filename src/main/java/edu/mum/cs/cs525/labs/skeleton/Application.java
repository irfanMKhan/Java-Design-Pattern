package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.command.*;
import edu.mum.cs.cs525.labs.skeleton.decorator.P1PromotionDecorator;
import edu.mum.cs.cs525.labs.skeleton.decorator.P2PromotionDecorator;
import edu.mum.cs.cs525.labs.skeleton.decorator.P3PromotionDecorator;
import edu.mum.cs.cs525.labs.skeleton.factory.AccountDAOFactory;
import edu.mum.cs.cs525.labs.skeleton.factory.ProductionAccountDAOFactory;
import edu.mum.cs.cs525.labs.skeleton.observer.EmailSender;
import edu.mum.cs.cs525.labs.skeleton.observer.ObserverLogger;
import edu.mum.cs.cs525.labs.skeleton.observer.SMSSender;
import edu.mum.cs.cs525.labs.skeleton.stretegy.CheckingInterestStrategy;
import edu.mum.cs.cs525.labs.skeleton.stretegy.InterestStrategy;
import edu.mum.cs.cs525.labs.skeleton.stretegy.SavingInterestStrategy;

public class Application {
    public static void main(String[] args) {

        AccountDAOFactory factory = new ProductionAccountDAOFactory();

        AccountService accountService = new AccountServiceImplementation(factory);

        accountService.registerObserver(new EmailSender());
        accountService.registerObserver(new SMSSender());
        accountService.registerObserver(new ObserverLogger());

        Invoker invoke = new Invoker();

        // create 2 accounts;
        accountService.createAccount("1263862", "Frank Brown", new SavingInterestStrategy());
        accountService.createAccount("4253892", "John Doe", new CheckingInterestStrategy());

        // use account 1;
        Command command = new DepositCommand(accountService, "1263862", 240);
        invoke.executeCommand(command);

        command = new DepositCommand(accountService, "1263862", 529);
        invoke.executeCommand(command);

        command = new WithdrawCommand(accountService, "1263862", 230);
        invoke.executeCommand(command);

        // use account 2;
        command = new DepositCommand(accountService, "4253892", 12450);
        invoke.executeCommand(command);

        command = new TransferFundCommand(accountService, "4253892","1263862", 100);
        invoke.executeCommand(command);

        // show balances
        for (Account account : accountService.getAllAccounts()) {
            Customer customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountNumber());
            System.out.println("Account Holder: " + customer.getName());

            System.out.println("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");

            for (AccountEntry entry : account.getEntryList()) {
                System.out.printf("%30s%30s%20.2f\n",
                        entry.getDate().toString(),
                        entry.getDescription(),
                        entry.getAmount());
            }

            System.out.println("----------------------------------------" + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n", "", "Current Balance:", account.getBalance());
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance with interest:", account.getBalanceWithInterest(account.getBalance()));

            InterestStrategy checkingWithP1 = new P1PromotionDecorator(account.getInterestStrategy());

            System.out.printf("%30s%30s%20.2f\n", "", "Without P1 Promotion Interest:", account.getBalance());
            System.out.printf("%30s%30s%20.2f\n", "", "With P1 Promotion Interest:", checkingWithP1.getBalanceWithInterest(account.getBalance()));

            InterestStrategy checkingWithP2 = new P2PromotionDecorator(account.getInterestStrategy());

            System.out.printf("%30s%30s%20.2f\n", "", "Without P2 Promotion Interest:", account.getBalance());
            System.out.printf("%30s%30s%20.2f\n", "", "With P2 Promotion Interest:", checkingWithP2.getBalanceWithInterest(account.getBalance()));

            InterestStrategy checkingWithP3 = new P3PromotionDecorator(account.getInterestStrategy());

            System.out.printf("%30s%30s%20.2f\n", "", "Without P3 Promotion Interest:", account.getBalance());
            System.out.printf("%30s%30s%20.2f\n", "", "With P3 Promotion Interest:", checkingWithP3.getBalanceWithInterest(account.getBalance()));

        }
    }

}
