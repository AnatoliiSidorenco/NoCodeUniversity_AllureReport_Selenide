package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    public SelenideElement signUpFormHeadingElement = $x("//h2");
    public SelenideElement signUpFormElement = $x("//div[@id='signup']");


    public void signUpFormIsVisible() {
        signUpFormElement.shouldBe(visible);
        signUpFormHeadingElement.shouldHave(text("Sign Up"));
    }


}
