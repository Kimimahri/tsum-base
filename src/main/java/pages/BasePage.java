package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;


@DefaultUrl("http://localhost:9000")
@At("#HOST")
public class BasePage extends PageObject {

    @FindBy(css = "a[href='/personal/orders/']")
    private WebElementFacade email;

    /**
     * Метод получения email
     *
     * @return email
     */
    public String getEmail() {
        return email.waitUntilVisible().getText();
    }
}
