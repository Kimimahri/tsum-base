import constants.enums.Notices;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
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
        user.openRegistrationPage()
                .enterEmailAndPassword("badEmail", "password")
                .clickRegistrationButton()
                .shouldSeeNotices(Collections.singletonList(Notices.BAD_EMAIL.getTitle()));
    }
}