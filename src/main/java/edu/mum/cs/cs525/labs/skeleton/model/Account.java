package edu.mum.cs.cs525.labs.skeleton.model;

import edu.mum.cs.cs525.labs.skeleton.design.pattern.stretegy.InterestStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Account {
    private Customer customer;

    private final InterestStrategy interestStrategy;

    private String accountNumber;

    private final List<AccountEntry> entryList = new ArrayList<AccountEntry>();

    public Account(String accountNumber, InterestStrategy interestStrategy) {
        this.accountNumber = accountNumber;
        this.interestStrategy = interestStrategy;
    }

    public InterestStrategy getInterestStrategy() {
        return interestStrategy;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public double getBalanceWithInterest(double balance) {
        return interestStrategy.getBalanceWithInterest(getBalance());
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
        entryList.add(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
        entryList.add(entry);
    }

    private void addEntry(AccountEntry entry) {
        entryList.add(entry);
    }

    public void transferFunds(Account toAccount, double amount, String description) {
        AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
                toAccount.getCustomer().getName());
        AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
                toAccount.getCustomer().getName());

        entryList.add(fromEntry);

        toAccount.addEntry(toEntry);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<AccountEntry> getEntryList() {
        return entryList;
    }

}
