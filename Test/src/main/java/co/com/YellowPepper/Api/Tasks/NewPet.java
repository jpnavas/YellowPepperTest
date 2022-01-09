package co.com.YellowPepper.Api.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class NewPet implements Task {

    private Actor TheUser= Actor.named("Juan");
    private EnvironmentVariables environmentVariables;

    @Override
    public <T extends Actor> void performAs(T actor) {
        TheUser.whoCan(CallAnApi.at(environmentVariables.getProperty("UrlBase")));
        TheUser.attemptsTo(
                Post.to("/pet")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"id\": 5231,\"category\": {\"id\": 0,\"name\": \"thiago\"},\"name\": \"Thiago\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 0,\"name\": \"Thiago\"}],\"status\": \"available\"}")
                        )
        );

        TheUser.should(
                seeThatResponse("ok",
                        response -> response.statusCode(200))
        );
    }

    public static Performable totheStore(){
        return instrumented(NewPet.class);
    }
}
