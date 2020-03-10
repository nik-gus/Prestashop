import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(E2ETests.class);
        System.out.println("Successful result: " + result.wasSuccessful());
        List<Failure> list = result.getFailures();
        for (Failure f : list) {
            System.out.println("### " + f.getDescription() + " ###" + f.getMessage() + "### TRACE: " +f.getTrimmedTrace());
        }
    }

}

