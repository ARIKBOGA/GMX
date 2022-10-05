package task_1.com.gmx.step_definitions;

import task_1.com.gmx.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks {

    @After
    public void teardownScenario(Scenario scenario) throws IOException {

        // Take a screenshot if the scenario fails
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            //File screenshotFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            //Files.move(screenshotFile, new File("src/test/resources/screenshots/" + scenario.getName() + ".png"));
        }
        Driver.closeDriver();
    }
}