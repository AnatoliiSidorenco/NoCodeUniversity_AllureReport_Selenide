package tests.e2e;

import org.junit.Test;
import tests.BaseTest;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class AuthorizationPositiveTest extends BaseTest {

    @Test
    public void successAuthorizationAsTeacherTest() {
        startPage.clickHeaderSignInButton();
        authorizationPage.fillInputEmailSignInForm(validTeacher);
        authorizationPage.fillInputPasswordSignInForm(validTeacher);
        authorizationPage.clickSignInButtonInSignInForm();
        homePage.getTextForTeacher();
    }

    @Test
    public void successAuthorizationAsStudentTest() {
        startPage.clickHeaderSignInButton();
        authorizationPage.fillInputEmailSignInForm(validStudent);
        authorizationPage.fillInputPasswordSignInForm(validStudent);
        authorizationPage.clickSignInButtonInSignInForm();
        homePage.getTextForStudent();
    }

    @Test
    public void checkForgotPasswordTest() {
        startPage.clickHeaderSignInButton();
        authorizationPage.clickForgotPasswordLink();
        forgotPasswordPage.recoverPasswordButton();
    }

    @Test
    public void passwordInvisibilitySignInFormTest() {
        startPage.clickHeaderSignInButton();
        authorizationPage.fillInputPasswordSignInForm(validStudent);
        authorizationPage.passwordCheckMaskedSignInForm();
    }

    @Test
    public void passwordVisibilitySignInFormTest() {
        startPage.clickHeaderSignInButton();
        authorizationPage.fillInputPasswordSignInForm(validStudent);
        authorizationPage.clickOnEyeInPasswordFieldSignInForm();
        authorizationPage.passwordCheckNotMaskedSignInForm();
    }

    @Test
    public void disabledCopyForHiddenPasswordSignInFormTest() throws IOException, UnsupportedFlavorException {
        startPage.clickHeaderSignInButton();
        authorizationPage.isCopyingDisabledSignInForm(validStudentPassword);
    }

    @Test
    public void disabledCutForHiddenPasswordSignInFormTest() throws IOException, UnsupportedFlavorException {
        startPage.clickHeaderSignInButton();
        authorizationPage.isCuttingDisabledSignInForm(validStudentPassword);
    }

    @Test
    public void checkSignUpButtonInSignInFormTest() {
        startPage.clickHeaderSignInButton();
        authorizationPage.clickSignUpButtonInSignInForm();
        registrationPage.signUpFormIsVisible();
    }
}
