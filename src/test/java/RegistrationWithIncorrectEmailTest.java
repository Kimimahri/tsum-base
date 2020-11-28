import constants.enums.Notices;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.UserSteps;

import java.util.Collections;

@RunWith(SerenityRunner.class)
public class RegistrationWithIncorrectEmailTest {

    @Managed
    WebDriver driver;

    @Steps
    private UserSteps user;

    @Test
    public void registrationWithIncorrectEmailTest() {
        user.open_registration_page()
                .enter_email_and_password("badEmail", "password")
                .click_registration_button()
                .should_see_notices(Collections.singletonList(Notices.SHORT_PASSWORD.getTitle()));
    }
}