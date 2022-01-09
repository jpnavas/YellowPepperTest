package co.com.YellowPepper.Api.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class FindByStatusAvailable implements Task {

    private Actor TheUser= Actor.named("Juan");
    private EnvironmentVariables environmentVariables;

    @Override
    public <T extends Actor> void performAs(T actor) {

        TheUser.whoCan(CallAnApi.at(environmentVariables.getProperty("UrlBase")));
        TheUser.attemptsTo(
                Get.resource("/pet/findByStatus?status=available")
        );
        TheUser.should(
                seeThatResponse("Status 200 ok" ,
                        response -> response.statusCode(200)

                )
        );
    }
    public static Performable StatusAvailable(){
        return instrumented(FindByStatusAvailable.class);
    }
}
