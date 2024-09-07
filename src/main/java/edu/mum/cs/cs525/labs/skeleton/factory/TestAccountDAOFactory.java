package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.AccountDAOImplementation;

public class TestAccountDAOFactory implements AccountDAOFactory {
    @Override
    public AccountDAO createAccountDAO() {
        return new AccountDAOImplementation();
    }
}
