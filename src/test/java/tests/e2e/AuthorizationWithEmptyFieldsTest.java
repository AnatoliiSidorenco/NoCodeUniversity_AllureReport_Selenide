package tests.e2e;

import org.junit.Test;
import tests.BaseTest;

public class AuthorizationWithEmptyFieldsTest extends BaseTest {

    @Test
    public void signInWithEmptyFieldsTest() {
        startPage.clickHeaderSignInButton();
        authorizationPage.clickSignInButtonInSignInForm();
        authorizationPage.errorMessageSignInForm();
    }

    @Test
    public void signInWithEmptyFieldEmailTest() {
        startPage.clickHeaderSignInButton();
        authorizationPage.fillInputPasswordSignInForm(validTeacher);
        authorizationPage.clickSignInButtonInSignInForm();
        authorizationPage.errorMessageSignInForm();
    }

    @Test
    public void signInWithEmptyFieldPasswordTest() {
        startPage.clickHeaderSignInButton();
        authorizationPage.fillInputEmailSignInForm(validTeacher);
        authorizationPage.clickSignInButtonInSignInForm();
        authorizationPage.errorMessageSignInForm();
    }
}
