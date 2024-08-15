package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.questions.ValidateText;
import starter.tasks.ClicksOnLoginButton;
import starter.tasks.FillFieldLogin;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static starter.ui.LoginSuccessfulView.TITLE_PRODUCTS;
import static starter.ui.LoginView.LOGIN_FAILED;
import static starter.ui.LoginView.PASSWORD_REQUERED;

public class LogInStepDefinitions {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("The {string} send his credentials user {string} and password {string}")
    public void theUserSendHisCredentialsUserAndPassword(String actor, String user, String pass) {
        theActorCalled(actor).attemptsTo(
                FillFieldLogin.fillFieldLogin(user, pass)
        );
    }

    @When("He clicks on the login button")
    public void heClicksOnLoginButton() {
        theActorCalled("user").attemptsTo(
                ClicksOnLoginButton.clicksOnLoginButton()
        );
    }

    @Then("He should see the title {string} with login is successful")
    public void heShouldSeeTheTitleloginSuccessful(String title) {
        theActorInTheSpotlight().should(
                seeThat("The title ", ValidateText.validateText(TITLE_PRODUCTS, title), equalTo(title))
        );
    }

    @Then("He should see the title {string}")
    public void heShouldSeeTheTitle(String title) {
        theActorInTheSpotlight().should(
                seeThat("The title ", ValidateText.validateText(LOGIN_FAILED, title), equalTo(title))
        );
    }

    @Then("He should see the title {string} with password it is missing")
    public void heShouldSeeTheTitlePasswordMissing(String title) {
        theActorInTheSpotlight().should(
                seeThat("The title ", ValidateText.validateText(PASSWORD_REQUERED, title), equalTo(title))
        );
    }
}
