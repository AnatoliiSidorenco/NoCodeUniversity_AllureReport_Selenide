package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {


    private SelenideElement recoverPasswordButtonElement = $(byCssSelector("[type='button']"));

    public void recoverPasswordButton() {
        recoverPasswordButtonElement.shouldBe(visible);
    }
}
