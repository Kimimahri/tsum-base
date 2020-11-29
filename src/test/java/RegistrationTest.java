import constants.enums.Notices;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.UserSteps;

import java.util.Collections;
import java.util.List;

@RunWith(SerenityRunner.class)
public class RegistrationTest {

    @Managed
    WebDriver driver;

    @Steps
    private UserSteps user;

    private List<String> bad_email = Collections.singletonList(Notices.INCORRECT_EMAIL.getTitle());
    private List<String> short_password = Collections.singletonList(Notices.SHORT_PASSWORD.getTitle());

    @Test
    @Title("Регистрация с некорректным email")
    public void registrationWithIncorrectEmailTest() {
        user.open_registration_page()
                .enter_email_and_password("badEmail", "password")
                .click_registration_button()
                .should_see_notices(bad_email);
    }

    @Test
    @Title("Регистрация с паролем менее 8 символов")
    public void registrationWithShortPasswordTest() {
        user.open_registration_page()
                .enter_email_and_password("goodtestemail@testemail.com", "pswrd")
                .click_registration_button()
                .should_see_notices(short_password);
    }
}
