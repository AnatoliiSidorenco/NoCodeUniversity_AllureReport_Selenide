package tests;

import org.junit.After;
import org.junit.Before;
import pages.*;
import utils.PropertiesLoader;


public class BaseTest {
    public static ApplicationManager app = new ApplicationManager();

    @Before
    public void setUp() {
        app.init();
    }

    @After
    public void tearDown() {
        app.stop();
    }

    public void pause(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public StartPage startPage = new StartPage();
    public AuthorizationPage authorizationPage = new AuthorizationPage();
    public RegistrationPage registrationPage = new RegistrationPage();
    public HomePage homePage = new HomePage();
    public ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    public static String validTeacherEmail = PropertiesLoader.loadProperties("validTeacherEmail");
    public static String validStudentEmail = PropertiesLoader.loadProperties("validStudentEmail");
    public static String validStudentPassword = PropertiesLoader.loadProperties("validStudentPassword");
    public static String validTeacherPassword = PropertiesLoader.loadProperties("validTeacherPassword");

    public static String nonRegisteredEmail = PropertiesLoader.loadProperties("nonRegisteredEmail");
    public static String nonRegisteredPassword = PropertiesLoader.loadProperties("nonRegisteredPassword");

    public static String inValidUserEmail = PropertiesLoader.loadProperties("inValidUserEmail");
    public static String inValidUserPassword = PropertiesLoader.loadProperties("inValidUserPassword");

    public static User validTeacher = new User(validTeacherEmail, validTeacherPassword);
    public static User validStudent = new User(validStudentEmail, validStudentPassword);
    public static User nonRegisteredUser = new User(nonRegisteredEmail, nonRegisteredPassword);
    public static User invalidUser = new User(inValidUserEmail, inValidUserPassword);
}
