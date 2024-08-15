package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateText implements Question<String> {

    private final Target target;
    private final String title;

    public ValidateText(Target target, String title) {
        this.target = target;
        this.title = title;
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.of(title).resolveFor(actor).getText();
    }

    public static ValidateText validateText(Target target, String title) {
        return new ValidateText(target, title);
    }
}
