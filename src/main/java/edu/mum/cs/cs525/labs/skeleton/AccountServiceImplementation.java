package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.command.Command;
import edu.mum.cs.cs525.labs.skeleton.command.DepositCommand;
import edu.mum.cs.cs525.labs.skeleton.command.TransferFundCommand;
import edu.mum.cs.cs525.labs.skeleton.command.WithdrawCommand;
import edu.mum.cs.cs525.labs.skeleton.factory.AccountDAOFactory;
import edu.mum.cs.cs525.labs.skeleton.observer.EmailSender;
import edu.mum.cs.cs525.labs.skeleton.observer.Logger;
import edu.mum.cs.cs525.labs.skeleton.observer.Observer;
import edu.mum.cs.cs525.labs.skeleton.observer.SMSSender;
import edu.mum.cs.cs525.labs.skeleton.stretegy.InterestStrategy;

import java.util.*;

public class AccountServiceImplementation implements AccountService {
    private final List<Observer> observerLists;
    private final AccountDAO accountDAO;

    private final Stack<Command> commandHistory = new Stack<>();
    private final Stack<Command> redoHistory = new Stack<>();

    public AccountServiceImplementation() {
        accountDAO = new AccountDAOImplementation();
        observerLists = new ArrayList<>();
    }

    public AccountServiceImplementation(AccountDAOFactory factory) {
        this.accountDAO = factory.createAccountDAO();
        observerLists = new ArrayList<>();
    }

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
        redoHistory.clear();
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
            redoHistory.push(lastCommand);
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            Command lastCommand = redoHistory.pop();
            lastCommand.execute();
            commandHistory.push(lastCommand);
        }
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

        Command command = new DepositCommand(this, accountNumber, amount);
        command.execute();
        commandHistory.push(command);
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

        Command command = new WithdrawCommand(this, accountNumber, amount);
        command.execute();
        commandHistory.push(command);
    }

    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);

        updateObserver("TRANSFER", amount);

        Command command = new TransferFundCommand(this, fromAccountNumber, toAccountNumber, amount);
        command.execute();
        commandHistory.push(command);
    }

    public void registerObserver(Observer observer) {
        this.observerLists.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observerLists.remove(observer);
    }

    public void updateObserver(String purpose, double amount) {
        for (Observer observer : observerLists) {
            if (observer instanceof Logger)
                observer.update(purpose, amount);
            else if (observer instanceof EmailSender && Objects.equals(purpose, "CREATE"))
                observer.update(purpose, amount);
            else if (observer instanceof SMSSender && !Objects.equals(purpose, "CREATE"))
                observer.update(purpose, amount);
        }
    }
}
