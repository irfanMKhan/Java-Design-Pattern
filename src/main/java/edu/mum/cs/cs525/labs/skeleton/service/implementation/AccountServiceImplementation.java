package edu.mum.cs.cs525.labs.skeleton.service.implementation;

import edu.mum.cs.cs525.labs.skeleton.model.Account;
import edu.mum.cs.cs525.labs.skeleton.model.dao.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.model.dao.AccountDAOImplementation;
import edu.mum.cs.cs525.labs.skeleton.model.Customer;
import edu.mum.cs.cs525.labs.skeleton.design.pattern.factory.AccountDAOFactory;
import edu.mum.cs.cs525.labs.skeleton.design.pattern.observer.EmailSender;
import edu.mum.cs.cs525.labs.skeleton.design.pattern.observer.ObserverLogger;
import edu.mum.cs.cs525.labs.skeleton.design.pattern.observer.Observer;
import edu.mum.cs.cs525.labs.skeleton.design.pattern.observer.SMSSender;
import edu.mum.cs.cs525.labs.skeleton.design.pattern.stretegy.InterestStrategy;
import edu.mum.cs.cs525.labs.skeleton.service.AccountService;

import java.util.*;

public class AccountServiceImplementation implements AccountService {
    private final List<Observer> observerLists;
    private final AccountDAO accountDAO;

    public AccountServiceImplementation() {
        accountDAO = new AccountDAOImplementation();
        observerLists = new ArrayList<>();
    }

    public AccountServiceImplementation(AccountDAOFactory factory) {
        this.accountDAO = factory.createAccountDAO();
        observerLists = new ArrayList<>();
    }

    public Account createAccount(String accountNumber, String customerName, InterestStrategy interestStrategy) {
        Account account = new Account(accountNumber, interestStrategy);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);

        accountDAO.saveAccount(account);
        updateObserver("CREATE", 0.0d);

        return account;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);

        updateObserver("DEPOSIT", amount);

        accountDAO.updateAccount(account);
    }

    public Account getAccount(String accountNumber) {
        Account account = accountDAO.loadAccount(accountNumber);
        return account;
    }

    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);

        updateObserver("WITHDRAW", amount);

        accountDAO.updateAccount(account);
    }

    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);

        updateObserver("TRANSFER", amount);
    }

    public void registerObserver(Observer observer) {
        this.observerLists.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observerLists.remove(observer);
    }

    public void updateObserver(String purpose, double amount) {
        for (Observer observer : observerLists) {
            if (observer instanceof ObserverLogger)
                observer.update(purpose, amount);
            else if (observer instanceof EmailSender && Objects.equals(purpose, "CREATE"))
                observer.update(purpose, amount);
            else if (observer instanceof SMSSender && !Objects.equals(purpose, "CREATE"))
                observer.update(purpose, amount);
        }
    }
}
