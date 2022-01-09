package co.com.YellowPepper.Api.Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/Feature/GetFindByStatus.feature",
        glue = "co.com.YellowPepper.Api.StepDefinitions",
        //tags = "@FindByStatusSold",
        snippets = SnippetType.CAMELCASE)
public class FindByStatus {
}
