package steps;

import net.thucydides.core.annotations.Step;
import pages.RegistrationPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserSteps {

    private RegistrationPage registrationPage;

    @Step("Open the registration page")
    public UserSteps openRegistrationPage(){
        registrationPage.open();
        return this;
    }

    @Step("Enter email {0} and password {1}")
    public UserSteps enterEmailAndPassword(String email, String password){
        registrationPage.inputEmail(email).inputPassword(password);
        return this;
    }

    @Step("Click the registration button")
    public UserSteps clickRegistrationButton(){
        registrationPage.clickTheRegistrationButton();
        return this;
    }

    @Step("Should see {0} notice(s)")
    public UserSteps shouldSeeNotices(List<String> notices){
        assertEquals(registrationPage.getNotices(), notices, "Can not see expected notices");
        return this;
    }

}
