package logTest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2 {

    private static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info("a test message");
        LOGGER.warn("a test message-warn");
    }
}