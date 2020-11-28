package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;


@DefaultUrl("https://www.tsum.ru/registration")
public class RegistrationPage extends BasePage {
    private int timeout = 5;
    private String noticesCss = "notice span.ng-star-inserted";

    @FindBy(css = "input[formcontrolname='email'].ui-input")
    private WebElementFacade emailInput;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElementFacade passwordInput;

    @FindBy(css = "button[type='submit'].ui-button")
    private WebElementFacade registrationButton;

    public RegistrationPage inputEmail(String email) {
        emailInput.withTimeoutOf(Duration.ofSeconds(timeout)).waitUntilEnabled().sendKeys(email);
        return this;
    }

    public RegistrationPage inputPassword(String password) {
        passwordInput.withTimeoutOf(Duration.ofSeconds(timeout)).waitUntilEnabled().sendKeys(password);
        return this;
    }

    public RegistrationPage clickTheRegistrationButton() {
        registrationButton.withTimeoutOf(Duration.ofSeconds(timeout)).waitUntilEnabled().click();
        return this;
    }

    public List<String> getNotices() {
        withTimeoutOf(Duration.ofSeconds(timeout)).waitForPresenceOf(By.cssSelector(noticesCss));
        return findAll(noticesCss).texts();
    }
}
