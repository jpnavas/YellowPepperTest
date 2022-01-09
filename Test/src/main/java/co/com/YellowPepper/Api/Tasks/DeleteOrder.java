package co.com.YellowPepper.Api.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.util.EnvironmentVariables;

import static jxl.biff.FormatRecord.logger;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class DeleteOrder implements Task {

    private Actor TheUser= Actor.named("Juan");
    private EnvironmentVariables environmentVariables;

    @Override
    public <T extends Actor> void performAs(T actor) {
        TheUser.whoCan(CallAnApi.at(environmentVariables.getProperty("UrlBase")));
        TheUser.attemptsTo(
                Post.to("/store/order")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"id\":55,\"petId\": 9,\"quantity\": 1,\"shipDate\": \"2022-01-06T18:06:51.510Z\",\"status\": \"placed\",\"complete\": true}")
                        )
        );
        String id = lastResponse().jsonPath().get("id").toString();
        logger.info(id);
        TheUser.attemptsTo(
                Delete.from(("/store/order/"+id))
        );

        TheUser.should(
                seeThatResponse("The order was delete" ,
                        response -> response.statusCode(200)
                                )
        );
    }

    public static Performable withId(){
        return instrumented(DeleteOrder.class);
    }
}
