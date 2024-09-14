package edu.mum.cs.cs525.labs.skeleton.design.pattern.command;

import edu.mum.cs.cs525.labs.skeleton.service.AccountService;

public class DepositCommand implements Command {
    private AccountService accountService;
    private String accountNumber;
    private double amount;

    public DepositCommand(AccountService accountService, String accountNumber, double amount) {
        this.accountService = accountService;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        accountService.deposit(accountNumber, amount);
    }

    @Override
    public void undo() {
        accountService.withdraw(accountNumber, amount);
    }
}