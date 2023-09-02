package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {


    private SelenideElement welcomeSectionForTeacherElement = $x("//p[contains(text(),'As a teacher')]");
    private SelenideElement welcomeSectionForStudentElement = $x("//p[contains(text(),'As a student')]");
    private SelenideElement teacherProfileIconElement = $(byCssSelector("[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7']"));
    private SelenideElement studentProfileIconElement = $(byCssSelector("[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7']"));

    public void getTextForTeacher() {
        welcomeSectionForTeacherElement.shouldHave(text("As a teacher"));
    }

    public void getTextForStudent() {

        welcomeSectionForStudentElement.shouldHave(text("As a student"));
    }
}
