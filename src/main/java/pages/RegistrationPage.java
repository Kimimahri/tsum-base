package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;


@DefaultUrl("https://www.tsum.ru/registration")
public class RegistrationPage extends BasePage {
    private String noticesCssLocator = "notice span.ng-star-inserted";

    @FindBy(css = "input[formcontrolname='email'].ui-input")
    private WebElementFacade emailInput;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElementFacade passwordInput;

    @FindBy(css = "button[type='submit'].ui-button")
    private WebElementFacade registrationButton;

    /**
     * Метод ввода email
     *
     * @param email - email
     * @return RegistrationPage
     */
    public RegistrationPage inputEmail(String email) {
        emailInput.waitUntilEnabled().sendKeys(email);
        return this;
    }

    /**
     * Метод ввода пароля
     *
     * @param password - пароль
     * @return RegistrationPage
     */
    public RegistrationPage inputPassword(String password) {
        passwordInput.waitUntilEnabled().sendKeys(password);
        return this;
    }

    /**
     * Метод нажатия кнопки регистрации
     *
     * @return RegistrationPage
     */
    public RegistrationPage clickTheRegistrationButton() {
        registrationButton.waitUntilEnabled().click();
        return this;
    }

    /**
     * Метод получение списка уведомлений
     *
     * @return список текстов уведомлений
     */
    public List<String> getNotices() {
        waitForRenderedElements(By.cssSelector(noticesCssLocator));
        return findAll(noticesCssLocator).texts();
    }
}
