package steps;

import net.thucydides.core.annotations.Step;
import pages.RegistrationPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class UserSteps {

    private RegistrationPage registrationPage;

    /**
     * Шаг открытия страницы регистрации
     *
     * @return UserSteps
     */
    @Step("Открываем страницу регистрации")
    public UserSteps open_registration_page() {
        registrationPage.open();
        return this;
    }

    /**
     * Шаг ввода email и пароля
     *
     * @param email    - email
     * @param password - пароль
     * @return UserSteps
     */
    @Step("Вводим email {0} и пароль {1}")
    public UserSteps enter_email_and_password(String email, String password) {
        registrationPage.inputEmail(email).inputPassword(password);
        return this;
    }

    /**
     * Шаг нажатия на кнопку регистрации
     *
     * @return UserSteps
     */
    @Step("Нажимаем кнопку регистрации")
    public UserSteps click_registration_button() {
        registrationPage.clickTheRegistrationButton();
        return this;
    }

    /**
     * Шаг ожидания отображения и сравнения текстов уведомлений
     *
     * @param notices - ожидаемые уведомления
     * @return UserSteps
     */
    @Step("Должны отображаться умедомления: {0}")
    public UserSteps should_see_notices(List<String> notices) {
        assertThat("Не совпадают ожидаемый и действительный списки уведомлений",
                registrationPage.getNotices(), equalTo(notices));
        return this;
    }
}
