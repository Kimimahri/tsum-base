package login;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.UserSteps;

import static utility.constants.Authorization.goodEmail;
import static utility.constants.Authorization.goodPassword;


@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed
    WebDriver driver;

    @Steps
    private UserSteps user;

    @Test
    @Title("Авторизация с корректным email и пролем")
    public void loginWithCorrectEmailAndPasswordTest() {
        user.open_login_page()
                .enter_email_and_password_for_login(goodEmail, goodPassword)
                .click_login_button()
                .should_see_email(goodEmail);
    }

    @Test
    @Title("Авторизация с корректным email и отображенным пролем")
    public void loginWithCorrectEmailAndShowedPasswordTest() {
        user.open_login_page()
                .enter_email_and_password_for_login(goodEmail, goodPassword)
                .password_should_not_be_visible()
                .click_show_password_button()
                .password_should_be_visible()
                .click_login_button()
                .should_see_email(goodEmail);
    }
}
