package co.com.YellowPepper.Api.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UserInformation implements Task {

    private Actor TheUser= Actor.named("Juan");
    private EnvironmentVariables environmentVariables;

    @Override
    public <T extends Actor> void performAs(T actor) {
        TheUser.whoCan(CallAnApi.at(environmentVariables.getProperty("UrlBase")));
        TheUser.attemptsTo(
                Post.to("/user/createWithArray")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("[{\"id\": 0,\"username\": \"Juan93\",\"firstName\": \"juan\",\"lastName\": \"navas\",\"email\": \"assdf@hshgss.com\",\"password\": \"1234\",\"phone\": \"315287528\",\"userStatus\": 0}]")
                        )
        );
    }
    public static Performable withInformation(){
        return instrumented(UserInformation.class);
    }
}
