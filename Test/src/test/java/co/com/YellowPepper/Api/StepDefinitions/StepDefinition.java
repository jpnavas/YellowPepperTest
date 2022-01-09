package co.com.YellowPepper.Api.StepDefinitions;

import co.com.YellowPepper.Api.Questions.CompareStateData;
import co.com.YellowPepper.Api.Tasks.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.util.EnvironmentVariables;

import static jxl.biff.FormatRecord.logger;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinition {

    private EnvironmentVariables environmentVariables;
    public Response request;
    private Actor TheUser= Actor.named("Juan");

    @Given("^the user search with status available$")
    public void theUserSearchWithStatusAvailable() {
        TheUser.attemptsTo(FindByStatusAvailable.StatusAvailable());

    }

    @Then("^the user validate status 200 and response$")
    public void theUserValidateStatusAndResponse() {
        TheUser.should(seeThat(CompareStateData.delservicio(200)));

       // int StatusCode = lastResponse().getStatusCode();
       // assertThat(StatusCode).isEqualTo(200);
        //logger.info(StatusCode);
        //String Code = lastResponse().jsonPath().get("name").toString();
        //logger.info(Code);
        //assertThat(Code).isLessThan("doggie");


        String Status = lastResponse().jsonPath().get("status").toString();
        logger.info(Status);
        assertThat(Status).isLessThan("available");

    }


    @Given("^the user search with status Pending$")
    public void theUserSearchWithStatusPending() {
        TheUser.attemptsTo(
                FindByStatusPending.StatusPending()
        );

    }

    @Then("^The user Validate Response$")
    public void theUserValidateResponse() {
        TheUser.should(seeThat(CompareStateData.delservicio(200)));
        String Status = lastResponse().jsonPath().get("status").toString();
        logger.info(Status);
        assertThat(Status).isLessThan("pending");
    }

    @Given("^the user search with status Sold$")
    public void theUserSearchWithStatusSold() {
       TheUser.attemptsTo(
               FindByStatusSold.StatusSold()
       );
    }

    @Then("^The user Validate Response and status$")
    public void theUserValidateResponseAndStatus() {
        TheUser.should(seeThat(CompareStateData.delservicio(200)));
        String Status = lastResponse().jsonPath().get("status").toString();
        logger.info(Status);
        assertThat(Status).isLessThan("sold");
    }


////////////////////////////////////// POST NEW PET/////////////////////////////////////////////////

    @Given("^the user send a information$")
    public void theUserSendAInformation() {
        TheUser.attemptsTo(NewPet.totheStore());
    }

    @Then("^Validate status and name$")
    public void validateStatusAndName() {
        TheUser.should(seeThat(CompareStateData.delservicio(200)));
        String Status = lastResponse().jsonPath().get("name").toString();
        logger.info(Status);
        assertThat(Status).isEqualTo("Thiago");
    }

///////////////////////////////////// ORDER STORE /////////////////////////////////////////////////


    @Given("^the user send order to the store$")
    public void theUserSendOrderToTheStore() {
        TheUser.attemptsTo(OrderStore.withIdPet());
    }

    @Then("^validate status code and id response$")
    public void validateSatusCodeAndIdResponse() {
        TheUser.should(seeThat(CompareStateData.delservicio(200)));
        String id = lastResponse().jsonPath().get("id").toString();
        logger.info(id);
        assertThat(id).isEqualTo("44");
    }

    @When("^create order and Delete the order$")
    public void deleteTheOrder() {
        TheUser.attemptsTo(DeleteOrder.withId());
    }

    @Then("^the user status an response ok of delete$")
    public void theUserStatusAnResponseOkOfDelete() {
        TheUser.should(seeThat(CompareStateData.delservicio(200)));
        String code = lastResponse().jsonPath().get("code").toString();
        logger.info(code);
        assertThat(code).isEqualTo("200");
    }

/////////////////////////////////// USER OPERATION ////////////////////////////////////////////

    @Given("^Send request with data$")
    public void sendRequestWithData() {
        TheUser.attemptsTo(UserInformation.withInformation());
    }

    @Then("^Validate status code ok$")
    public void validateStatusCodeOk() {
        TheUser.should(seeThat(CompareStateData.delservicio(200)));
    }

    @Given("^Send request with data and send update$")
    public void sendRequestWithDataAndSendUpdate() {
        TheUser.attemptsTo(UpdateUserInformation.withUpdateInformation());
    }

    @Then("^Validate satus and response of update$")
    public void validateSatusAndResponseOfUpdate() {
        TheUser.should(seeThat(CompareStateData.delservicio(200)));

    }

}
