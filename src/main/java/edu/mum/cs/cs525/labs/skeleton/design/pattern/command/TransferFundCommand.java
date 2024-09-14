package edu.mum.cs.cs525.labs.skeleton.design.pattern.command;

import edu.mum.cs.cs525.labs.skeleton.service.AccountService;

public class TransferFundCommand implements Command {
    private AccountService accountService;
    private String fromAccountNumber;
    private String toAccountNumber;
    private double amount;

    public TransferFundCommand(AccountService accountService, String fromAccountNumber, String toAccountNumber, double amount) {
        this.accountService = accountService;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        accountService.transferFunds(fromAccountNumber, toAccountNumber, amount, "Transfer");
    }

    @Override
    public void undo() {
        accountService.transferFunds(toAccountNumber, fromAccountNumber, amount, "Reverse Transfer");
    }
}
