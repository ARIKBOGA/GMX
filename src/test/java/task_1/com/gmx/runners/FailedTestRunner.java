package task_1.com.gmx.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "rerun:target/rerun.txt",
        },
        features = "@target/rerun.txt",
        glue = "com/gmx/step_definitions"
)

public class FailedTestRunner {
}