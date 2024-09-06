package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.observer.Subject;
import edu.mum.cs.cs525.labs.skeleton.stretegy.InterestStrategy;

import java.util.Collection;

public interface AccountService extends Subject {
    Account createAccount(String accountNumber, String customerName, InterestStrategy interestStrategy);

    Account getAccount(String accountNumber);

    Collection<Account> getAllAccounts();

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
}
