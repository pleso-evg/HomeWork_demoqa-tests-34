import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void formTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Frank");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("franktest@test.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9174849061");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2022");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbies-checkbox-1").parent().$(byText("Sports")).click();
        $("#hobbies-checkbox-3").parent().$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img.jpg");
        $("#currentAddress").setValue("Ufa");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Merrut")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Frank Test"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("franktest@test.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9174849061"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("14 March,2022"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("img.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Ufa"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Merrut"));
    }
}
