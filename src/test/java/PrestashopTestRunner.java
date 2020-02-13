import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.jws.WebResult;
import java.util.List;

public class PrestashopTestRunner {

    public static void main(String[] args) {
        PrestashopTest.startup();
        PrestashopTest.signIn();
        //PrestashopTest.cleanup();



//        Result result = JUnitCore.runClasses(PrestashopTest.class);
//            System.out.println("Result: " +result.wasSuccessful());
//            List<Failure> list = result.getFailures();
//            for (Failure f : list) {
//                System.out.println(f.getDescription());
//            }

    }
}
