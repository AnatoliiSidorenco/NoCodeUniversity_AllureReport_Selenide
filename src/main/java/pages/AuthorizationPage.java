package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;

public class AuthorizationPage {


    private SelenideElement emailInputSignInElement = $(byId("sw-form-capture-email-input"));
    private SelenideElement passwordInputSignInElement = $(byId("sw-form-password-input"));
    private SelenideElement eyeIconPasswordSignInForm = $x("(//i)[1]");
    private SelenideElement forgotPasswordLinkElement = $(byCssSelector("a[href='/forgot-password']"));
    private SelenideElement signInButtonSignInFormElement = $(byId("sw-sign-in-submit-btn"));
    private SelenideElement signUpButtonSignInFormElement = $(byId("sw-go-to-sign-up-btn"));
    private SelenideElement errorMessageSignInElement = $(byCssSelector("[class='error-message login-error d-block']"));


    public void fillInputEmailSignInForm(User user) {
        emailInputSignInElement.shouldBe(visible).setValue(user.getEmail());
    }

    public void fillInputPasswordSignInForm(User user) {
        passwordInputSignInElement.setValue(user.getPassword());
    }

    public void clickSignInButtonInSignInForm() {
        signInButtonSignInFormElement.click();
    }

    public void clickSignUpButtonInSignInForm() {
        signUpButtonSignInFormElement.click();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLinkElement.click();
    }

    public void clickOnEyeInPasswordFieldSignInForm() {
        eyeIconPasswordSignInForm.click();
    }

    public void passwordCheckMaskedSignInForm() {
        passwordInputSignInElement.shouldHave(attributeMatching("type", ".*password.*"));
    }

    public void passwordCheckNotMaskedSignInForm() {
        passwordInputSignInElement.shouldHave(attributeMatching("type", ".*text.*"));
    }

    public void isCopyingDisabledSignInForm(String password) throws IOException, UnsupportedFlavorException {

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(""), null);

        passwordInputSignInElement.setValue(password);
        passwordInputSignInElement.setValue(Keys.chord(Keys.CONTROL, "c"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Transferable contents = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        String copiedText = (String) contents.getTransferData(DataFlavor.stringFlavor);
        assertTrue(copiedText == null || copiedText.isEmpty());
    }

    public void isCuttingDisabledSignInForm(String password) throws IOException, UnsupportedFlavorException {

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(""), null);
        passwordInputSignInElement.setValue(password);
        passwordInputSignInElement.setValue(Keys.CONTROL + "x");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Transferable contents = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        String carvedText = (String) contents.getTransferData(DataFlavor.stringFlavor);

        assertTrue(carvedText == null || carvedText.isEmpty());
    }


    public void errorMessageSignInForm() {
        errorMessageSignInElement.shouldBe(visible);

        errorMessageSignInElement.shouldHave(text("Invalid email or password"));
    }


}
