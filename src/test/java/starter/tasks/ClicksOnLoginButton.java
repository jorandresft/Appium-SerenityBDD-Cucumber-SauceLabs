package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static starter.ui.LoginView.LOGIN_BUTTON;

public class ClicksOnLoginButton implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LOGIN_BUTTON)
        );
    }

    public static ClicksOnLoginButton clicksOnLoginButton() {
        return Tasks.instrumented(ClicksOnLoginButton.class);
    }
}
