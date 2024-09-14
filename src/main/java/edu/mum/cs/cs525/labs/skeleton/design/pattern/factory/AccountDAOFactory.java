package edu.mum.cs.cs525.labs.skeleton.design.pattern.factory;

import edu.mum.cs.cs525.labs.skeleton.model.dao.AccountDAO;

public interface AccountDAOFactory {
    AccountDAO createAccountDAO();
}
