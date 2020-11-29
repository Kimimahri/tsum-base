package steps;

import net.thucydides.core.annotations.Step;
import pages.BasePage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class UserSteps {

    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private BasePage basePage;

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
     * Шаг ввода email и пароля на странице регистрации
     *
     * @param email    - email
     * @param password - пароль
     * @return UserSteps
     */
    @Step("Вводим email {0} и пароль {1}")
    public UserSteps enter_email_and_password_for_registration(String email, String password) {
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
        registrationPage.clickRegistrationButton();
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

    /**
     * Шаг открытия страницы авторизации
     *
     * @return UserSteps
     */
    @Step("Открываем страницу авторизации")
    public UserSteps open_login_page() {
        loginPage.open();
        return this;
    }

    /**
     * Шаг ввода email и пароля на странице авторизации
     *
     * @param email    - email
     * @param password - пароль
     * @return UserSteps
     */
    @Step("Вводим email {0} и пароль {1}")
    public UserSteps enter_email_and_password_for_login(String email, String password) {
        loginPage.inputEmail(email).inputPassword(password);
        return this;
    }

    /**
     * Шаг нажатия на кнопку отображения пароля
     *
     * @return UserSteps
     */
    @Step("Нажимаем кнопку отображения пароля")
    public UserSteps click_show_password_button() {
        loginPage.clickShowPasswordButton();
        return this;
    }

    /**
     * Шаг проверки видимости введенного пароля
     *
     * @return UserSteps
     */
    @Step("Введенный пароль должен быть не виден")
    public UserSteps password_should_not_be_visible() {
        assertThat("Не совпадают ожидаемый и действительный тип строки пароля",
                loginPage.getPasswordType(), equalTo("password"));
        return this;
    }

    /**
     * Шаг проверки видимости введенного пароля
     *
     * @return UserSteps
     */
    @Step("Введенный пароль должен быть виден")
    public UserSteps password_should_be_visible() {
        assertThat("Не совпадают ожидаемый и действительный тип строки пароля",
                loginPage.getPasswordType(), equalTo("text"));
        return this;
    }

    /**
     * Шаг нажатия на кнопку авторизации
     *
     * @return UserSteps
     */
    @Step("Нажимаем кнопку авторизации")
    public UserSteps click_login_button() {
        loginPage.clickLoginButton();
        return this;
    }


    /**
     * Шаг ожидания отображения email
     *
     * @return UserSteps
     */
    @Step("Должен отображаться email {0}")
    public UserSteps should_see_email(String email) {
        assertThat("Не совпадают ожидаемый и действительный email",
                basePage.getEmail(), equalTo(email));
        return this;
    }
}
