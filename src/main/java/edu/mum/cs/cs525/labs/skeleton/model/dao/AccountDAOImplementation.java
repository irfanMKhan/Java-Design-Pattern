package edu.mum.cs.cs525.labs.skeleton.model.dao;

import edu.mum.cs.cs525.labs.skeleton.model.Account;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDAOImplementation implements AccountDAO {
	Collection<Account> accountList = new ArrayList<Account>();

	public void saveAccount(Account account) {
		accountList.add(account); // add the new
	}

	public void updateAccount(Account account) {
		Account accountExist = loadAccount(account.getAccountNumber());
		if (accountExist != null) {
			accountList.remove(accountExist); // remove the old
			accountList.add(account); // add the new
		}

	}

	public Account loadAccount(String accountNumber) {
		for (Account account : accountList) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}

	public Collection<Account> getAccounts() {
		return accountList;
	}

}
