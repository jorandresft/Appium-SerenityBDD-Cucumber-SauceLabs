package starter.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginSuccessfulView {

    public static Target TITLE_PRODUCTS = Target.the("Welcome text")
            .locatedBy("//android.widget.TextView[@text='PRODUCTS']");
}
