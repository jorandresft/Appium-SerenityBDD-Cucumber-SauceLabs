package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SendKeys;

import static starter.ui.LoginView.*;

public class FillFieldLogin implements Task {

    private final String user;
    private final String pass;

    public FillFieldLogin(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SendKeys.of(user).into(USER_NAME),
                SendKeys.of(pass).into(PASSWORD)
        );
    }

    public static FillFieldLogin fillFieldLogin(String user, String pass) {
        return Tasks.instrumented(FillFieldLogin.class, user, pass);
    }
}
