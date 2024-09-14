package edu.mum.cs.cs525.labs.skeleton.design.pattern.factory;

import edu.mum.cs.cs525.labs.skeleton.model.dao.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.model.dao.AccountDAOImplementation;

public class ProductionAccountDAOFactory implements AccountDAOFactory {
    @Override
    public AccountDAO createAccountDAO() {
        return new AccountDAOImplementation();
    }
}
