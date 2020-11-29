package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;


@DefaultUrl("http://localhost:9000/login")
@At("#HOST/login")
public class LoginPage extends PageObject {

    @FindBy(className = "login-input")
    private WebElementFacade loginInput;

    @FindBy(className = "pwd-input")
    private WebElementFacade passwordInput;

    @FindBy(css = ".ui-button[type='submit']")
    private WebElementFacade loginButton;

    @FindBy(css = "div.eye-pwd")
    private WebElementFacade showPasswordButton;


    /**
     * Метод ввода email
     *
     * @param email - email
     * @return LoginPage
     */
    public LoginPage inputEmail(String email) {
        loginInput.waitUntilEnabled().sendKeys(email);
        return this;
    }

    /**
     * Метод ввода пароля
     *
     * @param password - пароль
     * @return LoginPage
     */
    public LoginPage inputPassword(String password) {
        passwordInput.waitUntilEnabled().sendKeys(password);
        return this;
    }

    /**
     * Метод нажатия на кнопку авторизации
     *
     * @return LoginPage
     */
    public LoginPage clickLoginButton() {
        loginButton.waitUntilEnabled().click();
        return this;
    }

    /**
     * Метод нажатия на кнопку отображения пароля
     *
     * @return LoginPage
     */
    public LoginPage clickShowPasswordButton() {
        showPasswordButton.waitUntilEnabled().click();
        return this;
    }

    /**
     * Метод получения типа введенного пароля
     *
     * @return тип введенного пароля
     */
    public String getPasswordType() {
        return passwordInput.getAttribute("type");
    }
}
