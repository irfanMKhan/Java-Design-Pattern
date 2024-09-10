package edu.mum.cs.cs525.labs.skeleton.observer;

import edu.mum.cs.cs525.labs.skeleton.adapter.ILogger;
import edu.mum.cs.cs525.labs.skeleton.adapter.LoggerAdapter;
import edu.mum.cs.cs525.labs.skeleton.adapter.LoggerLevel;

public class ObserverLogger implements Observer {

    public void update(String purpose, double amount) {
        System.out.println("Logging for the purpose of : " + purpose + "; amount : " + amount);

        ILogger logger = new LoggerAdapter();
        logger.log(LoggerLevel.INFO, "Logging for the purpose of : " + purpose + "; amount : " + amount);
    }

}
