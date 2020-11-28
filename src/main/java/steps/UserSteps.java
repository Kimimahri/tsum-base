package steps;

import net.thucydides.core.annotations.Step;
import pages.RegistrationPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserSteps {

    private RegistrationPage registrationPage;

    @Step("Open the registration page")
    public UserSteps open_registration_page(){
        registrationPage.open();
        return this;
    }

    @Step("Enter email {0} and password {1}")
    public UserSteps enter_email_and_password(String email, String password){
        registrationPage.inputEmail(email).inputPassword(password);
        return this;
    }

    @Step("Click the registration button")
    public UserSteps click_registration_button(){
        registrationPage.clickTheRegistrationButton();
        return this;
    }

    @Step("Should see {0} notice(s)")
    public void should_see_notices(List<String> notices){
        assertThat(registrationPage.getNotices(), equalTo(notices));
    }

}
