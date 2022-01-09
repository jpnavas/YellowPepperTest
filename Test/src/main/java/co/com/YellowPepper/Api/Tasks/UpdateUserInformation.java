package co.com.YellowPepper.Api.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class UpdateUserInformation implements Task {
    private Actor TheUser= Actor.named("Juan");
    private EnvironmentVariables environmentVariables;

    @Override
    public <T extends Actor> void performAs(T actor) {
        TheUser.whoCan(CallAnApi.at(environmentVariables.getProperty("UrlBase")));
        TheUser.attemptsTo(
                Post.to("/user/createWithArray")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("[{\"id\": 0,\"username\": \"Juan\",\"firstName\": \"juan\",\"lastName\": \"navas\",\"email\": \"assdf@hshgss.com\",\"password\": \"1234\",\"phone\": \"315287528\",\"userStatus\": 0}]")
                        )
        );
        TheUser.should(
                seeThatResponse("Create ok" ,
                        response -> response.statusCode(200)
                )
        );

        TheUser.attemptsTo(
                Put.to("/user/Juan")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"id\": 0,\"username\": \"pedro15\",\"firstName\": \"pedro\",\"lastName\": \"Messi\",\"email\": \"asdasfd@asdfasd.com\",\"password\": \"123456\",\"phone\": \"321588522\",\"userStatus\": 0}")
                        )
        );

    }
    public static Performable withUpdateInformation(){
        return instrumented(UpdateUserInformation.class);
    }
}
