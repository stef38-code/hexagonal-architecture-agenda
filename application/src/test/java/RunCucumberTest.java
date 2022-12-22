import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = true,
        features = "classpath:features/acceptances",
        glue = {"step.definitions","step.acceptances"},
        plugin = {"pretty", "junit:build/reports/cucumber/cucumber-junit.xml", "html:build/reports/cucumber/cucumber.html"}
)
public class RunCucumberTest {
}
