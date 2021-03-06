package registration;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.UserSteps;
import utility.enums.Notices;

import java.util.Collections;
import java.util.List;

import static utility.constants.Authorization.*;

@RunWith(SerenityRunner.class)
public class RegistrationTest {

    @Managed
    WebDriver driver;

    @Steps
    private UserSteps user;

    private List<String> incorrect_email = Collections.singletonList(Notices.INCORRECT_EMAIL.getTitle());
    private List<String> short_password = Collections.singletonList(Notices.SHORT_PASSWORD.getTitle());

    @Test
    @WithTag("negative")
    @Title("Регистрация с некорректным email")
    public void registrationWithIncorrectEmailTest() {
        user.open_registration_page()
                .enter_email_and_password_for_registration(badEmail, goodPassword)
                .click_registration_button()
                .should_see_notices(incorrect_email);
    }

    @Test
    @WithTag("negative")
    @Title("Регистрация с паролем менее 8 символов")
    public void registrationWithShortPasswordTest() {
        user.open_registration_page()
                .enter_email_and_password_for_registration(goodEmail, badPassword)
                .click_registration_button()
                .should_see_notices(short_password);
    }
}
