package edu.mum.cs.cs525.labs.skeleton.design.pattern.adapter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerAdapter implements ILogger {
    private static final Logger logger = LogManager.getLogger(LoggerAdapter.class);

    @Override
    public void log(LoggerLevel loggerLevel, String message) {
        switch (loggerLevel) {
            case DEBUG:
                logger.debug(message);
                break;
            case ERROR:
                logger.error(message);
                break;
            case FATAL:
                logger.fatal(message);
                break;
            case INFO:
                logger.info(message);
                break;
            case TRACE:
                logger.trace(message);
                break;
            case WARNING:
                logger.warn(message);
                break;
        }
    }
}
