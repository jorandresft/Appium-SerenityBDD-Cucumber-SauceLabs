package starter.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginView {

    public static Target USER_NAME = Target.the("Login")
            .locatedBy("//android.widget.EditText[@content-desc='test-Username']");

    public static Target PASSWORD = Target.the("Password")
            .locatedBy("//android.widget.EditText[@content-desc='test-Password']");

    public static Target LOGIN_BUTTON = Target.the("Login button")
            .locatedBy("//android.widget.TextView[@text='LOGIN']");

    public static Target LOGIN_FAILED = Target.the("Login button")
            .locatedBy("//android.widget.TextView[@text='Username and password do not match any user in this service.']");

    public static Target PASSWORD_REQUERED = Target.the("Login button")
            .locatedBy("//android.widget.TextView[@text='Password is required']");
}
