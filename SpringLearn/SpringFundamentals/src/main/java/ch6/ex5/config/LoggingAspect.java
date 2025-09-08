package ch6.ex5.config;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @AfterReturning(value = "@annotation(ch6.ex5.annotations.ToLog)", returning = "returnedValue")
    public void log(Object returnedValue) throws Throwable {

        logger.info("Method executed and returned value: " + returnedValue);

    }
}
