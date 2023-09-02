package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class StartPage {
    private SelenideElement headerSignInElement = $x("(//a[@data-element='button'])[1]");

    public void clickHeaderSignInButton() {
        headerSignInElement.shouldBe(visible);
        headerSignInElement.click();
    }
}
