package task.tests;

import logger.TALogger;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeClass;

public class TestBase {
    protected Logger Log;

    @BeforeClass
    public void openBrowser(){
        //Load the Logger class configuration using spring framework.
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TALogger.class);
        TALogger taLogger = context.getBean(TALogger.class);

        // Get Logger object which is used by sub classes.
        Log = taLogger.getLogger(getClass());
    }
}
