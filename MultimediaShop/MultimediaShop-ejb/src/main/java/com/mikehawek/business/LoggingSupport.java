package com.mikehawek.business;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingSupport {
    private static final Logger LOGGER = Logger.getLogger( LoggingSupport.class.getName() );

    public static void logTimeToConsole(String msg) {
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.WARNING);
        LOGGER.addHandler(ch);
        LOGGER.warning(msg + ": " + System.nanoTime());
    }
}
