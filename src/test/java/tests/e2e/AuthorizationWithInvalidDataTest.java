package tests.e2e;

import org.junit.Test;
import tests.BaseTest;

public class AuthorizationWithInvalidDataTest extends BaseTest {

    @Test
    public void signInWithNonExistedUserTest() {
        startPage.clickHeaderSignInButton();
        authorizationPage.fillInputEmailSignInForm(nonRegisteredUser);
        authorizationPage.fillInputPasswordSignInForm(nonRegisteredUser);
        authorizationPage.clickSignInButtonInSignInForm();
        authorizationPage.errorMessageSignInForm();
    }

    @Test
    public void signInWithInvalidEmailTest() {
        startPage.clickHeaderSignInButton();
        authorizationPage.fillInputEmailSignInForm(invalidUser);
        authorizationPage.fillInputPasswordSignInForm(validTeacher);
        authorizationPage.clickSignInButtonInSignInForm();
        authorizationPage.errorMessageSignInForm();
    }

    @Test
    public void signInWithInvalidPasswordTest() {
        startPage.clickHeaderSignInButton();
        authorizationPage.fillInputEmailSignInForm(validTeacher);
        authorizationPage.fillInputPasswordSignInForm(invalidUser);
        authorizationPage.clickSignInButtonInSignInForm();
        authorizationPage.errorMessageSignInForm();
    }
}
