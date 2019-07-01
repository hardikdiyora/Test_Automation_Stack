package task.tests.api;

import org.testng.annotations.BeforeClass;
import task.tests.TestBase;

public class APITestBase extends TestBase {
    String baseURI;

    @BeforeClass
    public void setUp(){
        baseURI = "http://restcountries.eu";
    }
}
